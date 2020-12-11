package com.training.model;

public class FoodProduct extends Product {
	
	private String shelfLife;

	public FoodProduct() {
	
	}



	public FoodProduct(int id, String name, double ratePerUnit) {
		super(id, name, ratePerUnit);
		// TODO Auto-generated constructor stub
	}



	public FoodProduct(int id, String name, double ratePerUnit,String shelfLife) {
		super(id, name, ratePerUnit);
		this.shelfLife = shelfLife;
	}



	public String getShelfLife() {
		return shelfLife;
	}



	public void setShelfLife(String shelfLife) {
		this.shelfLife = shelfLife;
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+this.shelfLife;
	}
	
	
	
	
	
		
	
	

}
