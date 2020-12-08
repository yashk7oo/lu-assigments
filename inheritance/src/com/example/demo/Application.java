package com.example.demo;
import com.example.demo.services.*;

import com.example.demo.model.Student;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Student ramesh = new Student(101,"Ramesh",98);
     Student rakesh = new Student(102,"Rakesh",99);
     Student rajesh = new Student(103,"Rajesh",100);
     
     Student[] list1= {ramesh,rajesh,rakesh};
     
     Student[] list2= new Student[3];
     
     list2[0]=ramesh;
     list2[1]=rakesh;
     list2[2]=rajesh;   
     
     
     System.out.println(ramesh);
     System.out.println("==========");
     
     StudentService service = new EnhancedStudentService();
     
     service.printStudentList(list1);
     System.out.println("==========");
     service.printStudentList(list2);
     System.out.println("==========");
     
     service.displayList(ramesh,rajesh);
     System.out.println("==========");
     
     
	}

}
