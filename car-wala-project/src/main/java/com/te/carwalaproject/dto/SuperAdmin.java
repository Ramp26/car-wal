package com.te.carwalaproject.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="Super_Admin_Table")
public class SuperAdmin implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Identity_Number")
	private int sAdminId;
	@Column(name=" Super_Admin_Name")
	private String sAdminName;
	@Column(name=" Super_Admin_Phone_Number")
    private long sAdminContact_No;
	@Column(name=" Super_Admin_Gmail")
	private String sAdminGmail;
	@Column(name=" Super_Admin_Role")
	private String Role;
	@Column(name=" Super_Admin_UserName")
	private String sAdminUserName;
	@Column(name=" Super_Admin_Password")
	private String sAdminPassword;
	

}
