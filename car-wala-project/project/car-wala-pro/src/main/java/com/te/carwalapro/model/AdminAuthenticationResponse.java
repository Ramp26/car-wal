package com.te.carwalapro.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdminAuthenticationResponse {
	
	private String jwt;
	private  Collection<? extends GrantedAuthority>  adminRole;
}
