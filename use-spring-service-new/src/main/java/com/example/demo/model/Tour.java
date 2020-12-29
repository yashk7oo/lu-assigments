package com.example.demo.model;

import org.springframework.stereotype.Component;

//enable IoC container to register it as bean and id will be "tour"
@Component
public class Tour {
	
	private int tourId;
	private String tourName;
	private double duration;
	private double cost;
	
	public Tour() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tour(int tourId, String tourName, double duration, double cost) {
		super();
		this.tourId = tourId;
		this.tourName = tourName;
		this.duration = duration;
		this.cost = cost;
	}

	public int getTourId() {
		return tourId;
	}

	public String getTourName() {
		return tourName;
	}

	public double getDuration() {
		return duration;
	}

	public double getCost() {
		return cost;
	}

	public void setTourId(int tourId) {
		this.tourId = tourId;
	}

	public void setTourName(String tourName) {
		this.tourName = tourName;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Tour [tourId=" + tourId + ", tourName=" + tourName + ", duration=" + duration + ", cost=" + cost + "]";
	}
	
	

}
