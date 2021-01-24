package com.example.demo;

import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;




import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.DonationCamp;
import com.example.demo.entity.Donor;
import com.example.demo.repos.DonationCampRepository;
import com.example.demo.repos.DonorRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class DonorServiceRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DonorServiceRestApplication.class, args);
		
		
	}
	
	@Bean
	public CommandLineRunner runner() {
		
		return new CommandLineRunner() {
			
			@Autowired
			DonorRepository repo;
			
			@Autowired
			DonationCampRepository repo_new;
			
			@Override
			public void run(String... args) throws Exception {
			    repo.save(new Donor(8660228040l,"yash",22,"male","apos","kanpur", LocalDate.of(2020, 1, 8)));
				repo.findByBloodGroup("apos");
				repo_new.save(new DonationCamp(8095557454l,100,"mallroad camp","ahmedabad","ahmed"));
				//repo.delete(new Tour(100,"Simla",4,560000));
				repo.findEligibleDonors();
			}
			
			
			
		};
		
		
		
	}

}
