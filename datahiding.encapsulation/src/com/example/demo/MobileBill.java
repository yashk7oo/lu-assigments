package com.example.demo;

public class MobileBill {
	//below variables are instance variables
    private String custName;
    private String mobNumber;
    private int amount;
    
    public static final String planName= "Combo"; //class variable

	public MobileBill() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param custName
	 * @param mobNumber
	 */
	public MobileBill(String custName, String mobNumber) {
		this(custName,mobNumber,0);
		this.custName = custName;
		this.mobNumber = mobNumber;
	}

	/**
	 * @param custName
	 * @param mobNumber
	 * @param amount
	 */
	public MobileBill(String custName, String mobNumber, int amount) {
		super();
		this.custName = custName;
		this.mobNumber = mobNumber;
		this.amount = amount;
	}

	public String getCustName() {
		return custName;
	}

	public String getMobNumber() {
		return mobNumber;
	}

	public int getAmount() {
		return amount;
	}



	public void setCustName(String custName) {
		this.custName = custName;
	}

	public void setMobNumber(String mobNumber) {
		this.mobNumber = mobNumber;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
	
    
    
    
    
}
