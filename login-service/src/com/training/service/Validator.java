package com.training.service;

import com.training.model.*;

public class Validator {
	
	public static boolean validate(User user) {
		boolean result=false;
		
		if( (user.getName().equals("india")) && (user.getPassword().equalsIgnoreCase("india"))  ) {
			
			result=true;        
	   }  
		
		return result;
	}

}
