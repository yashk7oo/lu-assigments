package com.example.demo;


//public final class Employee {
public class Employee {
	
	private int id;
	private String name;
	

	public Employee() {		
	
	}
	
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
		return this.id+" "+ this.name;
	}

	public String show() {
		return "Hello from Employee";
		}
	

}
