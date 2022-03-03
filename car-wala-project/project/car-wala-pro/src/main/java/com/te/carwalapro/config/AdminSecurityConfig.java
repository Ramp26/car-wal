package com.te.carwalapro.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.te.carwalapro.dto.MyAdminDetails;
import com.te.carwalapro.filter.JwtRequestFilter;

import com.te.carwalapro.service.AdminService;
import com.te.carwalapro.service.AdminServiceImpl;

import lombok.experimental.PackagePrivate;

@EnableWebSecurity
public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private AdminServiceImpl serviceImpl;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(serviceImpl);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.cors();
		http.authorizeRequests().antMatchers("/car/admins").permitAll();
		http.authorizeRequests().antMatchers("/car/admins/{adminUserName}").permitAll();
		
		http.authorizeRequests().antMatchers("/car/data/{carName}").permitAll();
		http.authorizeRequests().antMatchers("/car/new").permitAll();
		http.authorizeRequests().antMatchers("/car/edit/{carId}").permitAll();
		http.authorizeRequests().antMatchers("/car/data1/{companyName}").permitAll();
		http.authorizeRequests().antMatchers("/car/data2/{fuelType}").permitAll();
		http.authorizeRequests().antMatchers("/admin/login").permitAll();
		http.authorizeRequests().antMatchers("/admin/get/{adminId}").permitAll();
		http.authorizeRequests().antMatchers("/admin/reg").permitAll();
		http.authorizeRequests().anyRequest().authenticated().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();

	}

}
