package com.pranav.driveportal.userAuthapp.controller;

import java.sql.Date;
import java.sql.SQLException;

import com.pranav.driveportal.userAuthapp.services.JdbcDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pranav.driveportal.userAuthapp.services.MailSend;
import com.pranav.driveportal.userAuthapp.services.UserSerivce;

@RestController
@CrossOrigin
@RequestMapping("/signup-asNewUser")
public class USerController {
	
	//http://localhost:8000/signup-asNewUser/PRANAV V/MexicanBrahmin/pranav8660@gmail.com/2003-05-29/9874561842
	
	@Autowired
	private UserSerivce serv;
	
	@Autowired
	private MailSend mailSender;

	@Autowired
	private JdbcDatabase jdbcinst;
	
	@GetMapping("/{uname}/{pass}/{mailid}/{dob}/{pno}")
	public String addUserieSignup(@PathVariable String uname,@PathVariable String pass,
			@PathVariable String mailid,@PathVariable Date dob,@PathVariable Long pno) throws Exception {
		
		String message = serv.addUserSignUp(uname, pass, mailid, pno, dob);
		
		mailSender.generateWelcomeMail(mailid, uname, message);
		
		return "Signup successful, your username is being sent to ur respective mail id";
	}
	
	
	@GetMapping("/{uname}/{pass}")
	public boolean loginUserieSignIn(@PathVariable String uname,@PathVariable String pass) {
		
		Boolean res = serv.fetchUserLogin(uname, pass);
		
		if(res) {
			return true;
		}
		return false;
	}
	
	@PutMapping("/EmailId/{mailId}")
	public String changePassieForgotPass(@PathVariable String mailId) {
		
		String retVal = serv.forgotUnameorPass(mailId);
		
		if(!retVal.equals("")) {
			mailSender.forgotPassMail(mailId, retVal);
			return "Please check your mail id for a new system-generated Password !";
		}
		return "The entered Email-id is not registered, please SIGNUP for using FileVista!";
		
	}


	@CrossOrigin
	@PutMapping("/{username}/{fileid}/{filetype}/{filesize}")
	public String addFileData(@PathVariable String username,@PathVariable String fileid,@PathVariable String filetype,@PathVariable String filesize) throws SQLException, ClassNotFoundException {
		return jdbcinst.addfileCriteria(username,fileid,filetype,filesize);
	}
	
	

}
