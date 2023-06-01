package com.work.project01.userdata.dto;

import java.io.Serializable;

import com.work.project01.userdata.entity.UserData;

public class UserDataLoginDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String password;
	
	private String email;

	public UserDataLoginDTO() {
		
	}

	public UserDataLoginDTO(String password, String email) {
		this.password = password;
		this.email = email;
	}
	
	public UserDataLoginDTO(UserData entity) {
		password = entity.getPassword();
		email = entity.getEmail();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
