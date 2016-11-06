package edu.mum.abcVolunteering.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
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

	@Embedded
	private Address address;
	
	@OneToMany(mappedBy = "volunteer")
	private List<Task>tasks = new ArrayList<>();
	
	@Embedded
	private Account account;
	
	private static DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);


	public Volunteer(String name, Address address) {
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}


	public Address getAddress() {
		return address;
	}

	public List<Task> getTasks() {
		return Collections.unmodifiableList(tasks);
	}
	public void addTask(Task task){
		task.setVolunteer(this);
		tasks.add(task);
	}
	public void removeTask(Task task){
		task.setVolunteer(this);
		this.tasks.remove(task);
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

	public int getVolunteerId() {
		return volunteerId;
	}

	public void setVolunteerId(int volunteerId) {
		this.volunteerId = volunteerId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Volunteer [volunteerId=" + volunteerId + ", name=" + name + ", address=" + address + ", account="
				+ account + "]";
	}

	
	
}
