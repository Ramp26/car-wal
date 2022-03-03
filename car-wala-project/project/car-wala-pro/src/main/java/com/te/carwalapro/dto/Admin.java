package com.te.carwalapro.dto;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Admins_Table")
public class Admin implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Identity_Number")
	private int adminId;
	@Column(name = "Admin_Name")
	private String adminName;
	@Column(name = "Admin_Phone_Number")
	private long adminContact_No;
	@Column(name = "Admin_Gmail")
	private String adminGmail;
	@Column(name = "Admin_Role")
	private String role;
	@Column(name = "Admin_User_Name")
	private String adminUserName;
	@Column(name = "Admin_Password")
	private String adminPassword;

//	@OneToMany(mappedBy ="admin" , cascade = CascadeType.ALL)	
//	  @PrimaryKeyJoinColumn(name="carId")
//	  private List<CarDetails> details=new ArrayList<CarDetails>() ;

}
