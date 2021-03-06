package com.training.srs.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.srs.bean.PassengerBean;
import com.training.srs.bean.RouteBean;
import com.training.srs.bean.ScheduleBean;
import com.training.srs.bean.ShipBean;
import com.training.srs.dao.RouteDao;
import com.training.srs.dao.ScheduleDao;
import com.training.srs.dao.ShipDao;
import com.training.srs.exception.ShipException;
@Service
public class AdministratorImpl implements Administrator{
	@Autowired
	ShipDao shipDao;
	@Autowired
	ScheduleDao scheduleDao;
	@Autowired
	RouteDao routeDao;
	@Override
	public String addShip(ShipBean shipBean) throws ShipException {
		try {
		String status=shipDao.createShip(shipBean);
		if(status.equals("SUCCESS"))
			return "SUCCESS";
		else 
			return "FAIL";
	}
		catch (ShipException e) {
			throw new ShipException(e.getMessage());
		}
	}
	@Override
	public boolean modifyShip(ShipBean shipBean) throws ShipException {
		
		return shipDao.updateShip(shipBean);
	}
	@Override
	public int removeShip(String shipId) throws ShipException {
		
		return shipDao.deleteShip(shipId);
	}
	@Override
	public String addSchedule(ScheduleBean scheduleBean) throws ShipException {
		try {
			String status=scheduleDao.createSchedule(scheduleBean);
			if(status.equals("SUCCESS"))
				return "SUCCESS";
			else 
				return "FAIL";
		}
			catch (ShipException e) {
				throw new ShipException(e.getMessage());
			}
		
	}
	@Override
	public boolean modifySchedule(ScheduleBean scheduleBean) throws ShipException {
		
		return scheduleDao.updateSchedule(scheduleBean);
	}
	@Override
	public int removeSchedule(String scheduleId) throws ShipException {
		
		return scheduleDao.deleteSchedule(scheduleId);
	}
	@Override
	public String addRoute(RouteBean routeBean) throws ShipException {
		try {
			String status=routeDao.createRoute(routeBean);
			if(status.equals("SUCCESS"))
				return "SUCCESS";
			else 
				return "FAIL";
		}
			catch (ShipException e) {
				throw new ShipException(e.getMessage());
			}
		
	}
	@Override
	public boolean modifyRoute(RouteBean routeBean) throws ShipException {
		
		return routeDao.updateRoute(routeBean);
	}
	@Override
	public int removeRoute(String routeId) throws ShipException {
		
		return routeDao.deleteRoute(routeId);
	}
	@Override
	public ShipBean viewByShipId(String shipId) throws ShipException {
		
		return  shipDao.findShipByID(shipId);
	}
	@Override
	public RouteBean viewByRouteId(String routeId) throws ShipException {
		
		return routeDao.findRouteByID(routeId);
	}
	@Override
	public ArrayList<ShipBean> viewByAllShips() throws ShipException {
		
		return shipDao.findAllShips();
	}
	@Override
	public ArrayList<RouteBean> viewByAllRoute() throws ShipException {
		
		return routeDao.findAllRoutes();
	}
	@Override
	public ArrayList<ScheduleBean> viewByAllSchedule() throws ShipException {
		
		return scheduleDao.findAllSchedules();
	}
	@Override
	public ScheduleBean viewByScheduleId(String scheduleId) throws ShipException {
		
		return scheduleDao.findScheduleByID(scheduleId);
	}
	@Override
	public ArrayList<PassengerBean> viewPasengersByShip(String scheduleId) throws ShipException {
		
		return scheduleDao.viewPasengersByShip(scheduleId);
	}
	
	
}
