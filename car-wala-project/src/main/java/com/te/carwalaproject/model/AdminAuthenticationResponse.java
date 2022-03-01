package com.te.carwalaproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdminAuthenticationResponse {
	
	private String jwt;
}
