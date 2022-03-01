package com.te.carwalaproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdminAuthenticateRequest {
	
	private String adminUserName;
	private String adminPassword;
}
