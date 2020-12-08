package com.example.demo.model;

public class Student {
	private int rollNumber;
	private String studentName;
	private double markScored;
	/**
	 * 
	 */
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param rollNumber
	 * @param studentName
	 * @param markScored
	 */
	public Student(int rollNumber, String studentName, double markScored) {
		super();
		this.rollNumber = rollNumber;
		this.studentName = studentName;
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
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public void setMarkScored(double markScored) {
		this.markScored = markScored;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.rollNumber+":"+this.studentName+":"+this.markScored;
	}
	
	
    
}
