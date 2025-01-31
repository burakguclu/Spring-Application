package com.burakguclu.service;

import com.burakguclu.dto.DtoCustomer;

public interface ICustomerService {
	public DtoCustomer findCustomerByID(Long id);
}
