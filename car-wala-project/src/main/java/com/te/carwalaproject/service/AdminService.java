package com.te.carwalaproject.service;

import java.util.List;

import com.te.carwalaproject.dto.Admin;
import com.te.carwalaproject.dto.MyAdminDetails;

public interface AdminService {

	boolean regData(Admin admin);

	Admin getData(int adminId);

	boolean loginData(Admin admin);

	MyAdminDetails loadUserByUsername(String adminUserName);

//	List<Admin> getData();
	
	
	

}
