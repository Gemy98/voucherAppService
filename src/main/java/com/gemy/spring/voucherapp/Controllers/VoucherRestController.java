package com.gemy.spring.voucherapp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gemy.spring.voucherapp.model.Voucher;
import com.gemy.spring.voucherapp.repos.VoucherRepo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/voucherapi")
public class VoucherRestController {

	@Autowired
	VoucherRepo repo ; 
	
	
	@PostMapping("/vouchers")
	public Voucher create(@RequestBody Voucher voucher) {
		//TODO: process POST request
		
		return repo.save(voucher);
	}
	
	
	@GetMapping("/vouchers/{code}")
	public Voucher getVoucher(@PathVariable("code") String code) {
		return repo.findByCode(code);
	}
	
	
	
	
	
	
	
	
}
