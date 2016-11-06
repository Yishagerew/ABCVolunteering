package edu.mum.abcVolunteering.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Skill {
	@Id
	@GeneratedValue
	private int skillId;
	
	private String name;
	private String description;
	private int yearsOfExperience;
	
	
	public Skill(String name, String description, int yearsOfExperience) {
		this.name = name;
		this.description = description;
		this.yearsOfExperience = yearsOfExperience;
	}
	
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public int getYearsOfExperience() {
		return yearsOfExperience;
	}
	
}
