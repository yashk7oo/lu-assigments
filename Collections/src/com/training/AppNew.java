package com.training;


import java.util.*;

import com.training.model.BloodDonor;

public class AppNew {
	public static void main(String args[]) {
	
	HashMap<String,List<BloodDonor>> bloodDonor = new HashMap<>();
	
	BloodDonor candidate1 = new BloodDonor(1,"Yash",22,"apos");
	BloodDonor candidate2 = new BloodDonor(2,"Harsh",23,"bpos");
	BloodDonor candidate3 = new BloodDonor(3,"Sagar",24,"bpos");
	BloodDonor candidate4 = new BloodDonor(4,"Nikhil",25,"oneg");
	
	List<BloodDonor> apos = Arrays.asList(candidate1);
	List<BloodDonor> bpos = Arrays.asList(candidate2,candidate3);
	List<BloodDonor> oneg = Arrays.asList(candidate4);
	
	bloodDonor.put("apos", apos);
	bloodDonor.put("bpos", bpos);
	bloodDonor.put("oneg", oneg);
	
	Set<Map.Entry<String, List<BloodDonor>>> setView = bloodDonor.entrySet();
	
	for(Map.Entry<String, List<BloodDonor>> eachGroup : setView) {
		System.out.println("Donors having blood group as "+eachGroup.getKey());
		for(BloodDonor donor : eachGroup.getValue()) {
			System.out.println(donor.toString());
		}
	}
	
	}

}
