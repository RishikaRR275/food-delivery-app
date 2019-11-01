package com.foodDelivery.service;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class SendEmail {
	private MailSender mailSender;
    private SimpleMailMessage templateMessage;

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setTemplateMessage(SimpleMailMessage templateMessage) {
        this.templateMessage = templateMessage;
    }

    public void sendMail(int otp, String email) {
        SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
        msg.setTo(email);
        msg.setText(otp+" is your Swiggy OTP.");
        try{
            this.mailSender.send(msg);
        }
        catch (MailException ex) {
            
            System.err.println(ex.getMessage());
        }
    }

}

