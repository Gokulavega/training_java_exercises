package com.Avega.Training.Pojo;

import java.sql.Date;

public class Training {
	
	private String training_id;
	private String description;
	private Date start_date;
	private Date end_date;
	private String requestor_id;
	private String trainer;
	private String skill_id;
	
	public Training() {
		
	}

	public Training(String training_id, String description, Date start_date, Date end_date, String requestor_id,
			String trainer, String skill_id) {
		super();
		this.training_id = training_id;
		this.description = description;
		this.start_date = start_date;
		this.end_date = end_date;
		this.requestor_id = requestor_id;
		this.trainer = trainer;
		this.skill_id = skill_id;
	}

	public String getTraining_id() {
		return training_id;
	}

	public void setTraining_id(String training_id) {
		this.training_id = training_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public String getRequestor_id() {
		return requestor_id;
	}

	public void setRequestor_id(String requestor_id) {
		this.requestor_id = requestor_id;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public String getSkill_id() {
		return skill_id;
	}

	public void setSkill_id(String skill_id) {
		this.skill_id = skill_id;
	}

	@Override
	public String toString() {
		return "Training [training_id=" + training_id + ", description=" + description + ", start_date=" + start_date
				+ ", end_date=" + end_date + ", requestor_id=" + requestor_id + ", trainer=" + trainer + ", skill_id="
				+ skill_id + "]";
	}
	
	
}
