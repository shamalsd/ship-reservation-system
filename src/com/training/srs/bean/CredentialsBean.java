package com.training.srs.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="SRS_TBL_USER_CREDENTIALS")
public class CredentialsBean {
	@Id
   private String userID;
   private String password;
   private String userType;
   private int loginStatus;
public String getUserID() {
	return userID;
}
public void setUserID(String userID) {
	this.userID = userID;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUserType() {
	return userType;
}
public void setUserType(String userType) {
	this.userType = userType;
}
public int getLoginStatus() {
	return loginStatus;
}
public void setLoginStatus(int loginStatus) {
	this.loginStatus = loginStatus;
}
@Override
public String toString() {
	return "CredentialsBean [userID=" + userID + ", password=" + password + ", userType=" + userType + ", loginStatus="
			+ loginStatus + "]";
}
   
}
