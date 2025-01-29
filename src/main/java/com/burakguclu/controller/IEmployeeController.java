package com.burakguclu.controller;

import java.util.List;

import com.burakguclu.dto.DtoEmployee;
import com.burakguclu.dto.DtoEmployeeIU;

public interface IEmployeeController {
	public DtoEmployee saveEmployee(DtoEmployeeIU dtoEmployeeIU);
	public List<DtoEmployee> getAllEmployees();
	public DtoEmployee getEmployeeByID(Integer id);
	public void deleteEmployee(Integer id);
	public DtoEmployee updateEmployee(Integer id, DtoEmployeeIU dtoEmployeeIU);
}
