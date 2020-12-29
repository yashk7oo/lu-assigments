package com.example.demo.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MobileBill {
	
	
	@Autowired
	MobilePlan mobilePlan;
	
	@Autowired
	List<CallHistory> history;
	
	@Autowired
	Customer customer;

}
