package com.example.demo.services;

import java.time.LocalDate;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DonationCamp;
import com.example.demo.entity.Donor;

import com.example.demo.repos.DonationCampRepository;
import com.example.demo.repos.DonorRepository;

@Service
public class DonorService {
	
	@Autowired
	private DonorRepository repo;
	
	@Autowired
	private DonationCampRepository repo_new;
	
	
	public List<Donor> findAll() {
		
		return this.repo.findAll();
	}
	
    public List<Donor> findByBloodGroup(String bloodGroup) {
		
		return this.repo.findByBloodGroup(bloodGroup);
	}
    
    public List<Donor> findByCity(String city) {
		
		return this.repo.findByCity(city);
	}
	
	public Donor addDonor(Donor entity) {
		
		return this.repo.save(entity);
	}
	
	public Optional<Donor> findById(Long phoneNumber) {
		return this.repo.findById(phoneNumber);
	}
	
	public boolean exists(long phoneNumber) {
		
		return this.repo.existsById(phoneNumber);	
				
			
	}
	
	public Optional<Donor> deleteDonor(Long phoneNumber) {
		Optional<Donor> deleted = null;
	
		if(this.repo.existsById(phoneNumber)) {
			  
			  deleted=findById(phoneNumber);
			  this.repo.deleteById(phoneNumber);
			  
			  
			  
		}
		
		return deleted;
		
	}
	
	public List<Donor> findEligibleDonors() {
		return this.repo.findEligibleDonors();
	}
	
	 
	 
	public Donor updateDonor(Donor donor) {
		
		 
		 return this.addDonor(donor);
		  }
	 
	 public List<DonationCamp> findByCampCity(String campCity) {
			
			return this.repo_new.findByCampCity(campCity);
		}
	 
	 public List<DonationCamp> findByCampName(String campName) {
			
			return this.repo_new.findByCampName(campName);
		}
	 
	 public DonationCamp addDonationCamp(DonationCamp entity) {
			
			return this.repo_new.save(entity);
		}

	public List<DonationCamp> findAllCamps() {
		
		return this.repo_new.findAll();
	}
	
public List<String> findUniqueCamps() {
		
		return this.repo_new.findUniqueCamps();
	}
	 
	
	
	

}
