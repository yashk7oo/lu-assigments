package com.example.demo;
import com.example.demo.stereotypes.*;

	
@MyBean(scope = "Singleton",name="Student")
public class MyService {
	
	public String show( ) {
		
		return "Hello";
	}

}
