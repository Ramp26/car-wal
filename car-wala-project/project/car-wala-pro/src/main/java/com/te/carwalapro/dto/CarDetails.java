package com.te.carwalapro.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Car_Detail_Table")
public class CarDetails implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	@ManyToOne()
	@JoinColumn(name = "admin_fk")
	private Admin admin;

}
