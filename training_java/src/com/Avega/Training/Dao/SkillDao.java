package com.Avega.Training.Dao;

import java.util.List;

import com.Avega.Training.Execption.SkillNotFoundExecption;
import com.Avega.Training.Pojo.Skill;

public interface SkillDao {
	
	List<Skill> getAllSkill();
	Skill getSkill(String id) throws SkillNotFoundExecption;
	boolean addSkill(Skill skill);
	boolean deleteSkill(String id);
	boolean updateSkill(Skill skill);
}
