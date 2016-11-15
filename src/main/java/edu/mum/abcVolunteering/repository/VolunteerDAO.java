package edu.mum.abcVolunteering.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.abcVolunteering.model.Volunteer;

public interface VolunteerDAO extends JpaRepository<Volunteer, Long> {

	List<Volunteer> findVolunteerByVolunteerId(int volunteerId);

	Long deleteByVolunteerId(int volunteerId);
}
