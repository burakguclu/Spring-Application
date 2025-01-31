package com.burakguclu.controller;

import com.burakguclu.dto.DtoCustomer;

public interface ICustomerController {
	public DtoCustomer findCustomerByID(Long id);
}
