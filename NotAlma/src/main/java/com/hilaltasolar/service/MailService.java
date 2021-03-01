package com.hilaltasolar.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.hilaltasolar.notalma.HomeController;

@Service
public class MailService {

	 @Autowired
	 private JavaMailSender mailSender;
	 
	 public void registerMail(String mail,String key){
		 
		 try {
			SimpleMailMessage email = new SimpleMailMessage();
			 email.setFrom("NotAlma90@gmail.com");
			 email.setTo(mail);
			 email.setSubject("Üyeliði Tamamla");
			 email.setText("Üyeliði tamamlamak için aþaðýdaki linke týklayýnýz.\n\n"
					 	+HomeController.url+"/reg/"+key);
			 mailSender.send(email);
		} catch (MailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
	
}