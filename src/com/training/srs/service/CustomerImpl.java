package com.training.srs.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.srs.bean.PassengerBean;
import com.training.srs.bean.ProfileBean;
import com.training.srs.bean.ReservationBean;
import com.training.srs.bean.ScheduleBean;
import com.training.srs.bean.ShipBean;
import com.training.srs.dao.ScheduleDao;
import com.training.srs.dao.ShipDao;
import com.training.srs.exception.ShipException;
import com.training.srs.util.User;
@Service
public class CustomerImpl implements Customer{
	@Autowired
	ShipDao shipDao;
	@Autowired
	ScheduleDao scheduleDao;
	@Autowired
	User user;
	@Override
	public ArrayList<ScheduleBean> viewScheduleByRoute(String source, String destination, Date date)
			throws ShipException {
		
		return scheduleDao.findAllSchedules();
	}

	@Override
	public String reserveTicket(ReservationBean reservationBean, ArrayList<PassengerBean> passengerBean)
			throws ShipException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean cancelTicket(String reservationId) throws ShipException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<ReservationBean, PassengerBean> viewTicket(String reservationId) throws ShipException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String register(ProfileBean profileBean) throws ShipException {
		
		return user.register(profileBean);
	}

	@Override
	public ArrayList<ShipBean> findShipBySD(String source, String destination) throws ShipException {
		
		return shipDao.findShipsBySD(source, destination);
	}

	@Override
	public ArrayList<ScheduleBean> findScheduleBySD(String source, String destination) throws ShipException {
		
		return scheduleDao.findScheduleBySD(source, destination);
	}

	@Override
	public String validateNumber(String userID,String mobileNo) throws ShipException {
		
		return user.validateNumber(userID, mobileNo);
	}

}
