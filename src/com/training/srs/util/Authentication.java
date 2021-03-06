package com.training.srs.util;

import com.training.srs.bean.CredentialsBean;
import com.training.srs.exception.ShipException;

public interface Authentication {
	public boolean authenticate(CredentialsBean credentialsBean) throws ShipException;
	public String authorize(String userId) throws ShipException;
	public boolean changeLoginStatus(CredentialsBean credentialsBean, int loginStatus) throws ShipException;
}
