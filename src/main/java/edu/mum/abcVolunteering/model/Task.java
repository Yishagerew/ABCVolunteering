package edu.mum.abcVolunteering.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
	@NamedQuery(name = "Task.findByProject", query = "select t from Task t where t.project = :project"),
	@NamedQuery(name = "Task.findById", query = "select t from task t where t.taskId = :taskId")
})

public class Task {
	@Id
	@GeneratedValue
	private int taskId;
	private CompletionStatus status;
	private Date startDate;
	private Date endDate;
	private int numberOfDevelopers;
	
	@OneToMany(mappedBy = "task")
	private List<Skill> requiredSkill = new ArrayList<>();
	@ManyToOne
	private Project project;
	
	

	public CompletionStatus getStatus() {
		return status;
	}

	public void setStatus(CompletionStatus status) {
		this.status = status;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public List<Skill> getRequiredSkill() {
		return requiredSkill;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public int getNumberOfDevelopers() {
		return numberOfDevelopers;
	}

	public void setNumberOfDevelopers(int numberOfDevelopers) {
		this.numberOfDevelopers = numberOfDevelopers;
	}
	
	
	
	

}
