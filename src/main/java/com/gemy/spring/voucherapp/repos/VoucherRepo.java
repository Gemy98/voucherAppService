package com.gemy.spring.voucherapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gemy.spring.voucherapp.model.Voucher;

public interface VoucherRepo extends JpaRepository<Voucher, Long> {

	Voucher findByCode(String code);

}
