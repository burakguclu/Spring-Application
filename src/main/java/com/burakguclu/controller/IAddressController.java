package com.burakguclu.controller;

import com.burakguclu.dto.DtoAddress;

public interface IAddressController {
	public DtoAddress findAddressByID(Long id);
}
