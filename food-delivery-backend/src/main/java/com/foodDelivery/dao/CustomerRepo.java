package com.foodDelivery.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.foodDelivery.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{
	@Transactional
	@Modifying
	@Query("update Customer cus set cus.otp= ?2 where email = ?1")
	int storeOtpInDB(String email, Integer otp);
	
	@Query("select otp from Customer where email=?1")
	int getOtpFromDB(String email);
}

