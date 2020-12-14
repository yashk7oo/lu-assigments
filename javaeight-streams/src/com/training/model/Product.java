package com.training.model;

public class Product {
	
	 private int id;
	 private String name;
	 private double ratePerUnit;
	public Product() {

	}
	public Product(int id, String name, double ratePerUnit) {
		super();
		this.id = id;
		this.name = name;
		this.ratePerUnit = ratePerUnit;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public double getRatePerUnit() {
		return ratePerUnit;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setRatePerUnit(double ratePerUnit) {
		this.ratePerUnit = ratePerUnit;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id+ " "+this.name+" "+this.ratePerUnit+" ";
	}
	
	
	
	
	 

}
