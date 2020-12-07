package com.example.demo.services;

import com.example.demo.Book;

public class BookService {
	
	public double calculatePrice(Book each) {
		
		double discount = 0.0;
		
		if(each.getPrice()<500) {
			discount=0.0;
		} else {
			if(each.getPrice()<1000) {
				
			discount = (0.05*(each.getPrice()));
			} else {				
			
			discount= (0.1*(each.getPrice()));
			}
		}
		return discount;
	}
	
	public double calculatePrice(Book each,String customerType) {
		
		double discount=0.0;
		String customer=customerType.toUpperCase();
		
		if(customer.equals("RETAIL")) {
			
			discount = ((0.05)*(each.getPrice()));
		} else {
			if(customer.equals("CORPORATE")) {
				discount = ((0.1)*(each.getPrice()));
			} else {
			
			return ((0.02)*(each.getPrice()));
			}
	}
		return discount;
}
}
