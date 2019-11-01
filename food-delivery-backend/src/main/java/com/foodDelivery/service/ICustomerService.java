package com.foodDelivery.service;

import com.foodDelivery.model.Credentials;
import com.foodDelivery.model.Customer;

public interface ICustomerService {
	public void sendOTP(String email);
	public void authenticateCustomerLogin(Credentials credentials);	
	public void customerRegistration(Customer customer);
}
