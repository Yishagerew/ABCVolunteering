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


	@Override
	public String toString() {
		return "Account [email=" + email + ", password=" + password + ", type=" + type + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	
	
}
