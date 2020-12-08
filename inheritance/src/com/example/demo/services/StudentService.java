package com.example.demo.services;
import com.example.demo.model.Student;
public class StudentService {

	
public void printStudentList(Student[] students) {
		
		for(Student eachStudent: students) {
			System.out.println(eachStudent);
		}
}
	
	//Var-Args=>Available from java5 onwards
public void displayList(Student ... students ) {
		for(Student eachStudent: students) {
			System.out.println(eachStudent);
		}
	}
}

