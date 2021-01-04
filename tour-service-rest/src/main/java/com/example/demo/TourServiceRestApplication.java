package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Tour;
import com.example.demo.repos.TourRepository;

@SpringBootApplication
public class TourServiceRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TourServiceRestApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner runner() {
		
		return new CommandLineRunner() {
			
			@Autowired
			TourRepository repo;
			
			@Override
			public void run(String... args) throws Exception {
			   // repo.save(new Tour(100,"Simla",4,560000));
				//repo.findById(100);
				repo.delete(new Tour(100,"Simla",4,560000));
				repo.save(new Tour(400,"Simla",4,560000));
			}
			
			
			
		};
		
		
		
	}

}
