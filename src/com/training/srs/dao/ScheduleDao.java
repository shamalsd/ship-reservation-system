package com.training.srs.dao;

import java.util.ArrayList;
import java.util.Date;

import com.training.srs.bean.PassengerBean;
import com.training.srs.bean.ScheduleBean;
import com.training.srs.bean.ShipBean;
import com.training.srs.exception.ShipException;

public interface ScheduleDao {
	//Methods for Admin Users
	public String createSchedule(ScheduleBean scheduleBean) throws ShipException;
	public int deleteSchedule(String id ) throws ShipException;
	public boolean updateSchedule(ScheduleBean scheduleBean) throws ShipException;
	public ScheduleBean findScheduleByID(String id)throws ShipException;
	public ArrayList<ScheduleBean> findAllSchedules() throws ShipException;
	public ArrayList<PassengerBean> viewPasengersByShip(String scheduleId) throws ShipException;
	//Methods for Customers
	public ArrayList<ScheduleBean> viewScheduleByRoute(String source, String destination, Date date)
			throws ShipException;
	public ArrayList<ScheduleBean> findScheduleBySD(String source,String destination) throws ShipException;

}
