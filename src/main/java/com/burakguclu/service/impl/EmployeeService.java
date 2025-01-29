package com.burakguclu.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.burakguclu.model.Employee;
import com.burakguclu.repository.IEmployeeRepository;
import com.burakguclu.service.IEmployeeService;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private IEmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = employeeRepository.findAll();
		return employeeList;
	}

	@Override
	public Employee getEmployeeByID(Integer id) {
		Optional<Employee> optinial = employeeRepository.findById(id);
		if (optinial.isPresent())
			return optinial.get();
		return null;
	}

	@Override
	public void deleteEmployee(Integer id) {
		Employee tempEmployee = getEmployeeByID(id);
		if (tempEmployee != null)
			employeeRepository.delete(tempEmployee);
	}

	@Override
	public Employee updateEmployee(Integer id, Employee updatedEmployee) {
		Employee tempEmployee = getEmployeeByID(id);
		if (tempEmployee != null) {
			tempEmployee.setFirstName(updatedEmployee.getFirstName());
			tempEmployee.setLastName(updatedEmployee.getLastName());
			tempEmployee.setBirthDate(updatedEmployee.getBirthDate());

			return employeeRepository.save(tempEmployee);
		}
		return null;
	}

}
