package com.example.demo;

public class BookService {
	
	public double calculatePrice(Book b) {
		
		double discount = 0.0;
		
		if(b.getPrice()<500)
			return 0.0;
		else if(b.getPrice()<1000)
			return (0.05*(b.getPrice()));
		else
			return (0.1*(b.getPrice()));
				
	}
	
	public double calculatePrice(Book b,String customerType) {
		
		double discount=0.0;
		String customer=customerType.toUpperCase();
		
		if(customer.equals("RETAIL"))
			return ((0.05)*(b.getPrice()));
		else if(customer.equals("CORPORATE"))
			return ((0.1)*(b.getPrice()));
		else 
			return ((0.02)*(b.getPrice()));
	}

}
