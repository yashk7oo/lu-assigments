package com.example.demo.model;

import java.util.Arrays;



import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;



@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MobilePlan {
	
	 int id;
	 String planNmae;
	int validity;
	 String[] features;
	 double amount;
	
	
	public double findDiscount() {
		
		double discount=0.0;
		
		if(this.validity>58) {

			discount= 0.1 * this.amount;
		}
		
		return discount;
		
		
		
	}
	

} 
