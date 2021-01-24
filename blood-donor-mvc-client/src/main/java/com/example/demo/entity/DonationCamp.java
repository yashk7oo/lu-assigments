package com.example.demo.entity;







import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationCamp {
	
	private Long phoneNumber;
	private int campId;
	private String campName;	
	private String campCity;
	private String donorName;
	

}
