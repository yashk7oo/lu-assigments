package com.example.demo;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.model.MobileBill;
import com.example.demo.model.MobilePlan;


@SpringBootApplication
public class MobServiceNewApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(MobServiceNewApplication.class, args);
		
		/*MobilePlan prepaidPlan =ctx.getBean("prepaidPlan",MobilePlan.class);
		
		System.out.println("prepaid");
		
		System.out.println(prepaidPlan.findDiscount());
		
        MobilePlan postpaidPlan =ctx.getBean("postpaidPlan",MobilePlan.class);
		
		System.out.println("postpaid");
		
		System.out.println(postpaidPlan.findDiscount());*/
		
        MobileBill firstBill = ctx.getBean(MobileBill.class);
		
		
        System.out.println(firstBill.getCustomer());
		firstBill.getHistory().forEach(System.out::println);
		System.out.println(firstBill.getMobilePlan());
		
		
		ctx.close();
		
	}

}
