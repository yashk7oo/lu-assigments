package com.training.model;

public class ElectronicProduct extends Product {
	
	private int warranty;

	public ElectronicProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ElectronicProduct(int id, String name, double ratePerUnit) {
		super(id, name, ratePerUnit);
		// TODO Auto-generated constructor stub
	}

	public ElectronicProduct(int id, String name, double ratePerUnit,int warranty) {
		super(id, name, ratePerUnit);
		this.warranty = warranty;
	}

	public int getWarranty() {
		return warranty;
	}

	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+this.warranty;
	}
	
	
	
	

}
