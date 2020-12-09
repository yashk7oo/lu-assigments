package com.example.model;

//public final class Employee {
public class Employee {
	
	private int id;
	private String name;
	
	

	/**
	 * 
	 */
	public Employee() {
		
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 * @param id
	 * @param name
	 */
	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}



	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Employee"+ " id"+ " name";
	}

	public String show() {
		return "Hello from Employee";
		}
	

}
