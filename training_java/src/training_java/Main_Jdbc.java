package training_java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main_Jdbc {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "DELETE FROM branch WHERE branch_code = ?";
		String inSql = "INSERT INTO branch (branch_code,branch_name,country_code) values (? , ? , ?)";
		String upSql = "UPDATE branch SET branch_name  = ? , country_code = ? WHERE branch_code = ?";
		try {
			Class.forName("org.postgresql.Driver");
			try {
				con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/learning", "postgres", "root");
				System.out.println("connected");
				
			//	delete query
				ps  =con.prepareStatement(sql);
				ps.setString(1, "BR18");
				int count = ps.executeUpdate();
				if(count > 0) {
					System.out.println("deleted");
				}
				
			//	insert query
				ps = con.prepareStatement(inSql);
				ps.setString(1, "BR18");
				ps.setString(2, "l");
				ps.setString(3, "CY05");
				int count1 = ps.executeUpdate();
				if(count1 > 0) {
					System.out.println("inserted");
				}
				
			//	update query
				ps = con.prepareStatement(upSql);
				ps.setString(1, "america");
				ps.setString(2, "CY05");
				ps.setString(3, "BR18");
				int count2 = ps.executeUpdate();
				if(count2 > 0) {
					System.out.println("updated");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
