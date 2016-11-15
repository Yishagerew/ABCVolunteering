package edu.mum.abcVolunteering.business;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import edu.mum.abcVolunteering.model.Skill;
import edu.mum.abcVolunteering.repository.ABCDao;

public class SkillImpl {

	public static int addNewSkillInfo(Skill skill) {
		EntityManager em = ABCDao.instance.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			em.persist(skill);
		} catch (PersistenceException e) {
			System.out.println(e.getMessage());
			return -1;
		}
		tx.commit();
		return 1;
	}

	public static Skill findSkillById(int skillId) {
		EntityManager em = ABCDao.instance.getEntityManager();
		Query query = em.createNamedQuery("Skill.findById", Skill.class).setParameter("skillId", skillId);
		try {
			Skill skill = (Skill) query.getSingleResult();
			return skill;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	public static int deleteSkillInfo(int skillId) {
		EntityManager em = ABCDao.instance.getEntityManager();
		Skill skill = findSkillById(skillId);
		if (skill != null) {
			try {
				EntityTransaction tx = em.getTransaction();
				tx.begin();
				em.remove(skill);
				tx.commit();
				return 1;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return -1;
	}

	public static int updateSkillInfo(Skill skill) {
		EntityManager em = ABCDao.instance.getEntityManager();

		try {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.merge(skill);
			tx.commit();
			return 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return -1;
	}

}
