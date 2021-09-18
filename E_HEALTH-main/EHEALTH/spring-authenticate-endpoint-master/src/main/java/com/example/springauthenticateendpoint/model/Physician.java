package com.example.springauthenticateendpoint.model;


public class Physician {
	
	
	private String physicianId;

	private String firstName;

	private String lastName;

	private String email;
	private String username;
	private String phone;
	private String password;
	private String govermentId;
	private String speciality;
	public String getPhysicainId() {
		return physicianId;
	}
	public Physician() {}
	public Physician(String physicianId, String firstName, String lastName, String email, String speciality,String username, String phone)
	{
		this.physicianId = physicianId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.speciality = speciality;
		this.username = username;
		this.phone = phone;
	}

	public void setPhysicainId(String physicianId) {
		this.physicianId = physicianId;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGovermentId() {
		return govermentId;
	}
	public void setGovermentId(String govermentId) {
		this.govermentId = govermentId;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

}

