package com.work.project01.address.dto;

import com.work.project01.address.entity.Address;

public class AddressDTO {

	private Long id;
	private String zipCode; 
	private String streetAddress;
	private String buildingNumber;
	private String complement;
	private String district;
	private String city;
	private String region;
    //private UserData user;
    //private Contact contact;
	   
	public AddressDTO() {
	}

	public AddressDTO(Long id, String zipCode, String streetAddress, String buildingNumber, String complement,
			String district, String city, String region/*, UserData user, Contact contact*/) {
		this.id = id;
		this.zipCode = zipCode;
		this.streetAddress = streetAddress;
		this.buildingNumber = buildingNumber;
		this.complement = complement;
		this.district = district;
		this.city = city;
		this.region = region;
		//this.user = user;
		//this.contact = contact;
	}
	
	public AddressDTO(Address address) {
		id = address.getId();
		zipCode = address.getZipCode();
		streetAddress = address.getStreetAddress();
		buildingNumber = address.getBuildingNumber();
		complement = address.getComplement();
		district = address.getDistrict();
		city = address.getCity();
		region = address.getRegion();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getBuildingNumber() {
		return buildingNumber;
	}

	public void setBuildingNumber(String buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	/*public UserData getUser() {
		return user;
	}

	public void setUser(UserData user) {
		this.user = user;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}*/
}
