package com.training;

import com.training.utils.ExceptionHandling;


public class Application {
	//Declaring variable without initialization and defaults to null
	static String name;

	public static void main(String[] args) {
		ExceptionHandling.usingTryCatch("66");
		
		
		
		ExceptionHandling.usingTryCatchFinally(name);
		int value=ExceptionHandling.usingTryCatchReturnFinally(name);
		System.out.println("Length:-"+value);

	}

}
