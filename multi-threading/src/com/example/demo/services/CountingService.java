package com.example.demo.services;

public class CountingService {
	
	private int countUpTo;

	
	public CountingService() {

	}

    public void countNumbers(int countUpTo) {
    	
    	int sum=0;
    	
    	for(int i=0;i<=countUpTo;i++) {
    			sum += i;
    	}
    	System.out.println("Called By Thred :="+Thread.currentThread().getName()+" := "+sum);
    	
    }
	
	

}
