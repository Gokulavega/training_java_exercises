package training_java;

import java.util.Map;

public class Skill {
	
	private String skillId;
	private String skillName;
	Map<String, Employee> employee;
	public Skill() {
		
	}
	
	public Skill(String skillId, String skillName, Map<String, Employee> employee) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
		this.employee = employee;
	}

	
	@Override
	public String toString() {
		return "Skill [skillId=" + skillId + ", skillName=" + skillName + ", employee=" + employee + "]";
	}

	public String getSkillId() {
		return skillId;
	}
	public void setSkillId(String skillId) {
		this.skillId = skillId;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public Map<String, Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(Map<String, Employee> employee) {
		this.employee = employee;
	}
	
	
}
