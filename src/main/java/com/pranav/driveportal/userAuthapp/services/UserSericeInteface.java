package com.pranav.driveportal.userAuthapp.services;

import java.sql.Date;

import org.springframework.stereotype.Service;

@Service
public interface UserSericeInteface {
	
	public String addUserSignUp(String userName,String Password, String mailId, Long phoneno,Date dob) throws Exception;
	public Boolean fetchUserLogin(String userName,String Password);
	public String forgotUnameorPass(String mailid);

}
