package com.pranav.driveportal.userAuthapp.model;
 
import java.sql.Date;

public class UserModel {
	
	private String UserName;
	private String Password;
	private String MailId;
	private Long Phoneno;
	private Date DateOfBirth;
	
	public UserModel() {
		super();
	}

	public UserModel(String userName, String mailId, Long phoneno,String Password,Date DateOfBirth) {
		super();
		this.UserName = userName;
		this.MailId = mailId;
		this.Phoneno = phoneno;
		this.Password=Password;
		this.DateOfBirth=DateOfBirth;
		
		
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getMailId() {
		return MailId;
	}

	public void setMailId(String mailId) {
		MailId = mailId;
	}

	public Long getPhoneno() {
		return Phoneno;
	}

	public void setPhoneno(Long phoneno) {
		Phoneno = phoneno;
	}

	@Override
	public String toString() {
		return "UserModel [UserName=" + UserName + ", Password=" + Password + ", MailId=" + MailId + ", Phoneno="
				+ Phoneno + "]";
	}
	
	
	

}
