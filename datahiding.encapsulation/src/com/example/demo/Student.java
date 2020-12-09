package com.example.demo;

public class Student {

	
	/*Lines below define instance variables. Thay can be used without assigning and can have default values such as 
	 * 0,0.0,null,false*/
	 
	 private int rollNumber;
	 private String studentName;
	 private double markScored;
	 
	 //class variable
	 
	 public static final String trainerName= "Srinath";
	 
	 public Student() {
			
		}
	 
	 

	public Student(int rollNumber, String studentName) {
		
		this(rollNumber,studentName,99);
		this.rollNumber = rollNumber;
		this.studentName = studentName;
	}



	public Student(int rollNumber, String studentName, double markScored) {
		this.rollNumber = rollNumber;
		this.studentName = studentName;
		this.markScored = markScored;
	}
	
	
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public void setMarkScored(double markScored) {
		this.markScored = markScored;
	}




	public int getRollNumber() {
		return rollNumber;
	}	


	public String getStudentName() {
		return studentName;
	}	


	public double getMarkScored() {
		return markScored;
	}
	
	
	
	public String assignGrade() {
		//local variable
		//they cannot have modifier like private,protected
		String grade= "o";
		
		if(this.markScored<80)
			grade= "A";
		
		return grade;
	}



	
	
	
	
	 
	 
	 
}
