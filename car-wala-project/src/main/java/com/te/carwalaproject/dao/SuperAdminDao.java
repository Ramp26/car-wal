package com.te.carwalaproject.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.te.carwalaproject.dto.SuperAdmin;

@Repository
public interface SuperAdminDao extends CrudRepository<SuperAdmin, Integer> {
	public SuperAdmin findBysAdminId(int id);
		
 public SuperAdmin	findBysAdminUserName(String sAdminUserName);
 public SuperAdmin findBysAdminPassword(String sAdminPassword);

}
