package com.te.carwalapro.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.carwalapro.dao.CarDetailsDao;
import com.te.carwalapro.dto.CarDetails;




@Service
public class CardetailsServiceImpl implements CardetailsService {

	@Autowired
	private CarDetailsDao carDetailsDao;

	@Override
	public boolean insertData(CarDetails details) {
	System.out.println("In service layer ==> " + details);
		carDetailsDao.save(details);
		return true;
	}

	@Override
	public CarDetails getData1(String carName) {
    System.out.println( carDetailsDao.findByCarName(carName));
		return (CarDetails) carDetailsDao.findByCarName(carName);

	}

	@Override
	public boolean removeData(int carId) {
		if (carId > 0) {

			CarDetails carDetails = carDetailsDao.findByCarId(carId);
			carDetailsDao.delete(carDetails);
			return true;

		}
		return false;
	}

	//search by id
	@Override
	public boolean updateData(CarDetails carDetails) {
		if (carDetails != null) {

		CarDetails carDetails2=	carDetailsDao.save(carDetails);
			return true;
		}
		return false;

	}
		//search by carname
	@Override
	public List<CarDetails> getData2(String companyName) {
		// List<CarDetails> findBycompanyName = carDetailsDao.findBycompanyName(companyName);
		return carDetailsDao.findByCompanyName(companyName);
	}

	@Override
	public CarDetails getData2(int carId) {
		
		return carDetailsDao.findByCarId(carId);
	}

	@Override
	public List<CarDetails> getData3(String fuelType) {
		
		return carDetailsDao.findByFuelType(fuelType);
	}

	@Override
	public List<CarDetails> getCars(int adminId) {
	
		// return carDetailsDao.findByAdmin(adminId);
		return carDetailsDao.findAllCarDetailsByAdminId(adminId);
	}

	

	
}
