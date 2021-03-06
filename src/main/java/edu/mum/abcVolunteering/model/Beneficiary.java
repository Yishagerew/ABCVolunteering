package edu.mum.abcVolunteering.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
	@NamedQuery(name = "Beneficiary.findProjects", query = "Select b from Beneficiary b where b.beneficiaryId = :beneficiaryId"),
	@NamedQuery(name = "Beneficiary.findAll", query = "Select b from Beneficiary b")
})
public class Beneficiary {
	
	@Id
	@GeneratedValue
	private int beneficiaryId;
	private String name;
	@Lob
	private byte[]photo;
	
	@OneToMany(mappedBy = "beneficiary", cascade = CascadeType.PERSIST)
	private List<Project> projects = new ArrayList<>();
	
	@Temporal(TemporalType.DATE)
	private Date registeredDate;
	
	private static DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);

	
	/**
	 * 
	 * @param name
	 * @param photo
	 * @param projects
	 * @param registeredDate
	 */
	public Beneficiary(String name, byte[] photo, List<Project> projects, String registeredDate) {
		this.name = name;
		this.photo = photo;
		this.projects = projects;
		setRegisteredDate(registeredDate);
	}
	
	

	public Beneficiary(String name, byte[] photo, String registeredDate) {
		this.name = name;
		this.photo = photo;
		setRegisteredDate(registeredDate);
	}



	public String getName() {
		return name;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public List<Project> getProjects() {
		return Collections.unmodifiableList(projects);
	}
	
	public void addProject(Project project){
		project.setBeneficiary(this);
		projects.add(project);
	}
	public void removeProject(Project project){
		project.setBeneficiary(null);
		projects.remove(project);
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(String registeredDate) {
		try {
			this.registeredDate =  df.parse(registeredDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	@Override
	public String toString() {
		return "Beneficiary [beneficiaryId=" + beneficiaryId + ", name=" + name + ", projects=" + projects
				+ ", registeredDate=" + registeredDate + "]";
	}
	
	
	
	
	
	
}
