package com.example.demo.apps;
import com.example.demo.services.*;
import com.example.demo.*;
import java.util.*;

import com.example.demo.Book;
import com.example.demo.services.BookService;
public class Flow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Book Id,Book Name,Author name,Price");
		int id=sc.nextInt();
		String bName=sc.next();
		String author=sc.next();
		int price=sc.nextInt();
		
		Book each= new Book(id,bName,author,price);
		
		BookService service= new BookService();
		
		double discount=service.calculatePrice(each);	
		
		
		System.out.println("Discount price for "+bName+" is "+discount);
		
		System.out.println("Enter Customer Type");
		
		String custType=sc.next();
		
		discount=service.calculatePrice(each, custType);
		
		System.out.println("Discount price for Customer Type "+custType+" is "+discount);
		
		
		
		
		sc.close();
				
	}			

}
