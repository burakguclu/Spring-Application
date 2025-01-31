package com.burakguclu.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(value = Include.NON_NULL)
public class DtoCustomer {
	private Long id;
	private String name;
	private DtoAddress address;
}
