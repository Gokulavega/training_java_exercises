package com.Avega.Training.Pojo;

public class Allocation {
	
	private String allocation_id;
	private String training_id;
	private String employee_id;
	private String status;
	private int score;
	private String remarks;
	
	public Allocation() {
		
	}

	public String getAllocation_id() {
		return allocation_id;
	}

	public void setAllocation_id(String allocation_id) {
		this.allocation_id = allocation_id;
	}

	public String getTraining_id() {
		return training_id;
	}

	public void setTraining_id(String training_id) {
		this.training_id = training_id;
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Allocation(String allocation_id, String training_id, String employee_id, String status, int score,
			String remarks) {
		super();
		this.allocation_id = allocation_id;
		this.training_id = training_id;
		this.employee_id = employee_id;
		this.status = status;
		this.score = score;
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "allocation [allocation_id=" + allocation_id + ", training_id=" + training_id + ", employee_id="
				+ employee_id + ", status=" + status + ", score=" + score + ", remarks=" + remarks + "]";
	}
	
	
}
