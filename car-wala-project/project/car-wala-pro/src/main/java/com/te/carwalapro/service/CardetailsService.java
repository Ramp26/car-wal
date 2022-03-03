package com.te.carwalapro.service;

import java.util.List;

import com.te.carwalapro.dto.CarDetails;
import com.te.carwalapro.model.CarDetailModelInsert;

public interface CardetailsService {

	boolean insertData(CarDetails details);

	boolean removeData(int carId);

	boolean updateData(CarDetails details);

	List<CarDetails> getData2(String companyName);

	CarDetails getData1(String carName);

	CarDetails getData2(int carId);

	List<CarDetails> getData3(String fuelType);

	List<CarDetails> getCars(int adminId);

}
