package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Tour;
import com.example.demo.repos.TourRepository;

@Service
public class TourService {
	
	@Autowired
	private TourRepository repo;
	
	
	public List<Tour> findAll() {
		
		return this.repo.findAll();
	}
	
    public Optional<Tour> findById(int id) {
		
		return this.repo.findById(id);
	}
	
	public Tour addTour(Tour entity) {
		
		return this.repo.save(entity);
	}
	
	public Tour deleteTour(Tour tour) {
		Tour deleted = null;
		if(this.repo.existsById(tour.getTourId())) {
			  
			  this.repo.deleteById(tour.getTourId());
			  deleted=tour;
			  
			  
		}
		
		return deleted;
		
	}
	
	 public Tour updateTour(Tour tour) {
		
		 
		 return this.addTour(tour);
		  }
	 
	 public List<Tour> findByTourName(String tourName) {
			
			return this.repo.findByTourName(tourName);
			
		}
		 
	
	
	

}
