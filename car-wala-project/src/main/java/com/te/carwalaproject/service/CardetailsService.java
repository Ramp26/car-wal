package com.te.carwalaproject.service;

import java.util.List;

import com.te.carwalaproject.dto.CarDetails;
import com.te.carwalaproject.model.CarDetailModelInsert;

public interface CardetailsService {

	boolean insertData(CarDetails details);



	boolean removeData(int carId);

	boolean updateData(CarDetails details);

	List<CarDetails> getData2(String companyName);

	CarDetails getData1(String carName);

}
