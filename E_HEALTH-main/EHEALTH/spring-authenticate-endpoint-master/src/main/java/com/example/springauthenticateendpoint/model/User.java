package com.example.springauthenticateendpoint.model;

import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

import javax.persistence.*;


@Entity
public class User {


	@javax.persistence.Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String Id;
	
	private String firstName;
	private String lastName;
	private String emailId;
	private String username;
	private String phone;
	private String password;
	private String govermentId;
	

	private String role;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getGovermentId() {
		return govermentId;
	}
	public void setGovermentId(String govermentId) {
		this.govermentId = govermentId;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}


}
