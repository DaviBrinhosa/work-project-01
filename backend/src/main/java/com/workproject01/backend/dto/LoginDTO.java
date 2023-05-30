package com.workproject01.backend.dto;

import com.workproject01.backend.entities.Login;

public class LoginDTO {
	
	private String passwordLogin;
	private String emailLogin;
	
	public LoginDTO() {
	}	
	
	public LoginDTO(Login entity) {
		passwordLogin = entity.getPasswordLogin();
		emailLogin = entity.getEmailLogin();
	}

	public String getPasswordLogin() {
		return passwordLogin;
	}

	public String getEmailLogin() {
		return emailLogin;
	}
	
	
}
