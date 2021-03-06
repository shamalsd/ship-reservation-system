package com.training.srs.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.training.srs.bean.RouteBean;
import com.training.srs.bean.ScheduleBean;
import com.training.srs.bean.ShipBean;
import com.training.srs.dao.RouteDao;
import com.training.srs.dao.ScheduleDao;
import com.training.srs.dao.ShipDao;
import com.training.srs.exception.ShipException;
import com.training.srs.service.Customer;


@Controller

public class ShipController {
	@Autowired
	Customer customer;
	@Autowired
	ShipDao shipDao;
	@Autowired
	RouteDao routeDao;
	@Autowired
	ScheduleDao scheduleDao;
	@RequestMapping("viewShip")
	public ModelAndView viewShip(HttpSession session)throws ShipException {
		try{if(session.getAttribute("userType")==null){
			ModelAndView mv=new ModelAndView("home");
			return mv;
		}
		try {
		ModelAndView mv=new ModelAndView("viewshipbysd");
		return mv;
	
	}
	catch(Exception e) {
		ModelAndView mv=new ModelAndView("error","message","Page loading Problem");
		return mv;
	}
		}catch(Exception e) {
			ModelAndView mv=new ModelAndView("home");
			return mv;
		}
	}
	@RequestMapping("viewShipBySd")
	public ModelAndView viewShipBySd(@ModelAttribute RouteBean route,HttpSession session)throws ShipException {
		try{if(session.getAttribute("userType")==null){
			ModelAndView mv=new ModelAndView("home");
			return mv;
		}
		try {
			String source=route.getSource();
			String dest=route.getDestination();
			ArrayList<ShipBean> ships=customer.findShipBySD(source, dest);
			ModelAndView mv=new ModelAndView("shipdetails");
			mv.addObject("ships",ships);
			return mv;
		
		}
		catch(Exception e) {
			ModelAndView mv=new ModelAndView("viewshipbysd");
			return mv;
		}
		}catch(Exception e) {
			ModelAndView mv=new ModelAndView("home");
			return mv;
		}
	}
	//
	///
	////////////////////////////////////////////////////////////////////////
	@RequestMapping("viewSchedule")
	public ModelAndView viewSchedule(HttpSession session)throws ShipException {
		try{if(session.getAttribute("userType")==null){
			ModelAndView mv=new ModelAndView("home");
			return mv;
		}
		try {
		ModelAndView mv=new ModelAndView("viewschedulebysd");
		return mv;
	
	}
	catch(Exception e) {
		throw new ShipException(e.getMessage());
	}
	}catch(Exception e) {
		ModelAndView mv=new ModelAndView("home");
		return mv;
	}
	}
	@RequestMapping("viewScheduleBySd")
	public ModelAndView viewScheduleBySd(@ModelAttribute RouteBean route,HttpSession session)throws ShipException {
		try{if(session.getAttribute("userType")==null){
			ModelAndView mv=new ModelAndView("home");
			return mv;
		}
		try {
			String source=route.getSource();
			String dest=route.getDestination();
			ArrayList<ScheduleBean> schedules=customer.findScheduleBySD(source, dest);
			ModelAndView mv=new ModelAndView("scheduledetails");
			mv.addObject("schedules",schedules);
			return mv;
		
		}
		catch(Exception e) {
			ModelAndView mv=new ModelAndView("viewschedulebysd");
			return mv;
		}
	}catch(Exception e) {
		ModelAndView mv=new ModelAndView("home");
		return mv;
	}
	}
///////////////////////////////////////////////////////////////////////////////
	@RequestMapping("addShip")
	public ModelAndView addShip(HttpSession session) throws ShipException{
		try{if(session.getAttribute("userType").equals("A")){
		try {	
		ModelAndView mv=new ModelAndView("addship");
		return mv;
		}
		catch (Exception e) {
			ModelAndView mv=new ModelAndView("home");
			return mv;
		}
		}
		
		ModelAndView mv=new ModelAndView("home");
		return mv;
	}
		catch (Exception e) {
			ModelAndView mv=new ModelAndView("home");
			return mv;
		}
	}
	
		
	@RequestMapping("addingShip")
	public ModelAndView addingShip(@ModelAttribute ShipBean shipBean,HttpSession session) throws ShipException{
		try{if(session.getAttribute("userType").equals("A")){
			
		try {
			String message=shipDao.createShip(shipBean);
			ArrayList<ShipBean> ships=shipDao.findAllShips();
			ModelAndView mv=new ModelAndView("view_allship","ships",ships);
			return mv;
		} 
		catch (Exception e) {
			ModelAndView mv=new ModelAndView("addship");
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
	/////////////////////////////////////////////////////////////////////////////////
	@RequestMapping("addRoute")
	public ModelAndView addRoute(HttpSession session) {
		try{if(session.getAttribute("userType").equals("A")){
			
		ModelAndView mv=new ModelAndView("addroute");
		return mv;
		}
		ModelAndView mv=new ModelAndView("home");
		return mv;
	}catch(Exception e) {
		ModelAndView mv=new ModelAndView("home");
		return mv;
	}
	}
	@RequestMapping("addingRoute")
	public ModelAndView addingRoute(@ModelAttribute RouteBean routeBean ,HttpSession session) throws ShipException{
		try{if(session.getAttribute("userType").equals("A")){
			
		try {
			String message=routeDao.createRoute(routeBean);
			ArrayList<RouteBean> routes=routeDao.findAllRoutes();
			ModelAndView mv=new ModelAndView("view_allroutes","routes",routes);
			return mv;
		} catch (Exception e) {
			ModelAndView mv=new ModelAndView("addroute");
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
	@RequestMapping("viewAllRoutes")
	public ModelAndView viewAllRoutes(HttpSession session)throws ShipException {
		try{if(session.getAttribute("userType").equals("A")){
			
		try {
			ArrayList<RouteBean> routes=routeDao.findAllRoutes();
			ModelAndView mv=new ModelAndView("view_allroutes","routes",routes);
			return mv;
		} catch (ShipException e) {
			ModelAndView mv=new ModelAndView("error","message","Try Again");
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
	
	/////////////////////////////////////////////////////////////////////////////////
	@RequestMapping("addSchedule")
	public ModelAndView addSchedule(HttpSession session) {
		try{if(session.getAttribute("userType").equals("A")){
			
		ModelAndView mv=new ModelAndView("addschedule");
		return mv;
		
	}
		ModelAndView mv=new ModelAndView("home");
		return mv;
	}catch(Exception e) {
		ModelAndView mv=new ModelAndView("home");
		return mv;
	}
	}
	@RequestMapping("addingSchedule")
	public ModelAndView addingSchedule(@ModelAttribute ScheduleBean scheduleBean,HttpSession session) throws ShipException{
		try{if(session.getAttribute("userType").equals("A")){
			
		try {
			String message=scheduleDao.createSchedule(scheduleBean);
			ArrayList<ScheduleBean> schedules=scheduleDao.findAllSchedules();
			ModelAndView mv=new ModelAndView("view_allschedule","schedules",schedules);
			return mv;
		} catch (Exception e) {
			ModelAndView mv=new ModelAndView("addschedule");
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
	@RequestMapping("viewAllSchedules")
	public ModelAndView viewAllSchedules(HttpSession session)throws ShipException {
		try{if(session.getAttribute("userType").equals("A")){
			
		try {
			ArrayList<ScheduleBean> schedules=scheduleDao.findAllSchedules();
			ModelAndView mv=new ModelAndView("view_allschedule","schedules",schedules);
			return mv;
		} catch (ShipException e) {
			ModelAndView mv=new ModelAndView("error","message","Try Again");
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
	/////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value="logoadmin",method=RequestMethod.GET)
	public ModelAndView addlogoo(@PathParam("userID") String userID,HttpSession session)throws ShipException{
		try{if(session.getAttribute("userType").equals("A")){
			
		try {
			ModelAndView mv=new ModelAndView("logoadmin");
			mv.addObject("userID",userID);
			return mv;
		} catch (Exception e) {
			ModelAndView mv=new ModelAndView("error","message","Page Loading Problem");
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
	@RequestMapping("linksadmin")
	public ModelAndView addlinksAdmin(HttpSession session)throws ShipException{
		try{if(session.getAttribute("userType").equals("A")){
			
		try {
			
			ModelAndView mv=new ModelAndView("linksadmin");
			return mv;
		} catch (Exception e) {
			ModelAndView mv=new ModelAndView("error","message","Page Loading Problem");
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
	/////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping("viewAllShip")
	public ModelAndView modifyShip(HttpSession session)throws ShipException {
		try{if(session.getAttribute("userType").equals("A")){
			
		try {
			ArrayList<ShipBean> ships=shipDao.findAllShips();
			ModelAndView mv=new ModelAndView("view_allship");
			mv.addObject("ships",ships);
			return mv;
		} catch (ShipException e) {
			ModelAndView mv=new ModelAndView("error","message","Try Again");
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
	@RequestMapping(value="modify",method=RequestMethod.GET)
	public ModelAndView modify(@ModelAttribute ShipBean ship,HttpSession session)throws ShipException {
		try{if(session.getAttribute("userType").equals("A")){
			
		try{
			
		ModelAndView mv=new ModelAndView("modifyship");
		mv.addObject("ship",ship);
		return mv;
		}
		catch (Exception e) {
			ModelAndView mv=new ModelAndView("view_allship");
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
	@RequestMapping("saveModify")
	public ModelAndView saveModify(@ModelAttribute ShipBean shipBean, HttpSession session) throws ShipException{
		try{if(session.getAttribute("userType").equals("A")){
			
		try {
			boolean  message=shipDao.updateShip(shipBean);
			if(message) {
				ArrayList<ShipBean> ships=shipDao.findAllShips();
				ModelAndView mv=new ModelAndView("view_allship");
				mv.addObject("ships",ships);
				return mv;
			}
			else {
				ModelAndView mv=new ModelAndView("error","message","Fail");
				return mv;
			}
		} catch (Exception e) {
			ModelAndView mv=new ModelAndView("modifyship");
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
	/////////////////////////////////////////////////////////////////
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public ModelAndView deleteShip(@PathParam("shipID") String shipID,HttpSession session)throws ShipException {
		try{if(session.getAttribute("userType").equals("A")){
			
		try {
			int a=shipDao.deleteShip(shipID);
			if(a==1) {
			ArrayList<ShipBean> ships=shipDao.findAllShips();
			ModelAndView mv=new ModelAndView("view_allship");
			mv.addObject("ships",ships);
			return mv;
			}
			else
			{
				ModelAndView mv=new ModelAndView("error");
				mv.addObject("message","fail");
				return mv;
			}
		} catch (ShipException e) {
			ModelAndView mv=new ModelAndView("view_allship");
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
