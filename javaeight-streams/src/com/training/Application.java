package com.training;


import java.util.Map;

import com.training.services.StreamingService;
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StreamingService service = new StreamingService();
		
		System.out.println("List of cardholder 50000");		
		service.useFilter().stream().forEach(System.out::println);
		
		Map<String,Double> list= service.useFilterTransformToMap();
		
		System.out.println("Card holder name and limit");
		for(Map.Entry<String, Double> element:list.entrySet()) {
			System.out.println(element.getKey()+element.getValue());
		}
		
		

	}

}
