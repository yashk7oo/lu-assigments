package com.example.model;

import java.io.*;

import com.example.demo.Professor;
import com.example.demo.services.*;

public class Application {

	public static void main(String[] args) {
          
		
		File file = new File("professor.scr");
		
		Professor prof= new Professor(3838,"Suresh","ECE","phd");
		
		ProfessorService service = new ProfessorService();
		
		boolean result = service.writeObjectToFile(prof, file);
		
		if(result) {
			System.out.println("One-object Serialized");
		} else {
			System.out.println("Check Exception");
		}
				
		
				
	}

}
