package com.te.carwalapro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.te.carwalapro.dao.AdminDao;
import com.te.carwalapro.dto.Admin;
import com.te.carwalapro.dto.MyAdminDetails;

@Service
public class AdminServiceImpl implements AdminService, UserDetailsService {

	@Autowired
	private AdminDao adminDao;

	@Override
	public boolean regData(Admin admin) {
		Admin username = adminDao.findByAdminUserName(admin.getAdminUserName());
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
			return adminDao.findByAdminId(adminId);
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
		Admin admin = adminDao.findByAdminUserName(adminUserName);
		System.out.println(admin);
		return new MyAdminDetails(admin);
	}

	@Override
	public List<Admin> getData1() {

		return adminDao.findAllAdmin();
	}

	@Override
	public Admin getAdminId(String adminUserName) {
		System.out.println(":::>" + adminDao.findByAdminUserName(adminUserName));
		
		return adminDao.findByAdminUserName(adminUserName);
	}

//	@Override
//	public MyAdminDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//		Admin admin = adminDao.findByadminUserName(username);
//
////		Myadmindetail from dto
//		return new MyAdminDetails(admin);
//	}

}
