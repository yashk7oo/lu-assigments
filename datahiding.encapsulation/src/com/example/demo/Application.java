package com.example.demo;

public class Application {
	
	public static Double checkScholorship(Double markScored) {
		double amount=50000.00D;
		if(markScored<70)
			amount=35000.00D;
		return amount;
			}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student ram = new Student();
		
		
		
		System.out.println(ram.getMarkScored());
		System.out.println(ram.getRollNumber());
		System.out.println(ram.getStudentName());
		
		System.out.println(Student.trainerName);
		
		
		Student ramesh= new Student(101,"Ramesh",67);
		
		System.out.println(ramesh.getMarkScored());
		System.out.println(ramesh.getRollNumber());
		System.out.println(ramesh.getStudentName());
		
		System.out.println("Ramesh-grade = "+ ramesh.assignGrade());
		
       
		
		Student rajesh= new Student(102,"Rajesh");
		
		System.out.println(rajesh.getMarkScored());
		System.out.println(rajesh.getRollNumber());
		System.out.println(rajesh.getStudentName());
		
		System.out.println("Ramesh-grade = "+ rajesh.assignGrade());
		
		int rollNumber=Integer.parseInt(args[0]);
		double markScored=Double.parseDouble(args[2]);
		
		Student rishi= new Student(rollNumber,args[1],markScored);
		
		checkScholorship(rishi.getMarkScored());
		
		
		
		
		MobileBill yash = new MobileBill();
		
		System.out.println(yash.getCustName());
		System.out.println(yash.getMobNumber());
		System.out.println(yash.getAmount());
		
		MobileBill suresh = new MobileBill("Suresh","8093648832");
		
		System.out.println(suresh.getCustName());
		System.out.println(suresh.getMobNumber());
		System.out.println(suresh.getAmount());
		
		System.out.println("Suresh's plan is- "+ MobileBill.planName);
		
		MobileBill kartik = new MobileBill("Suresh","8093648832",2000);
		
		System.out.println(kartik.getCustName());
		System.out.println(kartik.getMobNumber());
		System.out.println(kartik.getAmount());

	}

}
