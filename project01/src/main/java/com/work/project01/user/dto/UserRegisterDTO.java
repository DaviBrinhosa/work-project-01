package com.work.project01.user.dto;

import java.io.Serializable;

import com.work.project01.user.entity.UserRegister;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class UserRegisterDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nameLogin;
	
	private String passwordLogin;
	
	private String emailLogin;

	public UserRegisterDTO() {
		
	}

	public UserRegisterDTO(Long id, String nameLogin, String passwordLogin, String emailLogin) {
		this.id = id;
		this.nameLogin = nameLogin;
		this.passwordLogin = passwordLogin;
		this.emailLogin = emailLogin;
	}
	
	public UserRegisterDTO(UserRegister entity) {
		id = entity.getId();
		nameLogin = entity.getNameLogin();
		passwordLogin = entity.getPasswordLogin();
		emailLogin = entity.getEmailLogin();
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameLogin() {
		return nameLogin;
	}

	public void setNameLogin(String nameLogin) {
		this.nameLogin = nameLogin;
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
