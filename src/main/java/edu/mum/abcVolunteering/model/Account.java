package edu.mum.abcVolunteering.model;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class Account {

	private String email;
	private String password;
	private AccountType type;
	
	@Temporal(TemporalType.DATE)
	private Date dateRegistered;

	public Account(String email, String password, AccountType type, Date dateRegistered) {
		super();
		this.email = email;
		this.password = password;
		this.type = type;
		this.dateRegistered = dateRegistered;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

	public Date getDateRegistered() {
		return dateRegistered;
	}

	public void setDateRegistered(Date dateRegistered) {
		this.dateRegistered = dateRegistered;
	}
	
	
	
	
}
