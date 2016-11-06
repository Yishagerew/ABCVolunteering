package edu.mum.abcVolunteering.business;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import dao.ABCDao;
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

}