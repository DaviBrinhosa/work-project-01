package com.workproject01.backend.entities;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_login")
public class Login {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "login_id", nullable=false)
	private Long idLogin;
	
	@Column(name = "fullname", nullable=false)
	private String fullnameLogin;
	
	@Column(name = "password", nullable=false)
	private String passwordLogin;
	
	@Column(name = "email", nullable=false)
	private String emailLogin;
	
	public Login() {
	}

	public Login(Long idLogin, String usernameLogin, String fullnameLogin, String passwordLogin, String emailLogin,
			String genreLogin, Date birthdateLogin, String userPrivilegeLogin, String statusLogin,
			Date inactivedateLogin) {
		this.idLogin = idLogin;
		this.fullnameLogin = fullnameLogin;
		this.passwordLogin = passwordLogin;
		this.emailLogin = emailLogin;
	}

	public Long getIdLogin() {
		return idLogin;
	}

	public void setIdLogin(Long idLogin) {
		this.idLogin = idLogin;
	}

	public String getFullnameLogin() {
		return fullnameLogin;
	}

	public void setFullnameLogin(String fullnameLogin) {
		this.fullnameLogin = fullnameLogin;
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

	@Override
	public int hashCode() {
		return Objects.hash(emailLogin, idLogin);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Login other = (Login) obj;
		return Objects.equals(emailLogin, other.emailLogin) && Objects.equals(idLogin, other.idLogin);
	}
	
}
