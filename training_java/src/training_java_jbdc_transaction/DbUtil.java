package training_java_jbdc_transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

import training_java_Jdbc.Jdbc;

public class DbUtil {
	
	static Connection connection = null;
	static Logger logger = Logger.getLogger(Jdbc.class.getName());
	
	public static Connection getConnected() {
		
		
		try {
			Class.forName("org.postgresql.Driver");
			try {
				connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/learning", "postgres", "root");
				logger.info("connected");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
}
