package edu.mum.abcVolunteering.model;


import javax.persistence.Embeddable;


@Embeddable
public class Account {

	private String email;
	private String password;
	private AccountType type;

	public Account(String email, String password, AccountType type) {
		this.email = email;
		this.password = password;
		this.type = type;
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

	public Account(){
		
	}
	
	
}
