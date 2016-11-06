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
	
	public Skill(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	
	
}
