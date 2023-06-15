package com.Avega.Training.Pojo;

import java.sql.Date;

public class Employee {
	
	private String employee_id;
	private String name;
	private Date doj;
	private String designation;
	private String department;
	private String skill_id;
	
	public Employee() {
		
	}

	public Employee(String employee_id, String name, Date doj, String designation, String department, String skill_id) {
		super();
		this.employee_id = employee_id;
		this.name = name;
		this.doj = doj;
		this.designation = designation;
		this.department = department;
		this.skill_id = skill_id;
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSkill_id() {
		return skill_id;
	}

	public void setSkill_id(String skill_id) {
		this.skill_id = skill_id;
	}

	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", name=" + name + ", doj=" + doj + ", designation="
				+ designation + ", department=" + department + ", skill_id=" + skill_id + "]";
	}
	
	
}
