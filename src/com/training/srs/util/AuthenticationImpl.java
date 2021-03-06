package com.training.srs.util;

import com.training.srs.bean.CredentialsBean;
import com.training.srs.exception.ShipException;

public class AuthenticationImpl implements Authentication{

	@Override
	public boolean authenticate(CredentialsBean credentialsBean) throws ShipException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String authorize(String userId) throws ShipException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean changeLoginStatus(CredentialsBean credentialsBean, int loginStatus) throws ShipException {
		// TODO Auto-generated method stub
		return false;
	}

	

}
