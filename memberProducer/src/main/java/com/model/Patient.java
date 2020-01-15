package com.model;

public class Patient {
	private int patientId;
	private String name;
	private int contact;
	private String gender;
	
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Patient(int patientId,String name,int contact,String gender) {
		this.patientId=patientId;
		this.name=name;
		this.gender=gender;
		this.contact=contact;
	}
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", name=" + name + ", contact=" + contact + ", gender=" + gender
				+ "]";
	}
	public Patient() {
		super();
	}
	
	

}
