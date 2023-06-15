package com.Avega.Training.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.Avega.Training.Dao.TrainingDao;
import com.Avega.Training.Execption.TrainingNotFoundExecption;
import com.Avega.Training.Pojo.Training;
import com.Avega.Training.Util.DbUtil;

public class TrainingDaoImp implements TrainingDao{
	
	static Logger logger = Logger.getLogger(TrainingDaoImp.class.getName());
	Connection con = DbUtil.getConnected();
	PreparedStatement ps = null;
	@Override
	public List<Training> getAllTraining() {
		ResultSet rs = null;
		String sql = "SELECT * FROM training";
		List<Training> trainings = new ArrayList<>();
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				trainings.add(new Training(rs.getString(1),rs.getString(2),rs.getDate(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getString(7)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trainings;
	}
	@Override
	public Training getTraining(String id) throws TrainingNotFoundExecption {
		Training training = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM training";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				if(rs.getString(1).equalsIgnoreCase(id)) {
				training = new Training(rs.getString(1),rs.getString(2),rs.getDate(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getString(7));
				break;
				}
			}
		} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		if(training == null) {
			throw new TrainingNotFoundExecption();
		}
		return training;
	}
	@Override
	public boolean addTraining(Training training) {
		boolean isAdded = false;
		String sql = "INSERT INTO training VALUES(?,?,?,?,?,?,?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, training.getTraining_id());
			ps.setString(2, training.getDescription());
			ps.setDate(3, training.getStart_date());
			ps.setDate(4, training.getEnd_date());
			ps.setString(5, training.getRequestor_id());
			ps.setString(6, training.getTrainer());
			ps.setString(7, training.getSkill_id());
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
	public boolean deleteTraining(String id) {
		boolean isDeleted = false;
		String sql = "DELETE FROM training WHERE training_id = ?";
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
	public boolean updateTraining(Training training) {
		String upSql = "UPDATE training SET description = ? , start_date = ? ,end_date = ? , requestor_id = ? ,trainer = ? ,skill_id = ? WHERE training_id = ?";
		boolean isUpdate = false;
		try {
					ps = con.prepareStatement(upSql);
					ps.setString(1, training.getDescription());
					ps.setDate(2, training.getStart_date());
					ps.setDate(3, training.getEnd_date());
					ps.setString(4, training.getRequestor_id());
					ps.setString(5, training.getTrainer());
					ps.setString(6, training.getSkill_id());
					ps.setString(7, training.getTraining_id());
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
