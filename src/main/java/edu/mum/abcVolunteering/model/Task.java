package edu.mum.abcVolunteering.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({ @NamedQuery(name = "Task.findByProject", query = "select t from Task t where t.project.projectId = :projectId"),
		@NamedQuery(name = "Task.findById", query = "select t from Task t where t.taskId = :taskId") })

public class Task {
	@Id
	@GeneratedValue
	private int taskId;
	private CompletionStatus status;
	private Date startDate;
	private Date endDate;

	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "Task_Skills", joinColumns = @JoinColumn(name = "TaskId"), inverseJoinColumns = @JoinColumn(name = "SkillId"))
	private List<Skill> requiredSkill = new ArrayList<>();

	// bidirectional association
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "projectId")
	private Project project;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "volunteerId")
	private Volunteer volunteer;

	public Task(CompletionStatus status, String startDate, String endDate) {
		this.status = status;
		setStartDate(startDate);
		setEndDate(endDate);
	}
	
	

	public Task(CompletionStatus status, String startDate, String endDate, List<Skill> requiredSkill) {
		this.status = status;
		setStartDate(startDate);
		setEndDate(endDate);
		this.requiredSkill = requiredSkill;
	}



	private static DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);

	public CompletionStatus getStatus() {
		return status;
	}

	public void setStatus(CompletionStatus status) {
		this.status = status;
	}

	public String getStartDate() {
		return df.format(startDate);
	}

	public String getEndDate() {
		return df.format(endDate);
	}

	public void setStartDate(String startDate) {
		try {
			this.startDate = df.parse(startDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setEndDate(String endDate) {
		try {
			this.endDate = df.parse(endDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public Volunteer getVolunteer() {
		return volunteer;
	}

	public void setVolunteer(Volunteer volunteer) {
		this.volunteer = volunteer;
	}



	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", status=" + status + ", startDate=" + startDate + ", endDate=" + endDate
				+ "]";
	}
	
	
	
}
