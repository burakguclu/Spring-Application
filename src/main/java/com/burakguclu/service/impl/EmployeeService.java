package com.burakguclu.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burakguclu.dto.DtoEmployee;
import com.burakguclu.dto.DtoEmployeeIU;
import com.burakguclu.model.Employee;
import com.burakguclu.repository.IEmployeeRepository;
import com.burakguclu.service.IEmployeeService;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private IEmployeeRepository employeeRepository;

	@Override
	public DtoEmployee saveEmployee(DtoEmployeeIU dtoEmployeeIU) {
		DtoEmployee response = new DtoEmployee();
		
		Employee employee = new Employee();
		BeanUtils.copyProperties(dtoEmployeeIU, employee);
		
		Employee savedEmployee = employeeRepository.save(employee);
		BeanUtils.copyProperties(savedEmployee, response);
		
		return response;
	}

	@Override
	public List<DtoEmployee> getAllEmployees() {
		List<DtoEmployee> response = new ArrayList<>();
		
		List<Employee> employeeList = employeeRepository.findAll();
		
		for(Employee employee : employeeList) {
			DtoEmployee tempDtoEmployee = new DtoEmployee();
			BeanUtils.copyProperties(employee, tempDtoEmployee);
			response.add(tempDtoEmployee);
		}
		
		return response;
	}

	@Override
	public DtoEmployee getEmployeeByID(Integer id) {
		DtoEmployee response = new DtoEmployee();
		
		Optional<Employee> optional = employeeRepository.findById(id);
		if (optional.isPresent()) {
			Employee tempEmployee = optional.get();
			BeanUtils.copyProperties(tempEmployee, response);
			return response;
		}
		return null;
	}

	@Override
	public void deleteEmployee(Integer id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		if (optional.isPresent())
			employeeRepository.delete(optional.get());
	}

	@Override
	public DtoEmployee updateEmployee(Integer id, DtoEmployeeIU dtoEmployeeIU) {
		DtoEmployee response = new DtoEmployee();
		
		Optional<Employee> optional = employeeRepository.findById(id);
		if(optional.isPresent()) {
			Employee tempEmployee = optional.get();
			tempEmployee.setFirstName(dtoEmployeeIU.getFirstName());
			tempEmployee.setLastName(dtoEmployeeIU.getLastName());
			tempEmployee.setBirthDate(dtoEmployeeIU.getBirthDate());

			Employee updatedEmployee = employeeRepository.save(tempEmployee);
			BeanUtils.copyProperties(updatedEmployee, response);
			return response;
		}
		return null;
	}

}
