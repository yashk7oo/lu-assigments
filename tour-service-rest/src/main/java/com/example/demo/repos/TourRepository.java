package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Tour;

@Repository
public interface TourRepository extends JpaRepository<Tour , Integer> {
	
         public List<Tour> findByTourName(String tourName);
	
	

}
