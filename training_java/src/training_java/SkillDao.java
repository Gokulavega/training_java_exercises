package training_java;

import java.util.List;

public interface SkillDao {
	
	List<Skill> getAllSkill();
	List<Skill> getSkillByName(String name) throws SkillNotFoundException;
	Skill getSkill(String id);
	boolean addSkill(Skill skill);
	boolean deleteSkill(Skill skill);
	Skill updateSkill(Skill skill);
}
