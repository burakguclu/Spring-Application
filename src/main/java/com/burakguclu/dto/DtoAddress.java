package com.burakguclu.dto;

import lombok.Data;

@Data
public class DtoAddress {
	private Long id;
	private String description;
	private DtoCustomer customer;
}