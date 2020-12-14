package com.assignment.service;
import com.assignment.model.*;

import java.util.*;

public class AppointmentManager {
	

	private HashMap<String,ArrayList<Patient>> patientmap;

	public AppointmentManager() {
		super();
		this.patientmap = new HashMap<>();
	}
	
	
	public String fixAppointment(Patient patientInfo) {
		
		ArrayList<Patient> eachPatient =  patientmap.get(patientInfo.getDoctorName());
		

	    if(eachPatient == null) {
	    	
	    	eachPatient = new ArrayList<Patient>();
	    	
	    	eachPatient.add(patientInfo);
	    	
	    	this.patientmap.put(patientInfo.getDoctorName(), eachPatient);
	    } 
	    

	    else {
	    	
	        if(!eachPatient.contains(patientInfo)) {
	        	eachPatient.add(patientInfo);
	        }
	        else {
	        	return "No such Doctor name present in records";
	        }
	    }
	    
	    return "Appointment Confirmed";
	}
	
	public List<Patient> printAppointment(String doctorName) {
		
		try {
			ArrayList<Patient> list = this.patientmap.get(doctorName);
			return list;
			
		} catch (NullPointerException e) {
	
			
         System.out.println("No such Doctor exists in record.");	
         
		}
		return null;
			
		}

	public String deleteAppointment(String patientName,String doctorName) {
		String message = "No such Appointment present in record";
		
		List<Patient> patient = this.patientmap.get(doctorName);
		
		if(patient== null) {
			return message;
			
		}		
		
		   for(Patient p:patient)
			{
				
				if(p.getPatientName().equals(patientName))
				{
					
					patient.remove(p);
					
					message="Appointment Cancelled";
					return message;
				}
			}
		
		
		return message;
	}

}
