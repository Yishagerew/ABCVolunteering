package edu.mum.abcVolunteering.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.abcVolunteering.model.Beneficiary;
import edu.mum.abcVolunteering.service.BeneficiaryService;

@Controller
@RequestMapping(value = "/beneficiaries")
public class BeneficiaryController {
	
	static int pageSize;
	
	@Autowired
	BeneficiaryService service;
	
	@RequestMapping("")
	public String getAllBeneficiaries(Model m){
		
		List<Beneficiary> beneficiaries = service.findAll(1, pageSize);
		m.addAttribute("beneficiary", beneficiaries);
		
		return "beneficiary";
	}
	

}
