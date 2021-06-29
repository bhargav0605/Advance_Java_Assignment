package com.phoenix.web.models;

public class LoginBean {
	
	//Data members
	private String username;
	private String password;
	
	//Setters and getters
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsername() {
		return username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	
	//Bussiness logic method
	public boolean isValid() {
		if(username != null 
				&& password != null
				&& username.equals("Thomas")
				&& password.equals("thomas12")) {
			return true;
		} else {
			return false;
		}
	}
} //end of class
