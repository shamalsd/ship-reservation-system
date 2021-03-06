package com.training.srs.dao;

import java.util.ArrayList;

import com.training.srs.bean.ScheduleBean;
import com.training.srs.bean.ShipBean;
import com.training.srs.exception.ShipException;

public interface ShipDao {
	public String createShip(ShipBean shipBean) throws ShipException;
	public int deleteShip(String id ) throws ShipException;
	public boolean updateShip(ShipBean shipBean) throws ShipException;
	public ShipBean findShipByID(String id)throws ShipException;
	public ArrayList<ShipBean> findAllShips() throws ShipException;
	public ArrayList<ShipBean> findShipsBySD(String source,String destination) throws ShipException;
	

}
