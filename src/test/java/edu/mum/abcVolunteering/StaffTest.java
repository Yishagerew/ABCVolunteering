package edu.mum.abcVolunteering;

import org.junit.BeforeClass;
import org.junit.Test;

import edu.mum.abcVolunteering.business.StaffImpl;
import edu.mum.abcVolunteering.model.Account;
import edu.mum.abcVolunteering.model.AccountType;
import edu.mum.abcVolunteering.model.Address;
import edu.mum.abcVolunteering.model.Staff;
import org.junit.Assert;

public class StaffTest {
	static Staff staff;
	@BeforeClass
	public static void setUp() throws Exception {
		Staff staffNew = new Staff("Yishagerew", "ylulie4", "1234");
		Address address = new Address("Fairfield", "Iowa", 52557);
		Account account = new Account("ylulie4@gmail.com", "12345", AccountType.ADMINISTRATOR);
		staffNew.setAddress(address);
		staffNew.setAccount(account);
		
		//test operation  - add
		Assert.assertEquals("Staff info not inserted", StaffImpl.addNewStaffInfo(staffNew), 1);
		
		//test operation - find
		Assert.assertEquals("Staff info not inserted", StaffImpl.findStaffByUserName("ylulie4@gmail.com"), staffNew);
		
		//test operation - update
		Address addressnew = new Address("Washington", "Iowa", 13542);
		staffNew.setAddress(addressnew);
		Assert.assertEquals("Staff info is not updated", StaffImpl.updateStaffInfo(staffNew), 1);
		staff = staffNew;
	}
	
	@Test
	public void testDeleteStaffInfo() {
		Assert.assertEquals("Staff info is not deleted", StaffImpl.updateStaffInfo(staff), 1);
	}

}
