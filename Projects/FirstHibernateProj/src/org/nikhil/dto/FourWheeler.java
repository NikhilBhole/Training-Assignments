package org.nikhil.dto;

import javax.persistence.DiscriminatorValue;

//@DiscriminatorValue("Car")
public class FourWheeler extends Vehicle {
	
	private String SteeringWheel;

	public String getSteeringWheel() {
		return SteeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		SteeringWheel = steeringWheel;
	}

}
