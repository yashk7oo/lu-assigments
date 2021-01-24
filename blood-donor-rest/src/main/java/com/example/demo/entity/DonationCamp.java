package com.example.demo.entity;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="donation_camp")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationCamp {
	
	@Id
	private Long phoneNumber;
	private int campId;
	private String campName;	
	private String campCity;
	private String donorName;

}
