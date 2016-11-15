package edu.mum.abcVolunteering.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.mum.abcVolunteering.model.Skill;

public interface SkillDAO extends JpaRepository<Skill, Long> {
	List<Skill> findSkillBySkillId(int skillId);

	Long deleteBySkillId(int skillId);

	@Query("update Skill s set s.name =?1 and s.description = ?2 where s.skillId = ?3 ")
	Long updateSkillNameandDescription(String name, String description, int skillId);
	
}
