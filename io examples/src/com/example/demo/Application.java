package com.example.demo;

import java.io.*;

import com.example.demo.services.*;
import com.example.model.Professor;

public class Application {

	public static void main(String[] args) {
          
		
		File file = new File("professor.scr");
		File textFile = new File("professor.txt");
		ProfessorService service = new ProfessorService();
		int key=4;
		
		if(key==2) {
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
			System.out.println("Deserialized professor :="+prof);
		}
		
		if(key == 3) {
			Professor suresh= new Professor(3838,"Suresh","ECE","phd");
			Professor manish= new Professor(2838,"Manish","Mech","pg");
			Professor rajesh= new Professor(2833,"Rajesh","CSE","phd");
			Professor rakesh= new Professor(2834,"Rakesh","IT","pg");
			Professor brijesh= new Professor(2678,"Brijesh","EEE","pg");	
			
			
			
			System.out.println("Is added :="+service.writeTotextFile(suresh,textFile));
			System.out.println("Is added :="+service.writeTotextFile(manish,textFile));
			System.out.println("Is added :="+service.writeTotextFile(rajesh,textFile));
			System.out.println("Is added :="+service.writeTotextFile(rakesh,textFile));
			System.out.println("Is added :="+service.writeTotextFile(brijesh,textFile));
		}
		if(key==4) {
			Professor[] list = service.readFromTextFile(textFile);
			System.out.println(list.length);
			
			for(Professor eachProf: list) {
				if(eachProf!=null) {
					System.out.println(eachProf);
				}
			}
		}
		
		
	}
	
	

}
