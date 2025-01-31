package com.burakguclu.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burakguclu.dto.DtoAddress;
import com.burakguclu.dto.DtoCustomer;
import com.burakguclu.model.Address;
import com.burakguclu.model.Customer;
import com.burakguclu.repository.ICustomerRepository;
import com.burakguclu.service.ICustomerService;

@Service
public class CustomerService implements ICustomerService{

	@Autowired
	private ICustomerRepository customerRepository;
	
	@Override
	public DtoCustomer findCustomerByID(Long id) {
		DtoCustomer responseCustomer = new DtoCustomer();
		DtoAddress responseAddress = new DtoAddress();
		
		Optional<Customer> optional = customerRepository.findById(id);
		if(optional.isPresent()) {
			Customer customer = optional.get();
			Address address = optional.get().getAddress();
			
			BeanUtils.copyProperties(customer, responseCustomer);
			BeanUtils.copyProperties(address, responseAddress);
			
			responseCustomer.setAddress(responseAddress);
			return responseCustomer;
		}
		return null;
	}

}
