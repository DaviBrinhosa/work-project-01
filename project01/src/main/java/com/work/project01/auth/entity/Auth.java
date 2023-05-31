package com.work.project01.auth.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "auth")
public class Auth implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "password")
	private String passwordLogin;
	
	@Column(name = "email")
	private String emailLogin;

	public Auth() {
		
	}

	public Auth(String passwordLogin, String emailLogin) {
		this.passwordLogin = passwordLogin;
		this.emailLogin = emailLogin;
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

