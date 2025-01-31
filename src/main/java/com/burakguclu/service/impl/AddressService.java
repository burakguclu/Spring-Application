package com.burakguclu.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burakguclu.dto.DtoAddress;
import com.burakguclu.dto.DtoCustomer;
import com.burakguclu.model.Address;
import com.burakguclu.model.Customer;
import com.burakguclu.repository.IAddressRepository;
import com.burakguclu.service.IAddressService;

@Service
public class AddressService implements IAddressService{

	@Autowired
	private IAddressRepository addressRepository;
	
	@Override
	public DtoAddress findAddressByID(Long id) {
		DtoAddress responseAddress = new DtoAddress();
		DtoCustomer responseCustomer = new DtoCustomer();
		
		Optional<Address> optional = addressRepository.findById(id);
		if(optional.isPresent()) {
			Address address = optional.get();
			Customer customer = optional.get().getCustomer();
			
			BeanUtils.copyProperties(address, responseAddress);
			BeanUtils.copyProperties(customer, responseCustomer);
			
			responseAddress.setCustomer(responseCustomer);
			return responseAddress;
		}
	
		return null;
	}
}
