package com.work.project01.contact.dto;

import com.work.project01.address.dto.AddressDTO;
import com.work.project01.contact.entity.Contact;

public class ContactDTO {

	private Long id;
	private String name;
	private String cellphone;
	private String email;
	private AddressDTO address;
	
	public ContactDTO() {
	}
	
	public ContactDTO(Contact contact) {
		id = contact.getId();
		name = contact.getName();
		cellphone = contact.getCellphone();
		email = contact.getEmail();
		this.address = new AddressDTO(contact.getAddress());
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
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}
}
