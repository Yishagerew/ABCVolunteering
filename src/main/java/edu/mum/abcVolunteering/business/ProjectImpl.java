package edu.mum.abcVolunteering.business;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import edu.mum.abcVolunteering.model.CompletionStatus;
import edu.mum.abcVolunteering.model.Project;
import edu.mum.abcVolunteering.model.Task;
import edu.mum.abcVolunteering.repository.ABCDao;

public class ProjectImpl {

	/**
	 * 
	 * @param project
	 * @return
	 */
	public static int addNewProjectInfo(Project project) {
		EntityManager em = ABCDao.instance.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			em.persist(project);
		} catch (PersistenceException e) {
			System.out.println(e.getMessage());
			return -1;
		}
		tx.commit();
		return 1;
	}

	/**
	 * 
	 * @param projectId
	 * @return
	 */
	public static int deleteProjectInfo(int projectId) {
		EntityManager em = ABCDao.instance.getEntityManager();
		Project project = findProjectById(projectId);
		if (project != null) {
			try {
				EntityTransaction tx = em.getTransaction();
				tx.begin();
				em.remove(project);
				tx.commit();
				return 1;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return -1;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public static Project findProjectById(int id) {
		EntityManager em = ABCDao.instance.getEntityManager();
		Query query = em.createNamedQuery("Project.findById", Project.class).setParameter("projectId", id);
		try {
			Project project = (Project) query.getSingleResult();
			return project;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<Project> getAllProjectsInfoByStatus() {

		EntityManager em = ABCDao.instance.getEntityManager();
		Query query = em.createNamedQuery("Project.findAll", Project.class);
		List<Project> project = null;
		try {
			project = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return project;
	}

	/**
	 * List projects by status
	 * 
	 * @param status
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<Project> findProjectsByStatus(CompletionStatus status) {
		EntityManager em = ABCDao.instance.getEntityManager();
		Query query = em.createNamedQuery("Project.findByStatus", Project.class).setParameter("status", status);
		List<Project> project = null;
		try {
			project = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return project;
	}

	/**
	 * Search projects by keywords and location
	 * 
	 * @param keyword
	 * @param city
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<Project> findProjectsByKeywordAndCity(String keyword, String city) {
		EntityManager em = ABCDao.instance.getEntityManager();
		Query query = em.createNamedQuery("Project.findByKeyWordAndLocation", Project.class)
				.setParameter("keyword", keyword)
				.setParameter("city", city);
		List<Project> project = null;
		try {
			project = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return project;
	}

	/**
	 * Look for projects that requires a particular type of resource/skill
	 * 
	 * @param skillName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<Project> findProjectsByRequiredSkill(String skillName) {
		EntityManager em = ABCDao.instance.getEntityManager();
		Query query = em.createNamedQuery("Project.findByRequiredSkill", Project.class).setParameter("skillName",
				skillName);
		List<Project> project = null;
		try {
			project = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return project;
	}

	/**
	 * List tasks for a project
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<Task> findTasksByProject(int id) {
		EntityManager em = ABCDao.instance.getEntityManager();
		Query query = em.createNamedQuery("Task.findByProject", Task.class).setParameter("projectId", id);
		try {
			List<Task> tasks = query.getResultList();
			return tasks;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * List projects and tasks where a volunteer have offered services, ordered
	 * by time of the task.
	 * 
	 * @param volunteerId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<Project> findProjectsByVolunteerId(int volunteerId) {
		EntityManager em = ABCDao.instance.getEntityManager();
		Query query = em.createNamedQuery("Project.findByParticipatedVolunteer", Project.class)
				.setParameter("volunteerId", volunteerId);
		try {
			List<Project> projects = query.getResultList();
			return projects;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
