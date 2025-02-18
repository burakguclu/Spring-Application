package com.burakguclu.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.burakguclu.controller.IEmployeeController;
import com.burakguclu.dto.DtoEmployee;
import com.burakguclu.dto.DtoEmployeeIU;
import com.burakguclu.service.IEmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/employee")
public class EmployeeController implements IEmployeeController{

	@Autowired
	private IEmployeeService employeeService;
	
	@PostMapping(path = "/save")
	@Override
	public DtoEmployee saveEmployee(@RequestBody @Valid DtoEmployeeIU dtoEmployeeIU) {
		return employeeService.saveEmployee(dtoEmployeeIU);
	}

	@DeleteMapping(path = "/delete/{id}")
	@Override
	public void deleteEmployee(@PathVariable(name = "id") Integer id) {
		employeeService.deleteEmployee(id);
	}

	@PutMapping(path = "/update/{id}")
	@Override
	public DtoEmployee updateEmployee(@PathVariable(name = "id") Integer id, @RequestBody DtoEmployeeIU dtoEmployeeIU) {
		return employeeService.updateEmployee(id, dtoEmployeeIU);
	}

	@GetMapping(path = "/list")
	@Override
	public List<DtoEmployee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	
	@GetMapping(path = "/list/id/{id}")
	@Override
	public DtoEmployee getEmployeeByID(@PathVariable(name = "id") Integer id) {
		return employeeService.getEmployeeByID(id);
	}

	@GetMapping(path = "/list/name/{name}")
	@Override
	public DtoEmployee getEmployeeByName(@PathVariable(name = "name") String name) {
		return employeeService.getEmployeeByName(name);
	}
	
}
