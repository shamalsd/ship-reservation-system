package com.training.srs.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import com.training.srs.bean.PassengerBean;
import com.training.srs.bean.ProfileBean;
import com.training.srs.bean.ReservationBean;
import com.training.srs.bean.ScheduleBean;
import com.training.srs.bean.ShipBean;
import com.training.srs.exception.ShipException;

public interface Customer {
	public ArrayList<ScheduleBean> viewScheduleByRoute(String source, String destination,Date date)throws ShipException;
	public String reserveTicket(ReservationBean reservationBean,ArrayList<PassengerBean> passengerBean)throws ShipException;
	public boolean cancelTicket(String reservationId)throws ShipException;
	public Map<ReservationBean,PassengerBean> viewTicket(String reservationId)throws ShipException;
	public String register(ProfileBean profileBean)throws ShipException;
	public ArrayList<ShipBean> findShipBySD(String source,String destination) throws ShipException;
	public ArrayList<ScheduleBean> findScheduleBySD(String source,String destination) throws ShipException;
	public String validateNumber(String userID,String mobileNo)throws ShipException;

	
}
