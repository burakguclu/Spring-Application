package com.burakguclu.service;

import java.util.List;

import com.burakguclu.model.Employee;

public interface IEmployeeService {
	public Employee saveEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public Employee getEmployeeByID(Integer id);
	public void deleteEmployee(Integer id);
}
