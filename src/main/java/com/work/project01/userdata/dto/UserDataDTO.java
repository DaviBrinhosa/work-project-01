package com.work.project01.userdata.dto;

import java.util.Date;

import com.work.project01.userdata.entity.UserData;

public class UserDataDTO {

	private Long id;
	private String name;
	private String password;
	private String email;
	private String username;
	private String genre;
	private Date birthdate;
	private String userPrivilege;
	private String status;
	private Date inactiveDate;

	public UserDataDTO() {
		
	}

	public UserDataDTO(Long id, String name, String password, String email, String username, String genre, Date birthdate,
			String userPrivilege, String status, Date inactiveDate) {
		if (id != null) {
	        this.id = id;
	    }
		this.name = name;
		this.password = password;
		this.email = email;
		this.username = username;
		this.genre = genre;
		this.birthdate = birthdate;
		this.userPrivilege = userPrivilege;
		this.status = status;
		this.inactiveDate = inactiveDate;
	}

	public UserDataDTO(UserData entity) {
		id = entity.getId();
		name = entity.getName();
		password = entity.getPassword();
		email = entity.getEmail();
		username = entity.getUsername();
		genre = entity.getGenre();
		birthdate = entity.getBirthdate();
		userPrivilege = entity.getUserPrivilege();
		status = entity.getStatus();
		inactiveDate = entity.getInactiveDate();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getUserPrivilege() {
		return userPrivilege;
	}

	public void setUserPrivilege(String userPrivilege) {
		this.userPrivilege = userPrivilege;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getInactiveDate() {
		return inactiveDate;
	}

	public void setInactiveDate(Date inactiveDate) {
		this.inactiveDate = inactiveDate;
	}
}