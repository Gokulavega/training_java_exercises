package com.Avega.Training.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DbUtil {
	static Connection con = null;
	static Logger logger = Logger.getLogger(DbUtil.class.getName());
	
	public static Connection getConnected() {
		
		
		try {
			Class.forName("org.postgresql.Driver");
			try {
				con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/assiment_test", "postgres", "root");
				logger.info("connected");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

}
