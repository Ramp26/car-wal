package com.te.carwalaproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.carwalaproject.dto.Admin;
import com.te.carwalaproject.dto.CarDetails;
import com.te.carwalaproject.dto.MyAdminDetails;
import com.te.carwalaproject.model.CarDetailModelInsert;
import com.te.carwalaproject.service.AdminService;
import com.te.carwalaproject.service.CardetailsService;

@RestController
@RequestMapping("/car")
public class CarController {

	@Autowired
	private CardetailsService cardetailsService;
	@Autowired
	private AdminService adminService;

	@PostMapping("/new")
	public ResponseEntity<?> insertData(@RequestBody CarDetailModelInsert carDetailModelInsert) {
		System.out.println("In controller layer ==> " + carDetailModelInsert);

		CarDetails details = new CarDetails();
		Admin admin = adminService.getData(carDetailModelInsert.getAdminId());
		details.setAdmin(admin);
		details.setBreakSystem(carDetailModelInsert.getBreakSystem());
		details.setCompanyName(carDetailModelInsert.getCompanyName());
		details.setCarName(carDetailModelInsert.getCarName());

		details.setFuelType(carDetailModelInsert.getFuelType());
		details.setPowerSteering(carDetailModelInsert.getPowerSteering());

		details.setShowroom_Price(carDetailModelInsert.getShowroom_Price());
		details.setOnroadPrice(carDetailModelInsert.getOnroadPrice());
		details.setImageURL(carDetailModelInsert.getImageURL());
		details.setMileage(carDetailModelInsert.getMileage());
		details.setSeatingCapacity(carDetailModelInsert.getSeatingCapacity());
		details.setEngineCapacity(carDetailModelInsert.getEngineCapacity());
		details.setGearType(carDetailModelInsert.getGearType());

		try {
			boolean b = cardetailsService.insertData(details);
			System.out.println("hii controller" + b);
			return new ResponseEntity<String>("inserted successfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("invalid data entry", HttpStatus.CHECKPOINT);
		}

	}
	
	
	// search by adminId
//
//	@GetMapping("/adminid")
//
//	public ResponseEntity<?> getData() {
//		System.out.println("company name====>");
//		try {
//			
//			CarDetails carDetails=new CarDetails();
//			Admin admin=new Admin();
////		List<Admin>list=adminService.getData();
//		List<CarDetailModelInsert> service = cardetailsService.getData(list.get);
//			System.out.println(" from controller===>" + service);
//			List<CarDetailModelInsert> modelInserts = new ArrayList<CarDetailModelInsert>();
//			CarDetailModelInsert carDetailModelInsert; 
//			for (CarDetails carDetails : service) {
//				carDetailModelInsert = new CarDetailModelInsert();
//				carDetailModelInsert.setCarId(carDetails.getCarId());
//				carDetailModelInsert.setCarName(carDetails.getCarName());
//				carDetailModelInsert.setCompanyName(carDetails.getCompanyName());
//				carDetailModelInsert.setFuelType(carDetails.getFuelType());
//				carDetailModelInsert.setPowerSteering(carDetails.getPowerSteering());
//				carDetailModelInsert.setBreakSystem(carDetails.getBreakSystem());
//				carDetailModelInsert.setShowroom_Price(carDetails.getShowroom_Price());
//				carDetailModelInsert.setOnroadPrice(carDetails.getOnroadPrice());
//				carDetailModelInsert.setImageURL(carDetails.getImageURL());
//				carDetailModelInsert.setMileage(carDetails.getMileage());
//				carDetailModelInsert.setSeatingCapacity(carDetails.getSeatingCapacity());
//				carDetailModelInsert.setEngineCapacity(carDetails.getEngineCapacity());
//				carDetailModelInsert.setGearType(carDetails.getGearType());
//
//				carDetailModelInsert.setAdminId(carDetails.getAdmin().getAdminId());
//				modelInserts.add(carDetailModelInsert);
//
//			}
//			return ResponseEntity.ok().body(modelInserts);
//		} catch (Exception e) {
//			return new ResponseEntity<String>("id not match", HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//	}

	

	// search by car name

	@GetMapping("/data1/{companyName}")

	public ResponseEntity<?> getData(@PathVariable String companyName) {
		System.out.println("company name====>");
		try {
			List<CarDetails> service = cardetailsService.getData2(companyName);
			System.out.println(" from controller===>" + service);
			List<CarDetailModelInsert> modelInserts = new ArrayList<CarDetailModelInsert>();
			CarDetailModelInsert carDetailModelInsert; 
			for (CarDetails carDetails : service) {
				carDetailModelInsert = new CarDetailModelInsert();
				carDetailModelInsert.setCarId(carDetails.getCarId());
				carDetailModelInsert.setCarName(carDetails.getCarName());
				carDetailModelInsert.setCompanyName(carDetails.getCompanyName());
				carDetailModelInsert.setFuelType(carDetails.getFuelType());
				carDetailModelInsert.setPowerSteering(carDetails.getPowerSteering());
				carDetailModelInsert.setBreakSystem(carDetails.getBreakSystem());
				carDetailModelInsert.setShowroom_Price(carDetails.getShowroom_Price());
				carDetailModelInsert.setOnroadPrice(carDetails.getOnroadPrice());
				carDetailModelInsert.setImageURL(carDetails.getImageURL());
				carDetailModelInsert.setMileage(carDetails.getMileage());
				carDetailModelInsert.setSeatingCapacity(carDetails.getSeatingCapacity());
				carDetailModelInsert.setEngineCapacity(carDetails.getEngineCapacity());
				carDetailModelInsert.setGearType(carDetails.getGearType());

				carDetailModelInsert.setAdminId(carDetails.getAdmin().getAdminId());
				modelInserts.add(carDetailModelInsert);

			}
			return ResponseEntity.ok().body(modelInserts);
		} catch (Exception e) {
			return new ResponseEntity<String>("id not match", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	// search ny carName

	@GetMapping("/data/{carName}")

	public ResponseEntity<?> getData1(@PathVariable String carName) {
		try {
			CarDetails service = cardetailsService.getData1(carName);
			System.out.println(" from controller===>" + service);

			CarDetailModelInsert carDetailModelInsert = new CarDetailModelInsert();
			carDetailModelInsert.setCarId(service.getCarId());
			carDetailModelInsert.setCarName(service.getCarName());
			carDetailModelInsert.setCompanyName(service.getCompanyName());
			carDetailModelInsert.setFuelType(service.getFuelType());
			carDetailModelInsert.setPowerSteering(service.getPowerSteering());
			carDetailModelInsert.setBreakSystem(service.getBreakSystem());
			carDetailModelInsert.setShowroom_Price(service.getShowroom_Price());
			carDetailModelInsert.setOnroadPrice(service.getOnroadPrice());
			carDetailModelInsert.setImageURL(service.getImageURL());
			carDetailModelInsert.setMileage(service.getMileage());
			carDetailModelInsert.setSeatingCapacity(service.getSeatingCapacity());
			carDetailModelInsert.setEngineCapacity(service.getEngineCapacity());
			carDetailModelInsert.setGearType(service.getGearType());

			carDetailModelInsert.setAdminId(service.getAdmin().getAdminId());

			System.out.println("cont===>" + carDetailModelInsert);

//			System.out.println("hiii controller"+service);
			return new ResponseEntity<CarDetailModelInsert>(carDetailModelInsert, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("id not match", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/edit/{carId}")
	public ResponseEntity<?> updateData(@RequestBody CarDetailModelInsert carDetailModelInsert,
			@PathVariable int carId) {

		try {

			CarDetails details = new CarDetails();
			details.setCarId(carId);
			Admin admin = adminService.getData(carDetailModelInsert.getAdminId());
			details.setAdmin(admin);
			details.setBreakSystem(carDetailModelInsert.getBreakSystem());
			details.setCompanyName(carDetailModelInsert.getCompanyName());
			details.setCarName(carDetailModelInsert.getCarName());

			details.setFuelType(carDetailModelInsert.getFuelType());
			details.setPowerSteering(carDetailModelInsert.getPowerSteering());

			details.setShowroom_Price(carDetailModelInsert.getShowroom_Price());
			details.setOnroadPrice(carDetailModelInsert.getOnroadPrice());
			details.setImageURL(carDetailModelInsert.getImageURL());
			details.setMileage(carDetailModelInsert.getMileage());
			details.setSeatingCapacity(carDetailModelInsert.getSeatingCapacity());
			details.setEngineCapacity(carDetailModelInsert.getEngineCapacity());
			details.setGearType(carDetailModelInsert.getGearType());

			cardetailsService.updateData(details);
			return new ResponseEntity<String>("updated successfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("somthiing went wrong", HttpStatus.OK);
		}

	}

	@DeleteMapping("/remove/{carId}")
	public ResponseEntity<?> removeData(@PathVariable int carId) {

		try {
			cardetailsService.removeData(carId);
			return new ResponseEntity<String>("successfully deleted", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("id not found", HttpStatus.BAD_REQUEST);
		}

	}

}
