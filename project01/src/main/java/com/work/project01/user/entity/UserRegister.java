package com.work.project01.user.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_data")
public class UserRegister implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String nameLogin;
	
	@Column(name = "password")
	private String passwordLogin;
	
	@Column(name = "email")
	private String emailLogin;

	public UserRegister() {
		
	}

	public UserRegister(Long id, String nameLogin, String passwordLogin, String emailLogin) {
		this.id = id;
		this.nameLogin = nameLogin;
		this.passwordLogin = passwordLogin;
		this.emailLogin = emailLogin;
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

