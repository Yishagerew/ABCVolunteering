package edu.mum.abcVolunteering.business;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import edu.mum.abcVolunteering.model.Staff;
import edu.mum.abcVolunteering.repository.ABCDao;

public class StaffImpl {

	public static int addNewStaffInfo(Staff staff) {
		EntityManager em = ABCDao.instance.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			em.persist(staff);
		} catch (PersistenceException e) {
			System.out.println(e.getMessage());
			return -1;
		}
		tx.commit();
		return 1;
	}

	public static Staff findStaffByUserName(String userName) {
		EntityManager em = ABCDao.instance.getEntityManager();
		Query query = em.createNamedQuery("Staff.findByUserName", Staff.class).setParameter("email", userName);
		try {
			Staff staff = (Staff) query.getSingleResult();
			return staff;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	public static int deleteStaffInfo(String userName) {
		EntityManager em = ABCDao.instance.getEntityManager();
		Staff staff = findStaffByUserName(userName);
		if (staff != null) {
			try {
				EntityTransaction tx = em.getTransaction();
				tx.begin();
				em.remove(staff);
				tx.commit();
				return 1;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return -1;
	}

	public static int updateStaffInfo(Staff staff) {
		EntityManager em = ABCDao.instance.getEntityManager();

		try {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.merge(staff);
			tx.commit();
			return 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return -1;
	}

}
