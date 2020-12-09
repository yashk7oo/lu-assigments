package com.training;

import com.training.utils.RangeCheckException;

public class Student {

	
	/*Lines below define instance variables. They can be used without assigning and can have default values such as 
	 * 0,0.0,null,false*/
	 
	 private int rollNumber;
	 private String studentName;
	 private double markScored;
	 
	 //class variable
	 
	 public static final String trainerName= "Srinath";
	 
	 public Student() {
			
		}
	 
	 

	public Student(int rollNumber, String studentName) throws RangeCheckException {
		
		this(rollNumber,studentName,99);
		this.rollNumber = rollNumber;
		this.studentName = studentName;
	}



	public Student(int rollNumber, String studentName, double markScored) throws RangeCheckException {
		this.rollNumber = rollNumber;
		this.studentName = studentName;
		
			if(markScored<0||markScored>100) {
				throw new RangeCheckException("marks out of range");
			} else {
				this.markScored = markScored;
			}
		
			
		}
		
	
	
	
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public void setMarkScored(double markScored) {
		try {
			if(markScored<0 || markScored>100) {
				throw new RangeCheckException("marks out of range");
			}
			else {
				this.markScored = markScored;
			}
		}
		catch(RangeCheckException e) {
			System.err.println(e.getMessage());
		}
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
