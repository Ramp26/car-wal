package com.te.carwalapro.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.te.carwalapro.dto.CarDetails;



@Repository
public interface CarDetailsDao extends JpaRepository<CarDetails, Integer> {

	public CarDetails findByCarId(int carId);
	
	
	public CarDetails findByCarName( String carName);


	public List<CarDetails> findByCompanyName(String companyName);


	public List<CarDetails> findByFuelType(String fuelType);


	public List<CarDetails> findByAdmin(int adminId);
	
	@Query("from CarDetails where admin.adminId = ?1")
	public List<CarDetails> findAllCarDetailsByAdminId(int adminId);

}
