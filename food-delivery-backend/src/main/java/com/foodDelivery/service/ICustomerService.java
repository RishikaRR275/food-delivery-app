package com.foodDelivery.service;

import org.springframework.stereotype.Service;

import com.foodDelivery.model.Credentials;
import com.foodDelivery.model.Customer;

@Service
public interface ICustomerService {
	public void sendOTP(String email);
	public String authenticateCustomerLogin(Credentials credentials);	
	public void customerRegistration(Customer customer);
}
