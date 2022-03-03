package com.te.carwalapro.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.carwalapro.dto.Admin;
import com.te.carwalapro.jwt.JwtPro;
import com.te.carwalapro.model.AdminAuthenticateRequest;
import com.te.carwalapro.model.AdminAuthenticationResponse;
import com.te.carwalapro.service.AdminService;
import com.te.carwalapro.service.AdminServiceImpl;


@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminController {

	@Autowired
	private AdminServiceImpl adminService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtPro jwtPro;

	@GetMapping("/get/{adminId}")

	public ResponseEntity<?> getData(@PathVariable int adminId) {

		try {
			Admin admin = adminService.getData(adminId);
			return new ResponseEntity<Admin>(admin, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("id is not present ", HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/reg")
	public ResponseEntity<?> registerData(@RequestBody Admin admin) {
		try {
			boolean res = adminService.regData(admin);
			return new ResponseEntity<String>("successfully inserted", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("user name is already used", HttpStatus.BAD_REQUEST);
		}

	}

//	
//	@PostMapping("/login")
//	public ResponseEntity<?> login(@RequestBody Admin admin) {
//		try {
//			Boolean res= adminService.loginData(admin);
//			return new ResponseEntity<String>("login successfull!!", HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<String>(" login Failed",HttpStatus.NO_CONTENT);
//		}
//		
//	}

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
		UserDetails userDetails = adminService.loadUserByUsername(authenticateRequest.getAdminUserName());
	
		String jwt = jwtPro.generateToken(userDetails);
	
		return ResponseEntity.ok(new AdminAuthenticationResponse(jwt,userDetails.getAuthorities()));
	}

}
