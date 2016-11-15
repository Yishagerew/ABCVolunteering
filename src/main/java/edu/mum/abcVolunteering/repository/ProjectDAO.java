package edu.mum.abcVolunteering.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.mum.abcVolunteering.model.CompletionStatus;
import edu.mum.abcVolunteering.model.Project;

public interface ProjectDAO extends JpaRepository<Project, Long> {
	Long deleteByProjectId(int projectId);

	List<Project> findByProjectId(int projectId);

	List<Project> findByStatus(CompletionStatus status);

	@Query("Select distinct p from Project p join p.tasks t join t.requiredSkill s where s.name = :skillName")
	List<Project> findByRequiredSkill(@Param("skillName") String skillName);

	@Query("Select p from Project p where p.description like :keyword and p.location.city = :city")
	List<Project> findProjectsByKeywordAndCity(@Param("keyword") String keyword, @Param("city") String city);
}
