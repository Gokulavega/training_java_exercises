package training_java_Jdbc;

import java.sql.Date;

public class Employee {
	
	private String employeeId;
	private String employeeName;
	private Date dateOfJoining;
	private double salary;
	public Employee() {
		
	}
	
	public Employee(String employeeId, String employeeName, Date dateOfJoining, double salary) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.dateOfJoining = dateOfJoining;
		this.salary = salary;
	}

	
	@Override
	public String toString() {
		return employeeId + "," + employeeName + "," + dateOfJoining + "," + salary;
	}

	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}
