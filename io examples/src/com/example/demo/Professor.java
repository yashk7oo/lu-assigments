package com.example.demo;

import java.io.Serializable;

public class Professor implements Serializable {

	 private int id;
	 private String firstName;
	 private String department;
	 private String qualification;
	/**
	 * 
	 */
	public Professor() {
	
	}
	/**
	 * @param id
	 * @param firstName
	 * @param department
	 * @param qualification
	 */
	public Professor(int id, String firstName, String department, String qualification) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.department = department;
		this.qualification = qualification;
	}
	public int getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getDepartment() {
		return department;
	}
	public String getQualification() {
		return qualification;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	
	
	
	 
	
	 
}
