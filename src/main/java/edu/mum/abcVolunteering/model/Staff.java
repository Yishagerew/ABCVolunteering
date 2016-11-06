package edu.mum.abcVolunteering.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class Staff {
	
	@Id
	@GeneratedValue
	private int staffId;
	private String name;
	
	@Embedded
	private Address address;
	@Embedded
	private Account account;
	
	public Staff(String name, String email, String password) {
		this.name = name;
		account.setType(AccountType.ADMINISTRATOR);
		account.setEmail(email);
		account.setPassword(password);
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}	
	
}
