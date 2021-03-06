package com.training.srs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.training.srs.exception.ShipException;

public class DbUtil {
		public static Connection getConnection() throws ShipException {
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				return DriverManager.getConnection(url, "hr", "hr");
			} 
			catch (SQLException | ClassNotFoundException e) {
				
				throw new ShipException(e.getMessage());
			}
			
		}

	}


