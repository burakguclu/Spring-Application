package com.burakguclu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.burakguclu.model.Employee;
import com.burakguclu.repository.IEmployeeRepository;
import com.burakguclu.service.IEmployeeService;

@Service
public class EmployeeService implements IEmployeeService{

	@Autowired
	private IEmployeeRepository employeeRepository;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee>  getAllEmployees() {
		List<Employee> employeeList = employeeRepository.findAll();
		return employeeList;
	}


}
