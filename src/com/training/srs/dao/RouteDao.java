package com.training.srs.dao;

import java.util.ArrayList;

import com.training.srs.bean.RouteBean;
import com.training.srs.exception.ShipException;

public interface RouteDao {
	public String createRoute(RouteBean routeBean) throws ShipException;
	public int deleteRoute(String id ) throws ShipException;
	public boolean updateRoute(RouteBean routeBean) throws ShipException;
	public RouteBean findRouteByID(String id)throws ShipException;
	public ArrayList<RouteBean> findAllRoutes() throws ShipException;

}
