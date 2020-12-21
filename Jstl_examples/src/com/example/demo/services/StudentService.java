package com.example.demo.services;
import java.util.*;
import com.example.demo.model.*;
public class StudentService {

	HashMap<String, List<Student>> studentList;
	
	public StudentService() {
		
		studentList = new HashMap<>();
		
		Student csc1= new Student(100,"Ramesh",67);
		Student csc2= new Student(200,"Rajesh",97);
		Student csc3= new Student(210,"Suresh",87);
		Student csc4= new Student(340,"Manish",78);
		
		List<Student> csc=Arrays.asList(csc1,csc2,csc3,csc4); 
		
		Student ese1= new Student(500,"Neil",67);
		Student ese2= new Student(600,"Nitin",97);
		Student ese3= new Student(710,"Kunal",87);
		Student ese4= new Student(840,"Ram",78);
		List<Student> ece=Arrays.asList(ese1,ese2,ese3,ese4); 
		
		studentList.put("csc",csc);
		studentList.put("ece",ece);

	}
	
	public List<Student> getDetails(String branch) {
		return this.studentList.get(branch);
	}
	
	
}
