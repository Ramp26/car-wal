package com.te.carwalaproject.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.te.carwalaproject.dto.Admin;

@Repository
public interface AdminDao extends CrudRepository<Admin, Integer> {
	
	public Admin findByadminId(int id);

	public Admin findByadminUserName(String adminUserName);

	public Admin findByadminPassword(String adminPassword);

	

	
//		public Admin findByadminUserName(String username);
	

}
