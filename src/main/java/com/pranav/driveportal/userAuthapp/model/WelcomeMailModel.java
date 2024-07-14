package com.pranav.driveportal.userAuthapp.model;

public class WelcomeMailModel {
	
	private String title;
	private String to;
	private String message;
	
	public WelcomeMailModel(String title, String to, String message) {
		super();
		this.title = title;
		this.to = to;
		this.message = message;
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
