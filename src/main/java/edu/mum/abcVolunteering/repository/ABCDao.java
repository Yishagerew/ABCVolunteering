package edu.mum.abcVolunteering.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public enum ABCDao {
	instance;
	private static EntityManagerFactory emf;

	public static final ThreadLocal<EntityManager> threadlocal = new ThreadLocal<EntityManager>();

	public static EntityManagerFactory getEntityManagerfactory() {
		try {
			if (emf == null) {
				emf = Persistence.createEntityManagerFactory("abcvolunteer");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emf;
	}

	public EntityManager getEntityManager() {
		EntityManager em = threadlocal.get();
		if (em == null) {
			em = getEntityManagerfactory().createEntityManager();
			threadlocal.set(em);

		}
		return em;
	}

	public void closeConnections(EntityManager em) {
		em.close();
	}

}
