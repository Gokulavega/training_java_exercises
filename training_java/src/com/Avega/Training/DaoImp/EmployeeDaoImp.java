package com.Avega.Training.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import com.Avega.Training.Dao.EmployeeDao;
import com.Avega.Training.Dao.SkillDao;
import com.Avega.Training.Execption.EmployeeNotFoundExecption;
import com.Avega.Training.Pojo.Employee;
import com.Avega.Training.Pojo.Skill;
import com.Avega.Training.Util.DbUtil;

public class EmployeeDaoImp implements EmployeeDao{
	
	static Logger logger = Logger.getLogger(EmployeeDaoImp.class.getName());
	Connection con = DbUtil.getConnected();
	PreparedStatement ps = null;
	PreparedStatement ps1 = null;
	SkillDao dao = new SkillDaoImp();
	List<Skill> skill = dao.getAllSkill();
	
	@Override
	public List<Employee> getAllEmployee() {
		ResultSet rs = null;
		ResultSet rs1 = null;
		String sql = "SELECT * FROM employee";
		String sqlSkill = "SELECT * FROM skills";
		List<Employee> employees = new ArrayList<>();
		Set<Skill> skills = new HashSet<Skill>();
		
		try {
			ps = con.prepareStatement(sql);
			ps1 = con.prepareStatement(sqlSkill);
			rs = ps.executeQuery();
			rs1 = ps1.executeQuery();
			while (rs.next()) {
				while(rs1.next()) {
					if(rs.getString(1).equalsIgnoreCase(rs1.getString(1))) {
						for(Skill s : skill) {
							if(rs1.getString(2).equalsIgnoreCase(s.getSkill_id()))
								skills.add(new Skill(s.getSkill_id(),s.getDescription()));
						}
					}
				}
				employees.add(new Employee(rs.getString(1),rs.getString(2),rs.getDate(3),rs.getString(4),rs.getString(5),skills));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
	}
	@Override
	public Employee getEmployee(String id) throws EmployeeNotFoundExecption {
		ResultSet rs = null;
		ResultSet rs1 = null;
		String sql = "SELECT * FROM employee";
		String sqlSkill = "SELECT * FROM skills";
		Employee employee = null;
		Set<Skill> skills = new HashSet<Skill>();
		
		try {
			ps = con.prepareStatement(sql);
			ps1 = con.prepareStatement(sqlSkill);
			rs = ps.executeQuery();
			rs1 = ps1.executeQuery();
			while (rs.next()) {
				if(rs.getString(1).equalsIgnoreCase(id)) {
					while(rs1.next()) {
						if(rs.getString(1).equalsIgnoreCase(rs1.getString(1))) {
							for(Skill s : skill) {
								if(rs1.getString(2).equalsIgnoreCase(s.getSkill_id()))
									skills.add(new Skill(s.getSkill_id(),s.getDescription()));
							}
						}
					}
					employee = new Employee(rs.getString(1),rs.getString(2),rs.getDate(3),rs.getString(4),rs.getString(5),skills);
					break;
				}
			}
		} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		if(employee == null) {
			throw new EmployeeNotFoundExecption();
		}
		return employee;
	}
	@Override
	public boolean addEmployee(Employee employee) {
		boolean isAdded = false;
		String sql = "INSERT INTO employee VALUES(?,?,?,?,?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, employee.getEmployee_id());
			ps.setString(2, employee.getName());
			ps.setDate(3, employee.getDoj());
			ps.setString(4, employee.getDesignation());
			ps.setString(5, employee.getDepartment());
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
	public boolean deleteEmployee(String id) {
		boolean isDeleted = false;
		String sql = "DELETE FROM employee WHERE employee_id = ?";
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
	public boolean updateEmployee(Employee employee) {
		String upSql = "UPDATE employee SET name = ?, doj = ?,  designation = ?, department = ? WHERE employee_id = ?";
		boolean isUpdate = false;
		try {
					ps = con.prepareStatement(upSql);
					ps.setString(1, employee.getName());
					ps.setDate(2, employee.getDoj());
					ps.setString(3, employee.getDesignation());
					ps.setString(4, employee.getDepartment());
					ps.setString(5, employee.getEmployee_id());
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
