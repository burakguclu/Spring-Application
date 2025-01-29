package com.burakguclu.controller;

import java.util.List;

import com.burakguclu.model.Employee;

public interface IEmployeeController {
	public Employee saveEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public Employee getEmployeeByID(Integer id);
}
