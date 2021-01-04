package com.example.demo;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.model.Tour;
import com.example.demo.model.TourAgent;

@SpringBootApplication
public class UseSpringServiceNewApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx =SpringApplication.run(UseSpringServiceNewApplication.class, args);
		
		TourAgent agent47 = ctx.getBean(TourAgent.class);
		
		System.out.println(agent47.getAgentName()+" "+agent47.getId());
		
		agent47.getTours().forEach(System.out::println);
		
		System.out.println(agent47.getAddress());
		/*Tour tour = ctx.getBean("tour",Tour.class);
		
		System.out.println(tour);
		
         Tour thaiTour1 = ctx.getBean("thaiLandTour",Tour.class);
		
		System.out.println(thaiTour1);
		
	    Tour thaiTour2 = ctx.getBean("thaiLandTour",Tour.class);
		
			System.out.println(thaiTour2);
			
		    Tour thaiTour3 = ctx.getBean("thaiLandTour",Tour.class);
			
			System.out.println(thaiTour3);
			
			System.out.println(ctx.isPrototype("thaiLandTour"));
		*/
		ctx.close();
	}

}
