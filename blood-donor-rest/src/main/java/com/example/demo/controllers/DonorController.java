package com.example.demo.controllers;

import java.time.LocalDate;

import java.util.List;

import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.DonationCamp;
import com.example.demo.entity.Donor;
import com.example.demo.services.DonorService;

@RestController
@RequestMapping(path = "/api/v1/donors")
//@CrossOrigin(origins="*")
public class DonorController {
	
	@Autowired
	private DonorService service;
	
	@GetMapping(path ="/")
	public List<Donor> findAll() {
		return this.service.findAll();
	}
	
	@GetMapping(path = "/findByCity/{city}")
	public List<Donor> findByTourCity(@PathVariable("city") String city) {
		
		return this.service.findByCity(city);
	}
	
	@GetMapping(path = "/findByBloodGroup/{bloodGroup}")
	public List<Donor> findByBloodGroup(@PathVariable("bloodGroup") String bloodGroup) {
		
		return this.service.findByBloodGroup(bloodGroup);
	}
	
	
	
	@PostMapping(path ="/addDonor")
	@ResponseStatus(value = HttpStatus.CREATED)
	public Donor addDonor(@RequestBody Donor donor) {
		
		return this.service.addDonor(donor);
		
	}
	
	@GetMapping(path="/findById/{phoneNumber}")
	public boolean exists(@PathVariable("phoneNumber") Long phoneNumber) {
		return this.service.exists(phoneNumber);
			
		
		
	}
	
	@DeleteMapping(path = "/deleteDonor/{phoneNumber}")
	public Optional<Donor> deleteDonor(@PathVariable("phoneNumber") Long phoneNumber) {
		
		Optional<Donor> deletedDonor = this.service.deleteDonor(phoneNumber);
		
		return deletedDonor;
	}
	

	
	
	@PutMapping(path="/updateDonor")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<String> updateDonor(@RequestBody Donor donor) {
		
		String message= "Rows updated :=" +this.service.updateDonor(donor);
		
		return ResponseEntity.ok().body(message);
	}
	
	@GetMapping(path ="/findEligibleDonors")
	public List<Donor> findEligibleDonors() {
		return this.service.findEligibleDonors();
	}
	
	@GetMapping(path ="/findAllCamps")
	public List<DonationCamp> findAllCamps() {
		return this.service.findAllCamps();
	}
	
	@PostMapping(path ="/registerDonorAtCamp")
	@ResponseStatus(value = HttpStatus.CREATED)
	public DonationCamp addDonationCamp(@RequestBody DonationCamp donationCamp) {
		
		return this.service.addDonationCamp(donationCamp);
		
	}
	
	@GetMapping(path = "/findByCampName/{campName}")
	public List<DonationCamp> findByCampName(@PathVariable("campName") String campName) {
		
		return this.service.findByCampName(campName);
	}
	
	@GetMapping(path = "/findByCampCity/{campCity}")
	public List<DonationCamp> findByCampCity(@PathVariable("campCity") String campCity) {
		
		return this.service.findByCampCity(campCity);
	}
	
	

}
