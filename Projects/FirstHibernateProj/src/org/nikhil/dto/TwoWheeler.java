package org.nikhil.dto;

import javax.persistence.DiscriminatorValue;

//@DiscriminatorValue("Bike")
public class TwoWheeler extends Vehicle {
	
	private String SteeringHandle;

	public String getSteeringHandle() {
		return SteeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		SteeringHandle = steeringHandle;
	}
	

}
