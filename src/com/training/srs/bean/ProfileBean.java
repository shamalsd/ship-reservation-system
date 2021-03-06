package com.training.srs.bean;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.training.srs.util.IdGenerator;
@Entity
@Table(name="SRS_TBL_USER_PROFILE")
public class ProfileBean {
	@Id
     private String userID;
	@NotEmpty(message=" First Name Can't be Empty")
     private String firstName;
	@NotEmpty(message=" Last Name Can't be Empty")
     private String lastName;
	//@NotEmpty(message=" This Field Can't be Empty")
     private Date dateOfBirth;
	@NotEmpty(message=" This Field Can't be Empty")
     private String gender;
	@NotEmpty(message=" This Field Can't be Empty")
     private String street;
	@NotEmpty(message=" This Field Can't be Empty")
     private String location;
	@NotEmpty(message=" This Field Can't be Empty")
     private String city;
	@NotEmpty(message=" This Field Can't be Empty")
     private String state;
	@Pattern(regexp="\\d{6}",message="pincode should be of 6 digits")
     private String pincode;
	@Pattern(regexp="\\d{10}",message="Mobile Number should be of 10 digits")
	private String mobileNo;
	@Email(message="Please Enter a valid Email")
     private String emailID;
	@NotEmpty(message=" This Field Can't be Empty")
     private String password;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		
		this.userID = userID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
     
}
