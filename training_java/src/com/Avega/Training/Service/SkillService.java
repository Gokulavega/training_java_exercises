package com.Avega.Training.Service;

import java.util.List;

import com.Avega.Training.Execption.SkillNotFoundExecption;
import com.Avega.Training.Pojo.Skill;

public interface SkillService {
	
	List<Skill> findAllSkill();
	Skill findSkill(String id) throws SkillNotFoundExecption;
	boolean createSkill(Skill skill);
	boolean removeSkill(String id);
	boolean editSkill(Skill skill);
	List<Skill> loadExcelToDB(String excelFilePath);
}
