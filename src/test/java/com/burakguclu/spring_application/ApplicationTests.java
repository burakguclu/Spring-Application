package com.burakguclu.spring_application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.burakguclu.dto.DtoEmployee;
import com.burakguclu.dto.DtoEmployeeIU;
import com.burakguclu.service.IEmployeeService;

@SpringBootTest(classes = {Application.class})
class ApplicationTests {

	private DtoEmployeeIU tempEmp;
	
	@Autowired
	private IEmployeeService employeeService;
	
	@BeforeEach
	public void beforeAll() {
		tempEmp = new DtoEmployeeIU();
		tempEmp.setFirstName("test");
		tempEmp.setLastName("test");
		tempEmp.setBirthDate(new Date(1971, 1, 1));
	}
	
	@Test
	public void testSaveEmployee() {
		DtoEmployee saveEmployee = employeeService.saveEmployee(tempEmp);
		assertEquals("test", saveEmployee.getFirstName());
		assertEquals("test", saveEmployee.getLastName());
	}
	
	@Test
	public void testGetAllEmployees() {
		List<DtoEmployee> allEmployees = employeeService.getAllEmployees();
		assertNotNull(allEmployees);
	}
	
	@Test
	public void testGetEmployeeByID() {
		DtoEmployee employeeByID = employeeService.getEmployeeByID(1);
		assertNotNull(employeeByID);
	}
	
	@Test
	public void testGetEmployeeByName() {
		DtoEmployee employeeByName = employeeService.getEmployeeByName("test");
		assertNotNull(employeeByName);
	}

	@AfterEach
	public void afterEach() {
		employeeService.deleteEmployee(3);
	}
}
