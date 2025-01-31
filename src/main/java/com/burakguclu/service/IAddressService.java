package com.burakguclu.service;

import com.burakguclu.dto.DtoAddress;

public interface IAddressService {
	public DtoAddress findAddressByID(Long id);
}
