package training_java_Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import training_java.EmployeeNotFoundException;

public class EmployeeDaoService implements EmployeeDao {
	
	static Logger logger = Logger.getLogger(EmployeeDaoService.class.getName());
	Connection con = Jdbc.getConnected();
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
				employees.add(new Employee(rs.getString(1),rs.getString(2),rs.getDate(3),rs.getDouble(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public Employee getEmployee(String id) throws EmployeeNotFoundException {
		Employee employee = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM employee";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				if(rs.getString(1).equalsIgnoreCase(id)) {
				employee = new Employee(rs.getString(1),rs.getString(2),rs.getDate(3),rs.getDouble(4));
				break;
				}
			}
		} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		if(employee == null) {
			throw new EmployeeNotFoundException();
		}
		return employee;
	}
	
	@Override
	public boolean addEmployee(Employee employee) {
		boolean isAdded = false;
		String sql = "INSERT INTO employee VALUES(?,?,?,?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, employee.getEmployeeId());
			ps.setString(2, employee.getEmployeeName());
			ps.setDate(3, employee.getDateOfJoining());
			ps.setDouble(4, employee.getSalary());
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
	public Employee updateEmployee(Employee employee) {
		
		String upSql = "UPDATE employee SET employee_name = ? , date_of_joining = ? , salary = ? WHERE employee_id = ?";
		Employee updateEmployee = null;
		
				try {
					ps = con.prepareStatement(upSql);
					ps.setString(1, employee.getEmployeeName());
					ps.setDate(2, employee.getDateOfJoining());
					ps.setDouble(3, employee.getSalary());
					ps.setString(4, employee.getEmployeeId());
					int count = ps.executeUpdate();
						if(count > 0) {
							logger.info("update");
						}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
		return updateEmployee;
	}
	

}
