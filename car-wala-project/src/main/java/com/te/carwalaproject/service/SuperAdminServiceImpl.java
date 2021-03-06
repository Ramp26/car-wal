package com.te.carwalaproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.te.carwalaproject.dao.SuperAdminDao;
import com.te.carwalaproject.dto.Admin;
import com.te.carwalaproject.dto.MySuperAdminDetails;
import com.te.carwalaproject.dto.SuperAdmin;

@Service
public class SuperAdminServiceImpl implements SuperAdminService,UserDetailsService {
	
	@Autowired
	private SuperAdminDao adminDao;

	@Override
	public boolean regData(SuperAdmin admin) {	
		SuperAdmin username = adminDao.findBysAdminUserName(admin.getSAdminUserName());
		SuperAdmin password = adminDao.findBysAdminPassword(admin.getSAdminPassword());
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
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SuperAdmin admin=adminDao.findBysAdminUserName(username);
		return new MySuperAdminDetails(admin);
	}



	@Override
	public SuperAdmin getData(int sAdminId) {
		if (sAdminId > 0) {
			return (SuperAdmin) adminDao.findBysAdminId(sAdminId);
		}
		return null;
	}



//	@Override
//	public boolean loginData(SuperAdmin admin) {
//		if(admin != null) {
//		SuperAdmin username = adminDao.findBysAdminUserName(admin.getSAdminUserName());
//   System.out.println("login data"+username);
//		SuperAdmin password = adminDao.findBysAdminPassword(admin.getSAdminPassword());
//		if(username.getSAdminId() == password.getSAdminId()) {
//			return true;
//		}
//		return false;
//		}
//		return false;
//	
//	}

}
