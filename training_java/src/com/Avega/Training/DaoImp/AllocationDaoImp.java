package com.Avega.Training.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.Avega.Training.Dao.AllocationDao;
import com.Avega.Training.Pojo.Allocation;
import com.Avega.Training.Util.DbUtil;

public class AllocationDaoImp implements AllocationDao{
	
	static Logger logger = Logger.getLogger(AllocationDaoImp.class.getName());
	Connection con = DbUtil.getConnected();
	PreparedStatement ps = null;

	@Override
	public List<Allocation> getAllAllocation() {
		ResultSet rs = null;
		String sql = "SELECT * FROM allocation";
		List<Allocation> allocations = new ArrayList<>();
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				allocations.add(new Allocation(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allocations;
	}

	@Override
	public Allocation getAllocation(String id) {
		Allocation allocation = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM allocation";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				if(rs.getString(1).equalsIgnoreCase(id)) {
				allocation = new Allocation(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6));
				break;
				}
			}
		} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return allocation;
	}

	@Override
	public boolean addAllocation(Allocation allocation) {
		boolean isAdded = false;
		String sql = "INSERT INTO allocation VALUES(?,?,?,?,?,?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, allocation.getAllocation_id());
			ps.setString(2, allocation.getTraining_id());
			ps.setString(3, allocation.getEmployee_id());
			ps.setString(4, allocation.getStatus());
			ps.setInt(5, allocation.getScore());
			ps.setString(6, allocation.getRemarks());
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
	public boolean deleteAllocation(String id) {
		boolean isDeleted = false;
		String sql = "DELETE FROM allocation WHERE allocation_id = ?";
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
	public boolean updateAllocation(Allocation allocation) {
		String upSql = "UPDATE allocation SET training_id = ?, employee_id = ?, status = ?, score = ?, remarks = ? WHERE allocation_id = ?";
		boolean isUpdate = false;
		try {
					ps = con.prepareStatement(upSql);
					ps.setString(1, allocation.getTraining_id());
					ps.setString(2, allocation.getEmployee_id());
					ps.setString(3, allocation.getStatus());
					ps.setInt(4, allocation.getScore());
					ps.setString(5, allocation.getRemarks());
					ps.setString(6, allocation.getAllocation_id());
					int count = ps.executeUpdate();
						if(count > 0) {
							logger.info("update");
							isUpdate = true;
						}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return isUpdate;
	}
	
	
}
