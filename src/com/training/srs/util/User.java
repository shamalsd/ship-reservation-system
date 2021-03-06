package com.training.srs.util;

import com.training.srs.bean.CredentialsBean;
import com.training.srs.bean.ProfileBean;
import com.training.srs.exception.ShipException;

public interface User {
	public String login(CredentialsBean credentialsBean)throws ShipException;
	public boolean logout(String userId)throws ShipException;
	public String changePassword(String userID, String newPassword)throws ShipException;
	public String register(ProfileBean profileBean)throws ShipException;
	
	public String validateNumber(String userID,String mobileNo)throws ShipException;
}
