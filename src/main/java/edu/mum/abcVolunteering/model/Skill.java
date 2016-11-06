package edu.mum.abcVolunteering.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Skill {
	@Id
	@GeneratedValue
	private int skillId;
	
	private String name;
	private String description;
	
	@ManyToMany(mappedBy = "requiredSkill")
	private List<Task> tasks = new ArrayList<>();
	
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

	@Override
	public String toString() {
		return "Skill [skillId=" + skillId + ", name=" + name + ", description=" + description + "]";
	}

	
}
