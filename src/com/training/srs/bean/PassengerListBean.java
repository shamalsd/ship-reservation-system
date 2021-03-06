package com.training.srs.bean;

import java.util.ArrayList;

import javax.persistence.Entity;

@Entity
public class PassengerListBean {
	private ArrayList<PassengerBean> passengerList;

	public ArrayList<PassengerBean> getPassengerList() {
		return passengerList;
	}

	public void setPassengerList(ArrayList<PassengerBean> passengerList) {
		this.passengerList = passengerList;
	}

	@Override
	public String toString() {
		return "PassengerListBean [passengerList=" + passengerList + "]";
	}

	

	
	

}
