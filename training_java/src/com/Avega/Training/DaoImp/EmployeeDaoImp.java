package com.Avega.Training.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.Avega.Training.Dao.EmployeeDao;
import com.Avega.Training.Execption.EmployeeNotFoundExecption;
import com.Avega.Training.Pojo.Employee;
import com.Avega.Training.Util.DbUtil;

public class EmployeeDaoImp implements EmployeeDao{
	
	static Logger logger = Logger.getLogger(EmployeeDaoImp.class.getName());
	Connection con = DbUtil.getConnected();
	PreparedStatement ps = null;
	@Override
	public List<Employee> getAllEmployee() {
		ResultSet rs = null;
		String sql = "SELECT * FROM employee";
		List<Employee> employees = new ArrayList<>();
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				employees.add(new Employee(rs.getString(1),rs.getString(2),rs.getDate(3),rs.getString(4),rs.getString(5),rs.getString(6)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
	}
	@Override
	public Employee getEmployee(String id) throws EmployeeNotFoundExecption {
		Employee employee = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM employee";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				if(rs.getString(1).equalsIgnoreCase(id)) {
				employee = new Employee(rs.getString(1),rs.getString(2),rs.getDate(3),rs.getString(4),rs.getString(5),rs.getString(6));
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
		String sql = "INSERT INTO employee VALUES(?,?,?,?,?,?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, employee.getEmployee_id());
			ps.setString(2, employee.getName());
			ps.setDate(3, employee.getDoj());
			ps.setString(4, employee.getDesignation());
			ps.setString(5, employee.getDepartment());
			ps.setString(6, employee.getSkill_id());
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
		String upSql = "UPDATE employee SET name = ?, doj = ?,  designation = ?, department = ?, skill_id = ? WHERE employee_id = ?";
		boolean isUpdate = false;
		try {
					ps = con.prepareStatement(upSql);
					ps.setString(1, employee.getName());
					ps.setDate(2, employee.getDoj());
					ps.setString(3, employee.getDesignation());
					ps.setString(4, employee.getDepartment());
					ps.setString(5, employee.getSkill_id());
					ps.setString(6, employee.getEmployee_id());
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
