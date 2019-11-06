package com.foodDelivery.service;

import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.foodDelivery.dao.CustomerRepo;
import com.foodDelivery.model.Credentials;
import com.foodDelivery.model.Customer;

@Service
public class CustomerService implements ICustomerService{
	
	@Autowired
	CustomerRepo customerRepo;
	
	@Autowired
	SendEmail sendEmail;
	
	public void sendOTP(String email) {
		int otp = generateOtp();
		email = email.replaceAll("%40", "@");
        email = email.substring(0, email.length()-1);
		customerRepo.storeOtpInDB(email, otp);
		sendEmail.sendMail(otp, email);	
	}
	
	@ResponseBody
	public String authenticateCustomerLogin(Credentials credentials) {
		String email = credentials.getEmail();
		email = email.replaceAll("%40", "@");
        //email = email.substring(0, email.length()-1);
        System.out.println(email);
		int generatedOtp = customerRepo.getOtpFromDB(email);
		int OtpEnteredByUser = credentials.getOtp();
		System.out.println(generatedOtp +" ---  "+OtpEnteredByUser);
		if(generatedOtp == OtpEnteredByUser)
			return "login success";
		return "invalid credentials";
		
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
