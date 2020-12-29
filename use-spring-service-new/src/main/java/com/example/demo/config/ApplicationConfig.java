package com.example.demo.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.example.demo.model.Address;
import com.example.demo.model.Tour;
import com.example.demo.model.TourAgent;

@Configuration
public class ApplicationConfig {
	
	//Factory Method Annotated with @Bean it will be used by ioC Container
	//id of bean is same as method name
	
	@Bean
	//@Scope(scopeName=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Tour thaiLandTour() {
		//System.out.println("Factory Method Called");
		return new Tour(1010,"Thailand",4,45000);
	}
	@Bean
	public Tour kuluTour() {
	
		return new Tour(2020,"kulu",4,45000);
	}
	@Bean
	public Tour berlinTour() {
		
		return new Tour(3030,"berlin",4,45000);
	}
     
	 @Bean
	 public TourAgent agent007() {
		 TourAgent agent47= new TourAgent();
		 agent47.setId(1010);
		 agent47.setAgentName("Ramesh");
		
		 
		 return agent47;
	 }
	 
	 @Bean
	 @Primary
	 public Address residence() {
		 return new Address("Gandhi Street","Nehru Nagar","Pune",208011);
	 }
	 
	 @Bean
	 public Address office() {
		 return new Address("Nehru Street","Gandhi Nagar","Kolkata",560019);
	 }
}
