package com.foodDelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodDelivery.model.Credentials;
import com.foodDelivery.model.Customer;
import com.foodDelivery.service.ICustomerService;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {
	@Autowired
	ICustomerService customerService;
	
	@PostMapping("/gen-login-otp")
	public void sendLoginOtp(@RequestBody String email) {
		customerService.sendOTP(email);
	}
	
	@PostMapping("/auth-customer")
	public String AuthenticateCustomerLogin(@RequestBody Credentials credentials) {
		return customerService.authenticateCustomerLogin(credentials);
	}
	
	@PostMapping("/register-customer")
	public void customerRegistration(@RequestBody Customer customer) {
		customerService.customerRegistration(customer);
	}
	
	

}
