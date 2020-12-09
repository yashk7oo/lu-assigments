package com.training.utils;

import java.io.IOException;

public class ExceptionHandling {
	
	public static void usingTryCatch(String mark) {
		
		try {
			int markScored = Integer.parseInt(mark);
			System.out.println(markScored);
			
		} catch(NumberFormatException e) {
			
			System.out.println("Mark should be positive integer and not string");
			System.out.println(e.getMessage());
			
		}
		
	System.out.println("Completed");
	}
	
	
	public static void usingTryCatchFinally(String name) {
		try {
			
			int length= name.length();		
		System.out.println("Length of the given string :-"+length);
		
		} catch(NullPointerException e) {
			
			System.err.println("Argument name is null-check again");
			e.printStackTrace();
			
		} finally {
		System.out.println("Inside finally block");
	}
	

}
	
	public static int usingTryCatchReturnFinally(String name) {
		int length=0;
		try {
			
			 length= name.length();		
		System.out.println("Length of the given string :-"+length);
		
		} catch(NullPointerException e) {
			
			System.err.println("Argument name is null-check again");
			e.printStackTrace();
			return 420;
			
		} finally {
		System.out.println("Inside finally block");
	}
	return length;

}
	
	public static void usingThrowAndThrowsClause() throws IOException {
		System.in.read();
	}
	
	public static void usingThrow() {
		throw new RuntimeException("Hee Hee");
	}
}
