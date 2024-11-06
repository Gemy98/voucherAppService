package com.gemy.spring.voucherapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gemy.spring.voucherapp.model.User;
import java.util.List;


public interface UserRepo extends JpaRepository<User, Long> {

	
	User findByEmail(String email);
	
	
}
