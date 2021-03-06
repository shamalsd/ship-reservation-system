package com.training.srs.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SRS_TBL_ROUTE")
public class RouteBean {
	@Id
	private String routeID;
	private String source;
	private String destination;
	private String travelDuration;
	private double fare;
	public String getRouteID() {
		return routeID;
	}
	public void setRouteID(String routeID) {
		this.routeID = routeID;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getTravelDuration() {
		return travelDuration;
	}
	public void setTravelDuration(String travelDuration) {
		this.travelDuration = travelDuration;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	
}
