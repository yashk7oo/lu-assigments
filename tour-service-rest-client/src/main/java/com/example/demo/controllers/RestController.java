package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;




@org.springframework.web.bind.annotation.RestController
@RequestMapping(path = "/api/client")
public class RestController {
	
	@Autowired
	private RestTemplate template;
	
	@GetMapping(path ="/")
	public String findAll() {
		String response = template.getForObject("http://localhost:8080/api/v1/tours/", String.class);
		return response;
	}

}
