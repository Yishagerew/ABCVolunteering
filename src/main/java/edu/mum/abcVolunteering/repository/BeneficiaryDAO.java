package edu.mum.abcVolunteering.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.mum.abcVolunteering.model.Beneficiary;

@Repository
public interface BeneficiaryDAO extends JpaRepository<Beneficiary, Long>{
	List<Beneficiary>findByBeneficiaryId(int beneficiaryId);
	void deleteByBeneficiaryId(int beneficiaryId);
	@Query("select b from Beneficiary b")
	List<Beneficiary> findAllBeneficiaries(Pageable page);
	List<Beneficiary>findByName(String name);
}
