package com.te.carwalapro.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.te.carwalapro.dto.Admin;

@Repository
public interface AdminDao extends JpaRepository<Admin, Integer> {

	public Admin findByAdminId(int id);


	public Admin findByadminPassword(String adminPassword);

	@Query("from Admin as a where a.role=?1")
	List<Admin> findAllAdmin();
	
	@Query("from Admin as a where a.adminUserName = ?1")
	Admin findByAdminUserName(String adminUserName);

		public Admin findByadminUserName(String username);

}
