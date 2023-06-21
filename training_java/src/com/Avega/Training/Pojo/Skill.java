package com.Avega.Training.Pojo;

public class Skill {
	
	private String skill_id;
	private String description;
	
	public Skill() {
		
	}

	public Skill(String skill_id, String description) {
		super();
		this.skill_id = skill_id;
		this.description = description;
	}

	public String getSkill_id() {
		return skill_id;
	}

	public void setSkill_id(String skill_id) {
		this.skill_id = skill_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "skill [skill_id=" + skill_id + ", description=" + description + "]";
	}
	
	
}
