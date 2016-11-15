package edu.mum.abcVolunteering.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.abcVolunteering.model.Staff;

public interface StaffDAO extends JpaRepository<Staff, Long> {

	List<Staff> findStaffByStaffId(int staffId);
	Long deleteByStaffId(int staffId);
	
	
	
}
