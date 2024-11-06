package com.gemy.spring.voucherapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gemy.spring.voucherapp.model.User;
import com.gemy.spring.voucherapp.repos.UserRepo;

@Service
public class UserDetailsServiceVouch implements UserDetailsService {

	
	@Autowired
	UserRepo userRepo ; 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepo.findByEmail(username);
		if(user != null) {
			
			return new org.springframework.security.core.userdetails.User(
					user.getEmail(),
					user.getPassword(),
					user.getRoles());
		}
		else {
			
			throw new UsernameNotFoundException(" User not found "+username);
		}
	}
	
	
	
	

}
