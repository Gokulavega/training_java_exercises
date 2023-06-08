package assiment_test_05_06_2023;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class Jdbc {
	static Connection con = null;
	static Logger logger = Logger.getLogger(Jdbc.class.getName());
	
	public static Connection getConnected() {
		
		
		try {
			Class.forName("org.postgresql.Driver");
			try {
				con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/learning", "postgres", "root");
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
