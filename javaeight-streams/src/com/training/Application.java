package com.training;


import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.training.model.CreditCard;
import com.training.services.StreamingService;
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StreamingService service = new StreamingService();
		
		System.out.println("List of cardholder 50000");		
		service.useFilter().stream().forEach(System.out::println);
		
		Map<String, CreditCard> list= service.useFilterTransformToMap();
		
		System.out.println("Card holder name and limit");
		for(Entry<String, CreditCard> element:list.entrySet()) {
			System.out.println(element.getKey()+element.getValue());
		}
		
		System.out.println("Sorted List");
		
		service.sortedList().forEach(System.out::println);
		
		double result = service.findMaxCreditLimit();
		
		System.out.println("max value");
		
		
		
		
		

	}

}
