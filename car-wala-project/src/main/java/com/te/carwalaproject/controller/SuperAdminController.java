package com.te.carwalaproject.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.te.carwalaproject.dto.Admin;
import com.te.carwalaproject.dto.SuperAdmin;
import com.te.carwalaproject.jwt.JwtPro;
import com.te.carwalaproject.model.AdminAuthenticateRequest;
import com.te.carwalaproject.model.AdminAuthenticationResponse;
import com.te.carwalaproject.service.SuperAdminService;

@RestController
@RequestMapping("/superadmin")
public class SuperAdminController {

	@Autowired
	private SuperAdminService superAdminService;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtPro jwtPro;
	
	@GetMapping("/sget/{sAdminId}")
	
	public ResponseEntity<?> getData(@PathVariable int sAdminId) {
		
		try {
			SuperAdmin admin=superAdminService.getData(sAdminId);
			return new ResponseEntity<SuperAdmin>(admin, HttpStatus.OK);
		} catch (Exception e) {
		return new ResponseEntity<String>("id is not present ", HttpStatus.FORBIDDEN);
		}
		
	}
	
	
	
	@PostMapping("/superadmin")
	public ResponseEntity<?> regData(@RequestBody SuperAdmin admin) {
		try {
			superAdminService.regData(admin);
			return new ResponseEntity<String>("registered  Successfull!!", HttpStatus.OK);
		} catch (Exception e) {
		return new ResponseEntity<String>("username or password already used", HttpStatus.FORBIDDEN);
		}

	}
//	
//	@PostMapping("/login")	
////	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<?> login( @RequestBody SuperAdmin admin) {
//		   
//		try {
//			superAdminService.loginData(admin);
//			return new ResponseEntity<String>("login is Success", HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<String>("login failed", HttpStatus.OK);
//		}
//		
//		
//		
//	}
//	
	
	
	@PostMapping("/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AdminAuthenticateRequest authenticateRequest)
			throws Exception {
		System.out.println("In createAuthenticationToken()!");
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				authenticateRequest.getAdminUserName(), authenticateRequest.getAdminPassword()));
//		try {
//			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//					authenticateRequest.getAdminUserName(), authenticateRequest.getAdminPassword()));
//		} catch (Exception e) {
//			throw new Exception("Invalid username and password" + e);
//		}
		UserDetails userDetails = superAdminService.loadUserByUsername(authenticateRequest.getAdminUserName());
		String jwt = jwtPro.generateToken(userDetails);
		return ResponseEntity.ok(new AdminAuthenticationResponse(jwt));
	}

	
	

}
