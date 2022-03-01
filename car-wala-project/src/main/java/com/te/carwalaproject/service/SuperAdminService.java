package com.te.carwalaproject.service;

import com.te.carwalaproject.dto.SuperAdmin;

public interface SuperAdminService {

	boolean regData(SuperAdmin admin);

	SuperAdmin getData(int sAdminId);

	boolean loginData(SuperAdmin admin);
	
	

}
