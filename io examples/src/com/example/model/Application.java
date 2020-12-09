package com.example.model;

import java.io.*;

import com.example.demo.Professor;
import com.example.demo.services.*;

public class Application {

	public static void main(String[] args) {
          
		
		File file = new File("professor.scr");
		ProfessorService service = new ProfessorService();
		int key=2;
		
		if(key==1) {
		Professor prof= new Professor(3838,"Suresh","ECE","phd");
		
		
		
		boolean result = service.writeObjectToFile(prof, file);
		
		if(result) {
			System.out.println("One-object Serialized");
		} else {
			System.out.println("Check Exception");
		}			
		
		}
		if(key == 2) {
			Professor prof = (Professor)service.readObjectFromFile(file);
			System.out.println("Deserialized professor :="+prof.getFirstName());
		}
		
		
	}
	
	

}
