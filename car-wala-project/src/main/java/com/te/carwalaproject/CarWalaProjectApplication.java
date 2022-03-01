package com.te.carwalaproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.te.carwalaproject.dto.CarDetails;
import com.te.carwalaproject.service.CardetailsService;

@SpringBootApplication
public class CarWalaProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarWalaProjectApplication.class, args);
	}

//	CommandLineRunner run(CardetailsService cardetailsService) {
//		return args -> {
//			cardetailsService.insertData(new CarDetails(1, "ram", "sdfds", "ram",True,, null, null, null, null, 0, 0, null, null))
//		};
//		
//	}
}
