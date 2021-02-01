package com.example.demo.controllers;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.DonationCamp;
import com.example.demo.entity.Donor;


@Controller
public class ClientController {
	
	@Autowired
	private RestTemplate template;
	
	@Autowired
	private ModelAndView mdlView;
	
	@Autowired
	private Donor donor;	
	
	@Autowired
	private DonationCamp donationCamp;
	
	@GetMapping(path="/showDonor")
	public ModelAndView showDonor() {
		
		
		
		

		Donor[] donors =this.template.getForObject("http://donor-service/api/v1/donors/",Donor[].class);
	
		mdlView.setViewName("viewDonors");
		mdlView.addObject("donor",donors);
		return mdlView;
		
	}
	
	@GetMapping(path = "/add")	
	public ModelAndView add() {
		
		mdlView.setViewName("addDonor");
		mdlView.addObject("command",donor);
		
		return mdlView;
	}
	
	@PostMapping(path="/submit")
	public ModelAndView onSubmit(@ModelAttribute("command") Donor donor) {
		
		
		
		

		Donor added =this.template.postForObject("http://donor-service/api/v1/donors/addDonor",donor,Donor.class);
	
		mdlView.setViewName("success");
		mdlView.addObject("added","Donor added Successfully");
		return mdlView;
		
	}
	
	@GetMapping(path = "/deleteDonor")
	public ModelAndView deleteDonor() {	
		
		
		mdlView.setViewName("deleteDonor");
		mdlView.addObject("command",donor);	
		
		return mdlView;
	}
	
	
	
	
	
	@PostMapping(path="/delete")
	public ModelAndView onView(@ModelAttribute("command") Donor donor) {
		
		boolean donor_exists=this.template.getForObject("http://donor-service/api/v1/donors/findById/"+donor.getPhoneNumber(),boolean.class);
		
		if(donor_exists==true) {
			this.template.delete("http://donor-service/api/v1/donors/deleteDonor/"+donor.getPhoneNumber());
			
			mdlView.setViewName("success");
			mdlView.addObject("added","Deleted");
		}else {
			mdlView.setViewName("failure");
			mdlView.addObject("added","cannot delete");
		}
		 
	return mdlView;
		
		

		
		
		
		
	}
	
	@GetMapping(path = "/update")
	public ModelAndView update() {
		
		mdlView.setViewName("updateDonor");
		mdlView.addObject("command",donor);
		
		return mdlView;
	}
	
	@PostMapping(path="/update")
	public ModelAndView onUpate(@ModelAttribute("command") Donor donor) {
		
		
		
		

		this.template.put("http://donor-service/api/v1/donors/updateDonor",donor );
	
		mdlView.setViewName("success");
		mdlView.addObject("added","updated");
		return mdlView;
		
	}
	
	@GetMapping(path = "/register")
	public ModelAndView register() {
		
		mdlView.setViewName("register");
		mdlView.addObject("command",donationCamp);
		
		return mdlView;
	}
	
	@PostMapping(path="/register")
	public ModelAndView onregister(@ModelAttribute("command") DonationCamp donationCamp) {
		
		
		
		

		DonationCamp register =this.template.postForObject("http://donor-service/api/v1/donors/registerDonorAtCamp",donationCamp,DonationCamp.class);
	
		mdlView.setViewName("success");
		mdlView.addObject("registered",register);
		return mdlView;
		
	}
	
	
	
	

}
