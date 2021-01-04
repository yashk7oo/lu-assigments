package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

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

import com.example.demo.entity.Tour;
import com.example.demo.services.TourService;

@RestController
@RequestMapping(path = "/api/v1/tours")
@CrossOrigin(origins="*")
public class TourController {
	
	@Autowired
	private TourService service;
	
	@GetMapping(path ="/")
	public List<Tour> findAll() {
		return this.service.findAll();
	}
	
	@GetMapping(path = "/{id}")
	public Optional<Tour> findByTourId(@PathVariable("id") Integer id) {
		
		return this.service.findById(id);
	}
	
	@GetMapping(path = "/searchByName/{name}")
	public List<Tour> findByName(@PathVariable("name") String tourName){
		
		return this.service.findByTourName(tourName);
	}
	
	@PostMapping(path ="/")
	@ResponseStatus(value = HttpStatus.CREATED)
	public Tour addTour(@RequestBody Tour tour) {
		
		return this.service.addTour(tour);
		
	}
	
	@DeleteMapping(path = "/")
	public ResponseEntity<?> deleteTour(@RequestBody Tour tour) {
		
		Tour deletedTour = this.service.deleteTour(tour);
		
		if(deletedTour == null) {
			return ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.ok().body(deletedTour);
		}
	}
	
	@PutMapping(path = "/")
	@ResponseStatus(value = HttpStatus.OK)
	public Tour updateTour(@RequestBody Tour tour) {
		
		return this.service.updateTour(tour);
	}
	
	@GetMapping("/name/{tourName}")
	public List<Tour> findByTourName(@PathVariable("tourName") String tourName) {
		
		return this.service.findByTourName(tourName);
		
	}
	
	@GetMapping(path = "/duration/{days}")
    public List<Tour> findByDuration(@PathVariable("days") double duration){
        return this.service.findByDurationGreaterThan(duration);
    }
   
    @GetMapping(path = "tours/cost/{inr}")
    public List<Tour> findByCost(@PathVariable("inr") double cost){
        return this.service.findByCost(cost);
    }
	
	
	@PutMapping(path="tours/cost/{tourId}/{revised}")
	public ResponseEntity<String> updateTours(@PathVariable("tourId") int id,@PathVariable("revised") double revisedCost) {
		
		String message= "Rows updated :=" +this.service.updateTours(id, revisedCost);
		
		return ResponseEntity.ok().body(message);
	}
	
	

}
