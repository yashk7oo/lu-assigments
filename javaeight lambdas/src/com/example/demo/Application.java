package com.example.demo;

import com.example.demo.services.*;

public class Application {
	
	public static Runnable getLambda(int start , int end) {
		Runnable target = ()-> {
			for(int j=10;j<15;j++) {
				System.out.println(j);
				
			}
		};
		return target;
	}
	
	public static void main(String args[]) {
		
	UsingLambdas.usingAnonymousClass();
	UsingLambdas.usingLambda();
	
	Runnable target = ()-> {
		for(int j=10;j<15;j++) {
			System.out.println(j);
			
		}
	};
	UsingLambdas.passingLambda(target);
	
	Runnable target2 = getLambda(20,25);
	UsingLambdas.passingLambda(target);
	}
	

}
