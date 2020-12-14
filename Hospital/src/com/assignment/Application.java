package com.assignment;

import com.assignment.model.*;

import com.assignment.service.*;
import java.util.*;

public class Application {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppointmentManager appointment = new AppointmentManager();
		
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("Please Choose your option\n1: Fix New Appointment\n2: Check Appointment List for particular doctor\n3: Cancel Appointment\n4: Exit");
			String option = sc.next();
			
			switch(option) {
			case "1":
				System.out.println("Enter the name of patient");
				String patientName =sc.next()+  sc.nextLine();
				
				System.out.println("Enter the name of Doctor Name");
				String doctorName = sc.nextLine();
				
				System.out.println("Enter Patient Age");
				int patientAge;
				try {
					patientAge = sc.nextInt();
					Patient patientInfo = new Patient(patientName,patientAge, doctorName);
					
					
					String message = appointment.fixAppointment(patientInfo);
					System.out.println(message);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.err.println("Enter Age in Integer");
					
					
				}
				break;
				
			case "2":
				System.out.println("Enter the name of Doctor");
				String doctor = sc.next()+ sc.nextLine();
				
				List<Patient> list = appointment.printAppointment(doctor);
				
				try {
					for(Patient p:list)
						System.out.println(p.getPatientName());
				} catch (NullPointerException e) {
					// TODO Auto-generated catch block
					System.err.println("No Appointments found");				
					
					
				}
				break;
			case "3":
				System.out.println("Enter the name of Patient");
				 patientName = sc.next()+ sc.nextLine();
				 System.out.println("Enter the name of Doctor");
				 doctorName = sc.next()+ sc.nextLine();
				String message = appointment.deleteAppointment(patientName, doctorName);
				System.out.println(message);
				break;
				
			case "4":
				sc.close();
				break;
			default:
				System.out.println("Invalid option chosen");
				break;
				
				
			}
			
			
			
		}
		
		
	}
}

