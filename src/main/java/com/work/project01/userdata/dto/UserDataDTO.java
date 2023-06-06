package com.work.project01.userdata.dto;

import com.work.project01.userdata.entity.UserData;

public class UserDataDTO {

	private Long id;
	private String name;
	private String password;
	private String email;

	public UserDataDTO() {
		
	}

	public UserDataDTO(Long id, String name, String password, String email) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
	}
	
	public UserDataDTO(UserData entity) {
		id = entity.getId();
		name = entity.getName();
		password = entity.getPassword();
		email = entity.getEmail();
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
}