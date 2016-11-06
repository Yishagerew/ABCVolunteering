package edu.mum.abcVolunteering.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "Project.findByStatus", query = "Select p from Project p where p.status = :status"),
//		@NamedQuery(name = "Project.findById", query = "Select p from Project p where p.projectId = :projectId"),
		@NamedQuery(name = "Project.findAll", query = "Select p from Project p order by p.status"),
		@NamedQuery(name = "Project.findByKeyWordAndLocation", query = "Select p from Project p where p.description like :keyword and p.location.city = :city"),
		@NamedQuery(name = "Project.findByRequiredSkill", query = "Select distinct p from Project p join p.tasks t join t.requiredSkill s where s.name = :skillName"),
		@NamedQuery(name = "Project.findByParticipatedVolunteer", query = "Select distinct p from Project p join p.tasks t join t.volunteer v where v.volunteerId = :volunteerId ") })
public class Project {

	@Id
	@GeneratedValue
	private int projectId;

	@Embedded
	private Address location;
	private String description;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	@Enumerated(EnumType.STRING)
	private CompletionStatus status;

	private static DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);

	// bidirectional
	@OneToMany(mappedBy = "project", cascade = CascadeType.PERSIST)
	private List<Task> tasks = new ArrayList<>();
	// bidirectional
	@ManyToOne
	@JoinColumn(name = "beneficiaryId")
	private Beneficiary beneficiary;
	
	public Project(Address location, String description, String startDate, String endDate, CompletionStatus status,
			List<Task> tasks) {
		this.location = location;
		this.description = description;
		setStartDate(startDate);
		setEndDate(endDate);
		this.status = status;
		this.tasks = tasks;
	}
	

	public Project(Address location, String description, String startDate, String endDate, CompletionStatus status) {
		this.location = location;
		this.description = description;
		setStartDate(startDate);
		setEndDate(endDate);
		this.status = status;
	}


	public Address getLocation() {
		return location;
	}

	/**
	 * Getters and setters
	 */

	public String getDescription() {
		return description;
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

	public CompletionStatus getStatus() {
		return status;
	}

	/**
	 * 
	 * @return unmodifiable list
	 */
	
	public List<Task> getTasks() {
		return Collections.unmodifiableList(tasks);
	}
	
	public void addTask(Task task){
		task.setProject(this);
		tasks.add(task);
	}
	public void removeTask(Task task){
		task.setProject(null);
		this.tasks.remove(task);
	}

	public Beneficiary getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}


	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", location=" + location + ", description=" + description
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", status=" + status + "]";
	}


	public int getProjectId() {
		return projectId;
	}
	
	

}
