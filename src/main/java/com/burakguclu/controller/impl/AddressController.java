package com.burakguclu.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.burakguclu.controller.IAddressController;
import com.burakguclu.dto.DtoAddress;
import com.burakguclu.service.IAddressService;

@RestController
@RequestMapping(path = "/rest/api/address")
public class AddressController implements IAddressController {

	@Autowired
	private IAddressService addressService;
	
	@Override
	@GetMapping(path = "/list/{id}")
	public DtoAddress findAddressByID(@PathVariable(name = "id") Long id) {
		return addressService.findAddressByID(id);
	}
}
