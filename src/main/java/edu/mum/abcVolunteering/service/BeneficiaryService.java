package edu.mum.abcVolunteering.service;

import java.util.List;

import org.springframework.data.domain.Page;

import edu.mum.abcVolunteering.model.Beneficiary;

public interface BeneficiaryService {
	
	List<Beneficiary>findByBeneficiaryId(int beneficiaryId);
	void deleteByBeneficiaryId(long beneficiaryId);
	List<Beneficiary> findAll(int page, int pageSize);
	List<Beneficiary>findByName(String name);
	public void save(Beneficiary beneficiary);

}
