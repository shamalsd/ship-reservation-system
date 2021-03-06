package com.training.srs.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.training.srs.bean.CreditCardBean;
import com.training.srs.bean.PassengerBean;
import com.training.srs.bean.PassengerListBean;
import com.training.srs.bean.ReservationBean;
import com.training.srs.bean.RouteBean;
import com.training.srs.bean.ScheduleBean;
import com.training.srs.dao.ReservationDao;
import com.training.srs.dao.RouteDao;
import com.training.srs.dao.ScheduleDao;
import com.training.srs.dao.ShipDao;
import com.training.srs.exception.ShipException;
import com.training.srs.service.Customer;

@Controller
public class ReservationController {
	@Autowired
	ReservationDao reserve;
	@Autowired
	Customer customer;
	@Autowired
	ShipDao shipDao;
	@Autowired
	RouteDao routeDao;
	@Autowired
	ScheduleDao scheduleDao;
	@RequestMapping(value="booking", method=RequestMethod.GET)
	public ModelAndView booking(@PathParam("userID") String userID,HttpSession session)throws ShipException {
		try{if(session.getAttribute("userType").equals("C")){
			
		try {		
		ModelAndView mv=new ModelAndView("booking");
		mv.addObject("userID",userID);
		return mv;
	    
	}
	catch(Exception e) {
		ModelAndView mv=new ModelAndView("booking");
		return mv;
	}
		
	}
	ModelAndView mv=new ModelAndView("home");
	return mv;
	}catch(Exception e) {
		ModelAndView mv=new ModelAndView("home");
		return mv;
	}
	}
	@RequestMapping(value="viewBookingDetails", method=RequestMethod.POST)
	public ModelAndView bookingDetails(@RequestParam ("userID") String userID,
										@RequestParam ("source") String source,
										@RequestParam ("destination") String destination,
										@RequestParam ("seats") int seats,
										HttpSession session)throws ShipException {
		try{if(session.getAttribute("userType").equals("C")){
			
		try {	
			Map<RouteBean,ArrayList<ScheduleBean>> booking=reserve.findScheduleForBooking(source, destination);
			ModelAndView mv=new ModelAndView("bookship");
			
			mv.addObject("userID",userID);
			mv.addObject("source",source);
			mv.addObject("destination",destination);
			mv.addObject("seats",seats);
			mv.addObject("route",booking.keySet().iterator().next());
			mv.addObject("schedules",booking.values().iterator().next());
			return mv;
	    
	}
	catch(Exception e) {
		ModelAndView mv=new ModelAndView("booking");
		return mv;
	}
	}
		ModelAndView mv=new ModelAndView("home");
		return mv;
	}catch(Exception e) {
		ModelAndView mv=new ModelAndView("home");
		return mv;
	}
	}
	@RequestMapping("saveBooking")
	public ModelAndView saveBooking(@RequestParam ("scheduleID") String scheduleID,
									@RequestParam ("userID")String userID,
									@RequestParam ("bookingDate")String bdate,
									@RequestParam ("journeyDate")String jdate,
									@RequestParam ("noOfSeats") int seats,
									@RequestParam ("totalFare") double fare,
									HttpSession session)throws ShipException {
		try{if(session.getAttribute("userType").equals("C")){
			
		try {	
		ReservationBean reservation= new ReservationBean();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		reservation.setBookingDate(simpleDateFormat.parse(bdate));
		reservation.setJourneyDate(simpleDateFormat.parse(jdate));
		reservation.setScheduleID(scheduleID);
		reservation.setUserID(userID);
		reservation.setNoOfSeats(seats);
		double totalFare=seats*fare;
		reservation.setTotalFare(totalFare);
		
		//String s=reserve.saveReservation(reservation);
		session.setAttribute("reservation", reservation);
		//if(s.equals("Success")) {
			 ArrayList<PassengerBean> passengerList=new ArrayList<PassengerBean>();
			 ModelAndView mv=new ModelAndView("passenger");
		     
		      for(int i=0;i<reservation.getNoOfSeats();i++)
		    	  passengerList.add(new PassengerBean());

		      PassengerListBean passengerBeanList=new PassengerListBean();
		      passengerBeanList.setPassengerList(passengerList);
		      mv.addObject("passengerBeanList",passengerBeanList);
		      mv.addObject("reservation",reservation);
		      return mv;
		/*}
		else
		{
			ModelAndView mv=new ModelAndView("error","message","Failed :Try Again");
			
			return mv;
		}*/
	}
	catch(Exception e) {
		e.printStackTrace();
		ModelAndView mv=new ModelAndView("booking");
		return mv;
	}
	}
		ModelAndView mv=new ModelAndView("home");
		return mv;
	}catch(Exception e) {
		ModelAndView mv=new ModelAndView("home");
		return mv;
	}
	}
	
