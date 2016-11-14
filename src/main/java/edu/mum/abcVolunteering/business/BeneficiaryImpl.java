package edu.mum.abcVolunteering.business;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import edu.mum.abcVolunteering.dao.ABCDao;
import edu.mum.abcVolunteering.model.Beneficiary;

public class BeneficiaryImpl {

	
	/**
	 * Volunteers should be able to offer their services for tasks on projects.
	 * @param beneficiaryId
	 * @return
	 */
	public static Beneficiary findBeneficiaryAndProjects(int beneficiaryId) {
		EntityManager em = ABCDao.instance.getEntityManager();
		Query query = em.createNamedQuery("Beneficiary.findProjects", Beneficiary.class).setParameter("skillName",
				beneficiaryId);
		Beneficiary beneficiary = null;
		try {
			beneficiary = (Beneficiary) query.getSingleResult();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return beneficiary;
	}

	public static int deleteBeneficiary(int beneficiaryId) {
		EntityManager em = ABCDao.instance.getEntityManager();
		Beneficiary beneficiary = findBeneficiaryAndProjects(beneficiaryId);
		if (beneficiary != null) {
			try {
				EntityTransaction tx = em.getTransaction();
				tx.begin();
				em.remove(beneficiary);
				tx.commit();
				return 1;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return -1;
	}
	
	public static int addNewBeneficiary(Beneficiary beneficiary) {
		EntityManager em =  ABCDao.instance.getEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			em.persist(beneficiary);
		} catch (PersistenceException e) {
			e.printStackTrace();
			return -1;
		}
		tx.commit();
		return 1;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Beneficiary> findAllBeneficiaries() {
		EntityManager em = ABCDao.instance.getEntityManager();
		Query query = em.createNamedQuery("Beneficiary.findAll", Beneficiary.class);
		List<Beneficiary> beneficiary = null;
		try {
			beneficiary = query.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return beneficiary;
	}

	
}
