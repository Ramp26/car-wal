package com.te.carwalapro.service;

import java.util.List;

import com.te.carwalapro.dto.Admin;
import com.te.carwalapro.dto.MyAdminDetails;




public interface AdminService {

	boolean regData(Admin admin);

	Admin getData(int adminId);

	boolean loginData(Admin admin);

	MyAdminDetails loadUserByUsername(String adminUserName);

	List<Admin> getData1();

	Admin getAdminId(String adminUserName);

//	List<Admin> getData();
	
	
	

}
