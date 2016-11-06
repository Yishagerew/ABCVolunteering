package edu.mum.abcVolunteering.model;

import java.util.Date;
import java.util.List;

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
	@NamedQuery(name = "Beneficiary.findProjects", query = "Select b from Beneficiary b where b.beneficiaryId = :beneficiaryId")
})
public class Beneficiary {
	
	@Id
	@GeneratedValue
	private int beneficiaryId;
	private String name;
	@Lob
	private byte[]photo;
	
	@OneToMany(mappedBy = "beneficiary")
	private List<Project> projects;
	
	@Temporal(TemporalType.DATE)
	private Date registeredDate;
	
	/**
	 * 
	 * @param name
	 * @param photo
	 * @param projects
	 * @param registeredDate
	 */
	public Beneficiary(String name, byte[] photo, List<Project> projects, Date registeredDate) {
		this.name = name;
		this.photo = photo;
		this.projects = projects;
		this.registeredDate = registeredDate;
	}

	public String getName() {
		return name;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}
	
	
	
}
