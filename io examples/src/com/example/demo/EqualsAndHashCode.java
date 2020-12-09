package com.example.demo;
import com.example.model.*;
public class EqualsAndHashCode {
	
	 	public static void main(String args[]) {
	 		Professor suresh = new Professor(3838,"Suresh","ECE","phd");
	 		
	 		Professor otherSuresh= suresh;
	 		
	 	 System.out.println("IsSuresh and otherSuresh equal :=" +suresh.equals(otherSuresh));
	 	 
	 	Professor suresh2 = new Professor(3838,"Suresh","ECE","phd");
	 	
	 	System.out.println("IsSuresh and otherSuresh equal :=" +suresh.equals(suresh2));
	 	
	 	
	 	}

}
