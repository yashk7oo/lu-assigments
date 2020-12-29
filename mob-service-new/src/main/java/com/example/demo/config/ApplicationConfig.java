package com.example.demo.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import com.example.demo.model.CallHistory;
import com.example.demo.model.Customer;
import com.example.demo.model.MobileBill;
import com.example.demo.model.MobilePlan;


@Configuration
public class ApplicationConfig {
	
	
	
	@Bean
	public MobilePlan prepaidPlan() {
		
		return new MobilePlan(100,"Prepaid",48,new String[] {"48"},400);
		
	}
	
	@Bean
	public Customer Shreyas() {
		return new Customer("Shreyas",20,4634343434L);
	}
	
	@Bean
	public CallHistory Day1() {
		return new CallHistory(20,"Local",01.20,01.50);
	}
	
	 @Bean
	 public MobileBill firstBill() {
		 MobileBill ourBill= new MobileBill();
		
		
		 
		 return ourBill;
	 }
	

}
