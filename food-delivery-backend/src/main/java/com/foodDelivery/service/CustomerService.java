package com.foodDelivery.service;

import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.foodDelivery.dao.CustomerRepo;
import com.foodDelivery.model.Credentials;
import com.foodDelivery.model.Customer;

@Service
public class CustomerService implements ICustomerService{
	
	@Autowired
	CustomerRepo customerRepo;
	
	public void sendOTP(String email) {
		int otp = generateOtp();
		SendEmail sendEmail = new SendEmail();
		sendEmail.sendMail(otp, email);	
	}
	
	public void authenticateCustomerLogin(Credentials credentials) {
		
	}
	
	public void customerRegistration(Customer customer) {
		customerRepo.save(customer);
	}
	
	public int generateOtp() {
		int length = 6;
		String numbers = "1234567890";
	      Random random = new Random();
	      String otp = "";

	      for(int i = 0; i< length ; i++) {
	         otp+= ""+ numbers.charAt(random.nextInt(numbers.length()));
	      }
	      return Integer.parseInt(otp);
	}
}