	@RequestMapping( value="savePassenger")
	public ModelAndView savePassenger(@ModelAttribute("passengerBeanList") PassengerListBean passengerList,HttpSession session )throws ShipException {
		try{if(session.getAttribute("userType").equals("C")){
			
		try {
			boolean list=passengerList.getPassengerList().iterator().hasNext();
			if(list) {
		//reserve.savePassenger( passengerList.getPassengerList());
				session.setAttribute("passengers", passengerList);
		ModelAndView mv=new ModelAndView("payment");
		return mv;	
			}
			else {
				ModelAndView mv=new ModelAndView("error");
				mv.addObject("message","No passenger Details Found");
				return mv;
			}
	}
	catch(Exception e) {
		ModelAndView mv=new ModelAndView("booking");
		return mv;
	}
	}
		ModelAndView mv=new ModelAndView("home");
		return mv;
	}catch(Exception e) {
		ModelAndView mv=new ModelAndView("home");
		return mv;
	}
	}
	@RequestMapping(value="booked" ,method=RequestMethod.POST)
	public ModelAndView payment(@ModelAttribute CreditCardBean creditCard,/*@PathParam("reservationID") String reservationID,*/HttpSession session)throws ShipException {
		try{if(session.getAttribute("userType").equals("C")){
			
		try {
			String status=reserve.validateCreditCard(creditCard);
			if(status.equals("Success")) {
			ReservationBean res=(ReservationBean) session.getAttribute("reservation");	
			String resId=reserve.saveReservation(res);
			PassengerListBean passengers=(PassengerListBean) session.getAttribute("passengers");
			ArrayList<PassengerBean> pass= new ArrayList<PassengerBean>();
			for(int i=0;i<passengers.getPassengerList().size();i++) {
				passengers.getPassengerList().get(i).setReservationID(resId);
				pass.add(passengers.getPassengerList().get(i));
			}
			reserve.savePassenger(pass);
			System.out.println(passengers.getPassengerList());
			ModelAndView mv=new ModelAndView("viewtkt");
			/*ReservationBean reservation=reserve.getReservation(reservationID);
			List<PassengerBean> passengers=reserve.getPassengers(reservationID);*/
			mv.addObject("resId",resId);
			mv.addObject("reservation",res);
			mv.addObject("passengers",pass);	
			return mv;	
			}
			else {
				ModelAndView mv=new ModelAndView("error","message","Wrong CreditCardDetails");
				return mv;
			}
	}
	catch(Exception e) {
		ModelAndView mv=new ModelAndView("booking");
		return mv;
	}
	}
	ModelAndView mv=new ModelAndView("home");
	return mv;
	}catch(Exception e) {
		ModelAndView mv=new ModelAndView("home");
		return mv;
	}
	}
	@RequestMapping(value="viewTicketDetails",method=RequestMethod.GET)
	public ModelAndView viewTicketDetails(@PathParam("userID") String userID,HttpSession session)throws ShipException {
		try{if(session.getAttribute("userType").equals("C")){
			
		try {	
			
			ArrayList<ReservationBean> reservations=reserve.getTickets(userID);
			ModelAndView mv=new ModelAndView("viewticket");
			mv.addObject("reservations",reservations);
			return mv;	
	    
	}
	catch(Exception e) {
		ModelAndView mv=new ModelAndView("error","message","No Bookings");
		return mv;
	}
		
	}
	ModelAndView mv=new ModelAndView("home");
	return mv;
	}catch(Exception e) {
		ModelAndView mv=new ModelAndView("home");
		return mv;
	}
	}
	
	@RequestMapping(value="viewPassengersDetails",method=RequestMethod.GET)
	public ModelAndView viewPassengersDetails(@PathParam("reservationID") String reservationID,HttpSession session)throws ShipException {
		try{if(session.getAttribute("userType").equals("C")||session.getAttribute("userType").equals("A")){
			
		try {	
			
			ArrayList<PassengerBean> passengers=reserve.getPassengers(reservationID);
			ModelAndView mv=new ModelAndView("viewpassengers");
			mv.addObject("reservationID",reservationID);
			mv.addObject("passengers",passengers);
			return mv;	
	    
	}
	catch(Exception e) {
		ModelAndView mv=new ModelAndView("error","message","No Bookings");
		return mv;
	}
		
	}
	ModelAndView mv=new ModelAndView("home");
	return mv;
	}catch(Exception e) {
		ModelAndView mv=new ModelAndView("home");
		return mv;
	}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value="showBookings",method=RequestMethod.GET)
	public ModelAndView showBookingDetails(@PathParam("scheduleID") String scheduleID,HttpSession session)throws ShipException {
		try{if(session.getAttribute("userType").equals("A")){
			
		try {	
			
			ArrayList<ReservationBean> reservations=reserve.getReservation(scheduleID);
			ModelAndView mv=new ModelAndView("viewticket");
			mv.addObject("reservations",reservations);
			return mv;	
	    
	}
	catch(Exception e) {
		ModelAndView mv=new ModelAndView("error","message","No Bookings");
		return mv;
	}
		
	}
	ModelAndView mv=new ModelAndView("home");
	return mv;
	}catch(Exception e) {
		ModelAndView mv=new ModelAndView("home");
		return mv;
	}
	}
	
}
