package com.te.carwalapro.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdminAuthenticateRequest {
	
	private String adminUserName;
	private String adminPassword;
}
