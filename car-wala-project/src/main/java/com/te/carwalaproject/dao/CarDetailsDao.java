package com.te.carwalaproject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.te.carwalaproject.dto.CarDetails;

@Repository
public interface CarDetailsDao extends JpaRepository<CarDetails, Integer> {

	public CarDetails findByCarId(int carId);
	
	
	public CarDetails findBycarName( String carName);


	public List<CarDetails> findBycompanyName(String companyName);

}
