package training_java;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class SkillDaoImp implements SkillDao {
	
	ConcurrentHashMap<String, Skill> skills = new ConcurrentHashMap<>();
	
	@Override
	public List<Skill> getAllSkill() {
		// TODO Auto-generated method stub
		return new ArrayList(skills.values());
	}

	@Override
	public List<Skill> getSkillByName(String name) throws SkillNotFoundException {
		List<Skill> skillList = new ArrayList<>();
		for(Skill skill : skills.values()) {
			if(skill.getSkillName().equalsIgnoreCase(name)) {
				skillList.add(skill);
			}
		}
		if(skillList.isEmpty()) {
			throw new SkillNotFoundException();
		}
		return skillList;
	}

	@Override
	public Skill getSkill(String id) {
		// TODO Auto-generated method stub
		return skills.get(id);
	}

	@Override
	public boolean addSkill(Skill skill) {
		boolean flag = false;
		skills.put(skill.getSkillId(), skill);
		if(skills.get(skill.getSkillId()) != null ) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean deleteSkill(Skill skill) {
		boolean flag = false;
		skills.remove(skill.getSkillId(), skill);
		if(skills.get(skill.getSkillId()) == null ) {
			flag = true;
		}
		return flag;
	}

	@Override
	public Skill updateSkill(Skill skill) {
		
		Skill updateSkill  = skills.get(skill.getSkillId());
		updateSkill.setSkillName(skill.getSkillName());
		skills.put(skill.getSkillId(), updateSkill);
		
		return skills.get(skill.getSkillId());
	}

}
