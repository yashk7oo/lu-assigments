package com.example.demo.entity;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="donor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Donor {
	
	@Id
	private Long phoneNumber;
	private String name;
	private int age;
	private String gender;
	private String bloodGroup;	
	private String city;
	private LocalDate dateOfLastDonation;

}
