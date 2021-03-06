package com.te.carwalaproject.config;

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

import com.te.carwalaproject.dto.MyAdminDetails;
import com.te.carwalaproject.filter.JwtRequestFilter;
import com.te.carwalaproject.filter.JwtSuperAdminFilter;
import com.te.carwalaproject.service.AdminService;
import com.te.carwalaproject.service.AdminServiceImpl;
import com.te.carwalaproject.service.SuperAdminServiceImpl;

import lombok.experimental.PackagePrivate;

@EnableWebSecurity
public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private AdminServiceImpl serviceImpl;

	@Autowired
	private SuperAdminServiceImpl superAdminServiceImpl;
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	@Autowired
	private JwtSuperAdminFilter jwtSuperAdminFilter;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(serviceImpl);
		auth.userDetailsService(superAdminServiceImpl);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().cors().disable().authorizeRequests()
				.antMatchers("/admin/login").permitAll().antMatchers("/new").permitAll().antMatchers("/superadmin/superadmin")
				.permitAll().anyRequest().authenticated().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		http.authorizeRequests().antMatchers("/superadmin/login").permitAll().anyRequest().authenticated().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtSuperAdminFilter, UsernamePasswordAuthenticationFilter.class);

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
