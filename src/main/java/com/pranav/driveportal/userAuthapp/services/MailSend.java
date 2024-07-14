package com.pranav.driveportal.userAuthapp.services;

import org.springframework.stereotype.Service;

import com.pranav.driveportal.userAuthapp.model.WelcomeMailModel;
import com.pranav.driveportal.userAuthapp.proxy.FeignClientforwelcomemail;


@Service
public class MailSend {
	
	
	private final FeignClientforwelcomemail mailSenderInst;
	
	public MailSend(FeignClientforwelcomemail mailSenderInst) {
		super();
		this.mailSenderInst = mailSenderInst;
	}

	public String generateWelcomeMail(String to,String name,String uname) {
		
		
		String title="Welcome to FileVista - Your Ultimate File Management Solution!";
		
		
		String msg ="Welcome to FileVista "+name+"\nYour username for FileVista is "+uname;
		
		
		
		String retmsgg = mailSenderInst.sendMail(to,title,msg);
		
		return retmsgg;
		
	}
	
	public void forgotPassMail(String to,String Pass) {
		
		String title = "Reset FileVista Password";
		
		String message = "The new System Generated password is: "+Pass;
		
		mailSenderInst.sendMail(to, title, message);
		
	}

}
