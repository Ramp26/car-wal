package com.te.carwalaproject.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.te.carwalaproject.dao.AdminDao;
import com.te.carwalaproject.dto.Admin;
import com.te.carwalaproject.dto.MyAdminDetails;

@Service
public class AdminServiceImpl implements AdminService, UserDetailsService {

	@Autowired
	private AdminDao adminDao;

	@Override
	public boolean regData(Admin admin) {
		Admin username = adminDao.findByadminUserName(admin.getAdminUserName());
		Admin password = adminDao.findByadminPassword(admin.getAdminPassword());
		System.out.println(username);
		System.out.println(password);
		System.out.println("hii out side");
		if (username == null && password == null) {
			System.out.println("hii inside !!!!!");
			adminDao.save(admin);

			return true;
		} else {
			return false;
		}

	}

	@Override
	public Admin getData(int adminId) {

		if (adminId > 0) {
			return adminDao.findByadminId(adminId);
		}
		return null;
	}

	@Override
	public boolean loginData(Admin admin) {
//		if(admin != null) {
//			Admin username = adminDao.findByadminUserName(admin.getAdminUserName());
//			Admin password = adminDao.findByadminPassword(admin.getAdminPassword());
//			System.out.println(username);
//			System.out.println(password);
//			System.out.println("hii out side");
//	
//  if(username.getAdminId()==password.getAdminId()) {
//	  return true;
//	  
//  } 
//		}
		return false;
	}


	@Override
	public MyAdminDetails loadUserByUsername(String adminUserName) {
		Admin admin = adminDao.findByadminUserName(adminUserName);
		return new MyAdminDetails(admin);
	}

//	@Override
//	public List<Admin> getData() {
//		@Query("SELECT adminId FROM Admin adminId " )
//		return List<Admin> adminDao.findAll();
//	}
//		
	
	

//	@Override
//	public MyAdminDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//		Admin admin = adminDao.findByadminUserName(username);
//
////		Myadmindetail from dto
//		return new MyAdminDetails(admin);
//	}

}
