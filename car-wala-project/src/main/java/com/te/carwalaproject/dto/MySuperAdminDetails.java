package com.te.carwalaproject.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MySuperAdminDetails implements UserDetails {
	
	@Autowired
	private SuperAdmin admin;
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		SimpleGrantedAuthority authority=new SimpleGrantedAuthority(admin.getRole());
		
		List<SimpleGrantedAuthority> list=new ArrayList<SimpleGrantedAuthority>();
		
		return list;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return admin.getSAdminPassword() ;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return admin.getSAdminUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
