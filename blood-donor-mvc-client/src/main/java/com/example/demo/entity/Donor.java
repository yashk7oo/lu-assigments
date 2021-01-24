package com.example.demo.entity;

import java.time.LocalDate;


import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class Donor {
	
	
	private Long phoneNumber;
	private String name;
	private int age;
	private String gender;
	private String bloodGroup;	
	private String city;
	
	
    
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfLastDonation;

}
