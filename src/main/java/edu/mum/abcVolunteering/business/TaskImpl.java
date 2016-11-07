package edu.mum.abcVolunteering.business;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import edu.mum.abcVolunteering.dao.ABCDao;
import edu.mum.abcVolunteering.model.Task;

public class TaskImpl {

	public static int addNewTaskInformation(Task task) {
		EntityManager em = ABCDao.instance.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			em.persist(task);
		} catch (PersistenceException e) {
			System.out.println(e.getMessage());
			return -1;
		}
		tx.commit();
		return 1;
	}

	public static Task findTaskById(int id) {
		EntityManager em = ABCDao.instance.getEntityManager();
		Query query = em.createNamedQuery("Task.findById", Task.class).setParameter("taskId", id);
		try {
			Task task = (Task) query.getSingleResult();
			return task;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static int deleteTaskInfo(int taskId) {
		EntityManager em = ABCDao.instance.getEntityManager();
		Task task = findTaskById(taskId);
		if (task != null) {
			try {
				EntityTransaction tx = em.getTransaction();
				tx.begin();
				em.remove(task);
				tx.commit();
				return 1;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return -1;
	}

	public static int updateTaskInfo(Task task) {
		EntityManager em = ABCDao.instance.getEntityManager();

		try {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.merge(task);
			tx.commit();
			return 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return -1;
	}

}
