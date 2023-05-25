package training_java;

import java.util.List;

public interface SkillService {
	
	List<Skill> findAllSkill();
	List<Skill> findSkillByName(String name);
	Skill findSkill(String id);
	boolean createSkill(Skill skill);
	boolean removeSkill(Skill skill);
	Skill editSkill(Skill skill);
}
