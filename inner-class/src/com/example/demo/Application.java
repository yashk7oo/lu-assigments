package com.example.demo;
import java.util.*;


public class Application {

	public static void main(String[] args) {
	
		List<Employee> list = new ArrayList<>();
		
		list.add(new Employee(101,"Ramesh"));
		list.add(new Employee(102,"Zaid"));
		list.add(new Employee(103,"Sarthak"));
		
		Collections.sort(list,new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
				
			}
			
		});
		System.out.println(list);
		
		MyComparators comparator = new MyComparators();
		Collections.sort(list,comparator.new EmployeeIdComparator());
		System.out.println(list);
		
	}

}