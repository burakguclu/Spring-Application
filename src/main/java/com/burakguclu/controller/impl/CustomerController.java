package com.burakguclu.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.burakguclu.controller.ICustomerController;
import com.burakguclu.dto.DtoCustomer;
import com.burakguclu.service.ICustomerService;

@RestController
@RequestMapping(path = "/rest/api/customer")
public class CustomerController implements ICustomerController{
	
	@Autowired
	private ICustomerService customerService;

	@Override
	@GetMapping(path = "/list/{id}")
	public DtoCustomer findCustomerByID(@PathVariable(name = "id") Long id) {
		return customerService.findCustomerByID(id);
	}
	
}
