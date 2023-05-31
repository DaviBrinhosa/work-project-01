package com.work.project01.auth.dto;

import java.io.Serializable;

import com.work.project01.auth.entity.Auth;

public class AuthDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	

	private String passwordLogin;
	
	private String emailLogin;

	public AuthDTO() {
		
	}

	public AuthDTO(String passwordLogin, String emailLogin) {
		this.passwordLogin = passwordLogin;
		this.emailLogin = emailLogin;
	}
	
	public AuthDTO(Auth entity) {
		passwordLogin = entity.getPasswordLogin();
		emailLogin = entity.getEmailLogin();
	}
	
	public String getPasswordLogin() {
		return passwordLogin;
	}

	public void setPasswordLogin(String passwordLogin) {
		this.passwordLogin = passwordLogin;
	}

	public String getEmailLogin() {
		return emailLogin;
	}

	public void setEmailLogin(String emailLogin) {
		this.emailLogin = emailLogin;
	}
}
