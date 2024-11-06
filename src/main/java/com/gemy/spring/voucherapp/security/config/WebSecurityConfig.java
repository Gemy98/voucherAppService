package com.gemy.spring.voucherapp.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

	
	@Bean 
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.httpBasic();
		http.authorizeHttpRequests()
		.requestMatchers(HttpMethod.GET , "/voucherapi/vouchers/**")
		.hasAnyRole("USER","ADMIN")
		.requestMatchers(HttpMethod.POST,"/vouchersapi/vouchers")
		.hasRole("ADMIN")
		.and().csrf().disable();
		return null ; 
	}
	
	
}
