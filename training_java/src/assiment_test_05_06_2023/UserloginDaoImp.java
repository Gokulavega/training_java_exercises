package assiment_test_05_06_2023;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UserloginDaoImp implements UserLoginDao{
	
	static Logger logger = Logger.getLogger(UserloginDaoImp.class.getName());
	Connection con = Jdbc.getConnected();
	PreparedStatement ps = null;
	
	@Override
	public List<UserLogin> getAllUser() {
		ResultSet rs = null;
		String sql = "SELECT * FROM userlogin";
		List<UserLogin> users = new ArrayList<UserLogin>();
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				users.add(new UserLogin(rs.getString(1),rs.getString(2),rs.getString(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
		
	}

	@Override
	public boolean addUser(UserLogin userLogin) {
		boolean isAdded = false;
		String sql = "INSERT INTO userlogin VALUES(?,?,?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, userLogin.getUserId());
			ps.setString(2, userLogin.getUserName());
			ps.setString(3, userLogin.getPassword());
			int count = ps.executeUpdate();
			if(count > 0) {
				logger.info("added");
				isAdded = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isAdded;
	}

	@Override
	public boolean deleteUser(String id) {
		boolean isDeleted = false;
		String sql = "DELETE FROM userlogin WHERE user_id = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			int count = ps.executeUpdate();
			if(count > 0) {
				logger.info("deleted");
				isDeleted = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isDeleted;
	}

	@Override
	public UserLogin updateUser(UserLogin userLogin) {
		String upSql = "UPDATE userlogin SET user_name = ? , password = ? WHERE user_id = ?";
		UserLogin user = null;
		
				try {
					ps = con.prepareStatement(upSql);
					ps.setString(1, userLogin.getUserName());
					ps.setString(2, userLogin.getPassword());
					ps.setString(3, userLogin.getUserId());
					int count = ps.executeUpdate();
						if(count > 0) {
							logger.info("update");
						}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
		return user;
	}

}
