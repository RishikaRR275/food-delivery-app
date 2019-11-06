package com.foodDelivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class SendEmail {
//	private MailSender mailSender;
//    private SimpleMailMessage templateMessage;
//
//    public void setMailSender(MailSender mailSender) {
//        this.mailSender = mailSender;
//    }
//
//    public void setTemplateMessage(SimpleMailMessage templateMessage) {
//        this.templateMessage = templateMessage;
//        System.out.print(this.templateMessage);
//    }
	private JavaMailSender mailSender;
	
	@Autowired
	public SendEmail(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	

    public void sendMail(int otp, String email) {
        SimpleMailMessage msg = new SimpleMailMessage();  
        msg.setTo(email);
        msg.setFrom("rishika.blue27@gmail.com");
        msg.setSubject("Swiggy OTP");
        msg.setText(otp+" is your Swiggy OTP.");
        try{
            mailSender.send(msg);
        }
        catch (MailException ex) {
            
            System.err.println(ex.getMessage());
        }
    }

}

