package edu.mum.abcVolunteering.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "Staff.findByUserName", query = "select s from Staff s where s.account.email = :email"),
})
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
		account = new Account();
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

	@Override
	public String toString() {
		return "Staff [staffId=" + staffId + ", name=" + name + ", address=" + address + ", account=" + account + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
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
		Staff other = (Staff) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		return true;
	}	
	
	
	
	
	
}
