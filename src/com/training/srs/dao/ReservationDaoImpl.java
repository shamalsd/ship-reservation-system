package com.training.srs.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.RuntimeOperationsException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.training.srs.bean.CreditCardBean;
import com.training.srs.bean.PassengerBean;
import com.training.srs.bean.ReservationBean;
import com.training.srs.bean.RouteBean;
import com.training.srs.bean.ScheduleBean;
import com.training.srs.exception.ShipException;
import com.training.srs.util.IdSchdGenerator;

import oracle.net.aso.q;
@Repository
public class ReservationDaoImpl implements ReservationDao{
	@Autowired
	IdSchdGenerator idGen;
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public Map<RouteBean, ArrayList<ScheduleBean>> findScheduleForBooking(String source, String destination) throws ShipException {
		try {
			Map<RouteBean, ArrayList<ScheduleBean>> booking=new HashMap<RouteBean,ArrayList<ScheduleBean>>();
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from RouteBean where source=:s and destination=:d");
			query.setParameter("s", source);
			query.setParameter("d", destination);
			RouteBean routeBean= (RouteBean) query.uniqueResult();
			Query query1=session.createQuery(" from ScheduleBean where routeID=:id");
			query1.setParameter("id", routeBean.getRouteID());
			ArrayList<ScheduleBean> schedules=(ArrayList<ScheduleBean>) query1.getResultList();
			booking.put(routeBean, schedules);
			return booking;
			
		}
		catch(Exception e) {
			throw new ShipException(e.getMessage());
		}

	}
	@Override
	public String saveReservation(ReservationBean reservation) throws ShipException {
		try {
		reservation.setReservationID(idGen.idGenerateSch(reservation.getScheduleID()));
		reservation.setBookingStatus("Booked");
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(reservation);
		session.getTransaction().commit();
		session.close();
		
		return reservation.getReservationID();
		}catch(Exception e) {
			throw new ShipException();
		}
	}
	@Override
	public String savePassenger(List<PassengerBean> passengers) throws ShipException {
		try{
			Session session =sessionFactory.openSession();
		for(int i=1;i<passengers.size();i++) {
			session.beginTransaction();
			session.save(passengers.get(i));
			session.getTransaction().commit();
			session.evict(passengers.get(i));
		}
		
		session.close();
		return "Success";
		}
		catch(Exception e) {
			throw new ShipException();
		}
	}
	@Override
	public String validateCreditCard(CreditCardBean creditCard) throws ShipException {
		try{
			Session session=sessionFactory.openSession();
		
		session.beginTransaction();
		Query query=session.createQuery("from CreditCardBean");
		ArrayList<CreditCardBean> cards=(ArrayList<CreditCardBean>) query.getResultList();
		if(cards.iterator().next().getCreditCardNumber().equals(creditCard.getCreditCardNumber()))
		{
			return "Success";
		}
		else
		{
			return "Fail"; 
		}
	}
		catch(Exception e) {
			throw new ShipException();
		}
	}
	@Override
	public ArrayList<ReservationBean> getReservation(String scheduleID) throws ShipException {
		try{
			Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery("from ReservationBean where scheduleID=:id");
		query.setParameter("id", scheduleID);
		ArrayList<ReservationBean> reservation= (ArrayList<ReservationBean>) query.list();
		session.close();
		return reservation;
		}catch (Exception e) {
			throw new ShipException();
		}
	}
	@Override
	public ArrayList<PassengerBean> getPassengers(String rid) throws ShipException {
		try{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from PassengerBean where reservationID=:id");
		query.setParameter("id", rid);
		ArrayList<PassengerBean> passengers= (ArrayList<PassengerBean>) query.list();
		session.close();
		return passengers;
		}catch (Exception e) {
			throw new ShipException();
		}
	}
	@Override
	public ArrayList<ReservationBean> getTickets(String userID) throws ShipException {
		try{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from ReservationBean where userID=:id");
			query.setParameter("id", userID);
			ArrayList<ReservationBean> reservation= (ArrayList<ReservationBean>) query.list();
			session.close();
			return reservation;
			}
			catch (Exception e) {
			
				throw new ShipException();
			}
		}
	

}
