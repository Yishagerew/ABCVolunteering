package edu.mum.abcVolunteering.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.abcVolunteering.model.Beneficiary;
import edu.mum.abcVolunteering.repository.BeneficiaryDAO;
import edu.mum.abcVolunteering.service.BeneficiaryService;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class BeneficiaryServiceImpl implements BeneficiaryService {

	@Autowired
	private BeneficiaryDAO beneficiaryRepo;

	@Override
	public List<Beneficiary> findByBeneficiaryId(int beneficiaryId) {
		return beneficiaryRepo.findByBeneficiaryId(beneficiaryId);
	}

	@Override
	public List<Beneficiary> findAll(int page, int pageSize) {
		Pageable pageable = new PageRequest(page, pageSize);
		return beneficiaryRepo.findAllBeneficiaries(pageable);
	}

	@Override
	public List<Beneficiary> findByName(String name) {
		return beneficiaryRepo.findByName(name);
	}

	@Override
	public void save(Beneficiary beneficiary) {
		beneficiaryRepo.save(beneficiary);
	}

	@Override
	public void deleteByBeneficiaryId(long beneficiaryId) {
		beneficiaryRepo.delete(beneficiaryId);
	}

}
