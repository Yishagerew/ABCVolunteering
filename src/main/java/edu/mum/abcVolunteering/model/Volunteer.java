package edu.mum.abcVolunteering.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	
	private List<Task>tasks = new ArrayList<>();
	
	@Embedded
	private Account account;

	public Volunteer(String name, Date registeredDate, Address address) {
		this.name = name;
		this.registeredDate = registeredDate;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public Date getRegisteredDate() {
		return registeredDate;
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
	
}
