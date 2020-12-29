package com.assignment.model;

import java.time.LocalDate;

public class Contact {
	
	private String name;
	private String address;
	private Long mobileNumber;
	private String profilePicture;
	private LocalDate dateOfBirth;
	private String email;
	private String  groupName; 
	
	public Contact() {
		super();
		
	}

	public Contact(String name, String address, Long mobileNumber, String profilePicture, LocalDate dateOfBirth,
			String email, String groupName) {
		super();
		this.name = name;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.profilePicture = profilePicture;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.groupName = groupName;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setGroup(String groupName) {
		this.groupName = groupName;
	}

	@Override
	public String toString() {
		return "contact [name=" + name + ", address=" + address + ", mobileNumber=" + mobileNumber + ", profilePicture="
				+ profilePicture + ", dateOfBirth=" + dateOfBirth + ", email=" + email + ", group=" + groupName + "]";
	}
	
	
	
	

}
