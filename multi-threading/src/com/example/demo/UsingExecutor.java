package com.example.demo;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.example.demo.ExecutorPrintService;

public class UsingExecutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExecutorService executor = Executors.newSingleThreadExecutor();
		
		ExecutorPrintService task1 = new ExecutorPrintService("idli","sambar");
		ExecutorPrintService task2 = new ExecutorPrintService("sagu","paratha");
		ExecutorPrintService task3 = new ExecutorPrintService("samosa","coke");
		ExecutorPrintService task4 = new ExecutorPrintService("tea","biscuit");
		
		executor.submit(task1);
		executor.submit(task2);
		executor.submit(task3);
		executor.submit(task4);
		executor.shutdown();
				
				
	}

}
