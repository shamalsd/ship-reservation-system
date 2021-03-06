package com.training.srs.util;

import com.training.srs.exception.ShipException;

public interface Payment {
	public boolean findByCardNumber(String userId, String cardNumber)throws ShipException;
	public String process(Payment payment)throws ShipException;

}
