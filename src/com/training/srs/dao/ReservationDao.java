package com.training.srs.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.training.srs.bean.CreditCardBean;
import com.training.srs.bean.PassengerBean;
import com.training.srs.bean.ReservationBean;
import com.training.srs.bean.RouteBean;
import com.training.srs.bean.ScheduleBean;
import com.training.srs.bean.ShipBean;
import com.training.srs.exception.ShipException;

public interface ReservationDao {
	public Map<RouteBean,ArrayList<ScheduleBean>>findScheduleForBooking(String source,String destination) throws ShipException;
	public String saveReservation(ReservationBean reservation)throws ShipException;
	public String savePassenger(List<PassengerBean> passengers)throws ShipException;
	public String validateCreditCard(CreditCardBean creditCard)throws ShipException;
	public ArrayList<ReservationBean> getReservation(String scheduleID)throws ShipException;
	public ArrayList<PassengerBean> getPassengers(String reservationID)throws ShipException;
	public ArrayList<ReservationBean> getTickets(String userID)throws ShipException;
}
