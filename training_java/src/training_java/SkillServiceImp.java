package training_java;

import java.util.List;

public class SkillServiceImp implements SkillService {
	
	SkillDao dao = null;
	
	public SkillServiceImp() {
		this.dao = new SkillDaoImp();
	}

	@Override
	public List<Skill> findAllSkill() {
		// TODO Auto-generated method stub
		return dao.getAllSkill();
	}

	@Override
	public List<Skill> findSkillByName(String name) {
		List<Skill> skill = null;
		try {
			skill = dao.getSkillByName(name);
		} catch (SkillNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return skill;
	}

	@Override
	public Skill findSkill(String id) {
		// TODO Auto-generated method stub
		return dao.getSkill(id);
	}

	@Override
	public boolean createSkill(Skill skill) {
		// TODO Auto-generated method stub
		return dao.addSkill(skill);
	}

	@Override
	public boolean removeSkill(Skill skill) {
		// TODO Auto-generated method stub
		return dao.deleteSkill(skill);
	}

	@Override
	public Skill editSkill(Skill skill) {
		// TODO Auto-generated method stub
		return dao.updateSkill(skill);
	}
	
	
}
