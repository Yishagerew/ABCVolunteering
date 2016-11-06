package edu.mum.abcVolunteering.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
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
@NamedQueries({ @NamedQuery(name = "Project.findByStatus", query = "Select p from Project p where status = :status"),
		@NamedQuery(name = "Project.findById", query = "Select p from Project p where projectId = :projectId"),
		@NamedQuery(name = "Project.findAll", query = "Select p from Project p"),
		@NamedQuery(name = "Project.findByKeyWordAndLocation", query = "Select p from Project p where lower(p.description) like CONCAT(%, CONCAT(:keyword, %)) and p.city = :city"),
		@NamedQuery(name = "Project.findByRequiredSkill", query = "Select distinct p from Project p join p.tasks t join p.tasks.skills s where s.name = :skillName"),
		@NamedQuery(name = "Project.findByParticipatedVolunteer", query = "Select distinct p from Project p join p.tasks t join t.volunteer v where v.volunteerId = :volunteerId ") })
public class Project {

	@Id
	@GeneratedValue
	private String projectId;

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

	public List<Task> getTasks() {
		return tasks;
	}

	public Beneficiary getBeneficiary() {
		return beneficiary;
	}

}
