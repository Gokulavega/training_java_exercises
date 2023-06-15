package com.Avega.Training.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.Avega.Training.Dao.SkillDao;
import com.Avega.Training.Execption.SkillNotFoundExecption;
import com.Avega.Training.Pojo.Skill;
import com.Avega.Training.Util.DbUtil;

public class SkillDaoImp implements SkillDao{
	
	static Logger logger = Logger.getLogger(SkillDaoImp.class.getName());
	Connection con = DbUtil.getConnected();
	PreparedStatement ps = null;

	@Override
	public List<Skill> getAllSkill() {
		ResultSet rs = null;
		String sql = "SELECT * FROM skill";
		List<Skill> skills = new ArrayList<>();
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				skills.add(new Skill(rs.getString(1),rs.getString(2)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return skills;
	}

	@Override
	public Skill getSkill(String id) throws SkillNotFoundExecption {
		Skill skill = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM skill";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				if(rs.getString(1).equalsIgnoreCase(id)) {
				skill = new Skill(rs.getString(1),rs.getString(2));
				break;
				}
			}
		} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		if(skill == null) {
			throw new SkillNotFoundExecption();
		}
		return skill;
	}

	@Override
	public boolean addSkill(Skill skill) {
		boolean isAdded = false;
		String sql = "INSERT INTO skill VALUES(?,?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, skill.getSkill_id());
			ps.setString(2, skill.getDescription());
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
	public boolean deleteSkill(String id) {
		boolean isDeleted = false;
		String sql = "DELETE FROM skill WHERE skill_id = ?";
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
	public boolean updateSkill(Skill skill) {
		String upSql = "UPDATE skill SET skill_description = ? WHERE skill_id = ?";
		boolean isUpdate = false;
		try {
					ps = con.prepareStatement(upSql);
					ps.setString(1, skill.getDescription());
					ps.setString(4, skill.getSkill_id());
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
