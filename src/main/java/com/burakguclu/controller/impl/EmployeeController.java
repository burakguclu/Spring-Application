package com.burakguclu.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.burakguclu.controller.IEmployeeController;
import com.burakguclu.model.Employee;
import com.burakguclu.service.IEmployeeService;
import com.burakguclu.service.impl.EmployeeService;

@RestController
@RequestMapping("/rest/api/employee")
public class EmployeeController implements IEmployeeController{

	@Autowired
	private IEmployeeService employeeService;
	
	@PostMapping(path = "/save")
	@Override
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}

	@GetMapping(path = "/list")
	@Override
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

}
