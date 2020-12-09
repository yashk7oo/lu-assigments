package com.training;

import java.io.IOException;

import com.training.utils.ExceptionHandling;


public class Application {
	//Declaring variable without initialization and defaults to null
	static String name;

	public static void main(String[] args) {
	/*	ExceptionHandling.usingTryCatch("66");
		
		
		
		ExceptionHandling.usingTryCatchFinally(name);
		int value=ExceptionHandling.usingTryCatchReturnFinally(name);
		System.out.println("Length:-"+value);*/
		
		try {
			ExceptionHandling.usingThrowAndThrowsClause();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Using Declare rule of Exception");
			e.printStackTrace();
		}
		
		try {
	  ExceptionHandling.usingThrow();
		} catch(RuntimeException e) {
			System.out.println("Using throw clause to throw exception");
			e.printStackTrace();
		}
	}

}
