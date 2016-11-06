package edu.mum.abcVolunteering.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Volunteer {
	@Id
	@GeneratedValue
	private int volunteerId;
	
	private String name;
	@Temporal(TemporalType.DATE)
	private Date registeredDate;
	@Embedded
	private Address address;
	
	@OneToMany(mappedBy = "volunteer")
	private List<Task>tasks = new ArrayList<>();
	
	@Embedded
	private Account account;
	
	private static DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);


	public Volunteer(String name, String registeredDate, Address address) {
		this.name = name;
		setRegisteredDate(registeredDate);
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public String getRegisteredDate() {
		return df.format(registeredDate);
	}

	public Address getAddress() {
		return address;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void setRegisteredDate(String registeredDate) {
		try {
			this.registeredDate = df.parse(registeredDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	
}
