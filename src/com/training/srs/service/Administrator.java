package com.training.srs.service;

import java.util.ArrayList;

import com.training.srs.bean.PassengerBean;
import com.training.srs.bean.RouteBean;
import com.training.srs.bean.ScheduleBean;
import com.training.srs.bean.ShipBean;
import com.training.srs.exception.ShipException;

public interface Administrator {
	public String addShip(ShipBean shipBean) throws ShipException ;
	public boolean modifyShip(ShipBean shipBean) throws ShipException;
	public int removeShip(String shipId) throws ShipException;
	public String addSchedule(ScheduleBean scheduleBean) throws ShipException;
	public boolean modifySchedule(ScheduleBean scheduleBean) throws ShipException;
	public int removeSchedule(String scheduleId)throws ShipException;
	public String addRoute(RouteBean routeBean) throws ShipException;
	public boolean modifyRoute(RouteBean routeBean)throws ShipException;
	public int removeRoute(String routeId)throws ShipException;
	public ShipBean viewByShipId(String shipId)throws ShipException;
	public RouteBean viewByRouteId(String routeId)throws ShipException;
	public ArrayList<ShipBean> viewByAllShips()throws ShipException;
	public ArrayList<RouteBean> viewByAllRoute()throws ShipException;
	public ArrayList<ScheduleBean> viewByAllSchedule()throws ShipException;
	public ScheduleBean viewByScheduleId(String scheduleId)throws ShipException;
	public ArrayList<PassengerBean> viewPasengersByShip(String scheduleId)throws ShipException;
		
	
}
