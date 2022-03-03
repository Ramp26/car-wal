package com.te.carwalapro.model;

import lombok.Data;

@Data
public class CarDetailModelInsert {
	private int carId;
	private String carName;
	private String companyName;
	private String fuelType;
	private Boolean powerSteering;
	private String breakSystem;
	private Double showroom_Price;
	private Double onroadPrice;
	private String imageURL;
	private Double Mileage;
	private int seatingCapacity;
	private int engineCapacity;
	private String gearType;
	private int adminId;
}
