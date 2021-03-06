package com.training.srs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.training.srs.bean.CredentialsBean;
import com.training.srs.bean.ProfileBean;
import com.training.srs.exception.ShipException;
import com.training.srs.service.Customer;
import com.training.srs.util.User;

@Controller
public class CustomerController {
	@Autowired
	Customer customer;
	@Autowired
	User user;
	@RequestMapping("/")
	public ModelAndView showHome(){
		ModelAndView mv=new ModelAndView("home");
		return mv;
	}
	@RequestMapping("home")
	public ModelAndView backHome(){
		ModelAndView mv=new ModelAndView("home");
		return mv;
	}
	@RequestMapping("login")
	public ModelAndView loginUsers(@ModelAttribute CredentialsBean credentials,HttpSession session)throws ShipException{
		
			session.setAttribute("userType", credentials.getUserType());
		try {
			
			String type=user.login(credentials);
			if(type.equals("C")) {
				ModelAndView mv=new ModelAndView("customerLogin");
				mv.addObject("userID",credentials.getUserID());
				return mv;
				}
			else if(type.equals("A")) {
				ModelAndView mv=new ModelAndView("adminLogin");
				mv.addObject("userID",credentials.getUserID());
				return mv;
				}
			else 
				{
					ModelAndView mv=new ModelAndView("error");
					mv.addObject("message",type);
					return mv;
				}
			
			
		}catch (Exception e) {
		
			ModelAndView mv=new ModelAndView("home");
			
			return mv;
		}
		
	}
	@RequestMapping("register")
	public ModelAndView registration(){
			ModelAndView mv=new ModelAndView("register");
			return mv;
	}
	@RequestMapping("addUser")
	public ModelAndView addUser(@ModelAttribute ProfileBean user)throws ShipException{
		try {
			String message=customer.register(user);
			ModelAndView mv=new ModelAndView("success","message","Regitration Completed. Your User Id is: "+message);
			return mv;
		} 
		catch (ShipException e) {
			ModelAndView mv=new ModelAndView("error","message","Incorrect Values");
			return mv;
		}
	}
	@RequestMapping(value="logout",method=RequestMethod.GET)
	public ModelAndView logOutUser(@PathParam("userID") String userID,HttpServletRequest req)throws ShipException{
		try {
		boolean log=user.logout(userID);
		if(log) {
		ModelAndView mv=new ModelAndView("logout");
		mv.addObject("message","Logged out successfully");
		HttpSession session=req.getSession();
		
		session.invalidate();
		return mv;
		}
		else
		{
			ModelAndView mv=new ModelAndView("home");
			return mv;		}
		}
		catch (Exception e) {
			ModelAndView mv=new ModelAndView("home");
			return mv;
		}
	}
	
	@RequestMapping(value="logo",method=RequestMethod.GET)
	public ModelAndView addlogo(@PathParam("userID") String userID,HttpSession session)throws ShipException{
			try{if(session.getAttribute("userType").equals("C")){
				
		try {
			ModelAndView mv=new ModelAndView("logo");
			mv.addObject("userID",userID);
			return mv;
		} catch (Exception e) {
			ModelAndView mv=new ModelAndView("error","message","Page Could not be loaded");
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
	@RequestMapping("links")
	public ModelAndView addlinks(@PathParam("userID") String userID, HttpSession session)throws ShipException{
		try{if(session.getAttribute("userType").equals("C")){
			
		try {
			
			ModelAndView mv=new ModelAndView("links");
			mv.addObject("userID",userID);
			return mv;
		} catch (Exception e) {
			ModelAndView mv=new ModelAndView("error","message","Page Could not be loaded");
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
	
	////////////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping("forgetPassword")
	public ModelAndView forgetPassword(@PathParam("userID") String userID) {
		try {
			ModelAndView mv=new ModelAndView("forgetpassword","userId",userID);
			return mv;
		}catch(Exception e) {
			ModelAndView mv=new ModelAndView("home");
			return mv;
		}
	}
	
	@RequestMapping("numberValidation")
	public ModelAndView mobileValidate(@PathParam("userID") String userID,@PathParam("mobileNo") String mobileNo) {
		try {
			String message=customer.validateNumber(userID, mobileNo);
			if(message.equals("Valid")) {
			ModelAndView mv=new ModelAndView("changepassword","userID",userID);
			return mv;
			}
			else {
				ModelAndView mv=new ModelAndView("error","message","Mobile Number not matched");
				return mv;
			}
		}catch(Exception e) {
			ModelAndView mv=new ModelAndView("home");
			return mv;
		}
	}
	
	@RequestMapping("changePassword")
	public ModelAndView newPassword(@PathParam("userID") String userID,@PathParam("password") String password) {
		try {
			String message=user.changePassword(userID, password);
			if(message.equals("Success")) {
			ModelAndView mv=new ModelAndView("success","message","Password Changed Successfully");
			return mv;
			}
			else {
				ModelAndView mv=new ModelAndView("error","message","Something Went Wrong Try Again!!");
				return mv;
			}
		}catch(Exception e) {
			ModelAndView mv=new ModelAndView("home");
			return mv;
		}
	}
	@RequestMapping("background")
	public ModelAndView backGround()
	{
		ModelAndView mv=new ModelAndView("background");
		return mv;
	}
}
