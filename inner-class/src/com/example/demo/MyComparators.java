package com.example.demo;
import java.util.Comparator;
public class MyComparators {
	
  public class EmployeeNameComparator implements Comparator<Employee>{
	  
	  @Override
		public int compare(Employee o1, Employee o2) {
			// TODO Auto-generated method stub
			return o1.getName().compareTo(o2.getName());
			
		}		
  }
  
  public class EmployeeIdComparator implements Comparator<Employee>{
  
	  
	  @Override
		public int compare(Employee o1, Employee o2) {
			if(o1.getId() < o2.getId()) return -1;
			if(o1.getId() > o2.getId()) return 1;
			return 0;		
			
		}		
}
}
