package edu.mum.abcVolunteering;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

import edu.mum.abcVolunteering.business.BeneficiaryImpl;
import edu.mum.abcVolunteering.business.ProjectImpl;
import edu.mum.abcVolunteering.business.StaffImpl;
import edu.mum.abcVolunteering.model.Account;
import edu.mum.abcVolunteering.model.AccountType;
import edu.mum.abcVolunteering.model.Address;
import edu.mum.abcVolunteering.model.Beneficiary;
import edu.mum.abcVolunteering.model.CompletionStatus;
import edu.mum.abcVolunteering.model.Project;
import edu.mum.abcVolunteering.model.Skill;
import edu.mum.abcVolunteering.model.Staff;
import edu.mum.abcVolunteering.model.Task;
import edu.mum.abcVolunteering.model.Volunteer;

public class ProjectTest {

	public static Volunteer volunteer;
	public static Project project;
	public static Beneficiary beneficiaryTest;

	@BeforeClass
	public static void setUp() throws Exception {

		InputStream targetStream = null;
		try {

			targetStream = new FileInputStream(
					new File("C:\\Woskspace\\Spring\\ABCVolunteering\\src\\main\\resources\\images\\Google.jpg"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		InputStream targetStream2 = null;
		try {

			targetStream2 = new FileInputStream(
					new File("C:\\Woskspace\\Spring\\ABCVolunteering\\src\\main\\resources\\images\\Yahoo.png"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		byte[] profilePhoto1 = null;
		try {
			profilePhoto1 = IOUtils.toByteArray(targetStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] profilePhoto2 = null;
		try {
			profilePhoto2 = IOUtils.toByteArray(targetStream2);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Address address1 = new Address("San Francesco", "California", 94101);
		Address address2 = new Address("Fairfield", "Iowa", 52557);

		Skill skill1 = new Skill("PHP", "php frameworks, oop part");
		Skill skill2 = new Skill("JavaScript", "javascript, jquery, angular");
		Skill skill3 = new Skill("Java", "SE, J2EE, frameworks");

		List<Skill> requiredSkillForTask1 = new ArrayList<>();
		requiredSkillForTask1.add(skill1);
		requiredSkillForTask1.add(skill2);

		List<Skill> requirdSkillForTask2 = new ArrayList<>();
		requirdSkillForTask2.add(skill3);

		List<Skill> requiredSkillForTask3 = new ArrayList<>();

		Task task1 = new Task(CompletionStatus.ONGOING, "11/10/2016", "11/30/2016", requiredSkillForTask1);
		Task task2 = new Task(CompletionStatus.ONGOING, "11/06/2016", "11/30/2016", requirdSkillForTask2);
		Task task3 = new Task(CompletionStatus.ONGOING, "11/06/2016", "11/30/2016", requiredSkillForTask3);

		Volunteer volunteer1 = new Volunteer("yishagerew", address1);
		Volunteer volunteer2 = new Volunteer("James", address2);

		Account forVolunteer1 = new Account("ylulie4@gmail.com", "12345", AccountType.VOLUNTEER);
		Account forVolunteer2 = new Account("lulie@gmail.com", "12345", AccountType.VOLUNTEER);

		volunteer1.setAccount(forVolunteer1);
		volunteer2.setAccount(forVolunteer2);

		task1.setVolunteer(volunteer1);
		task2.setVolunteer(volunteer1);
		task3.setVolunteer(volunteer2);

		Project project1 = new Project(address1, "PHP and javascript", "11/06/2016", "04/10/2017",
				CompletionStatus.ONGOING);
		Project project2 = new Project(address2, "java and framework", "11/06/2016", "04/10/2017",
				CompletionStatus.ONGOING);

		project1.addTask(task1);
		project1.addTask(task2);
		project2.addTask(task3);

		project = project1;// used for other tests

		Beneficiary google = new Beneficiary("Google", profilePhoto1, "11/02/2016");
		google.addProject(project1);
		Beneficiary yahoo = new Beneficiary("Yahoo", profilePhoto2, "11/02/2016");
		yahoo.addProject(project2);

		beneficiaryTest = google; // used for other tests

		BeneficiaryImpl.addNewBeneficiary(google);
		BeneficiaryImpl.addNewBeneficiary(yahoo);

		System.out.println("Initial setup");
		System.out.println("===================================================");
		System.out.println("========================Beneficiary: ==============");
		System.out.println(google);
		System.out.println("=====================Tasks and volunteers=========");
		google.getProjects().forEach(e -> {

			System.out.println("Tasks under project");
			e.getTasks().forEach(e1 -> {
				System.out.println(e1);
				System.out.println("===================Volunteer under this task=========");
				System.out.println(e1.getVolunteer());
				System.out.println("============Skills required by this task==============");
				e1.getRequiredSkill().forEach(e2 -> System.out.println(e2));
			});
		});
		System.out.println("========================Beneficiary: ==============");
		System.out.println(yahoo);
		yahoo.getProjects().forEach(e -> {

			System.out.println("Tasks under project");
			e.getTasks().forEach(e1 -> {
				System.out.println(e1);
				System.out.println("===================Volunteer under this task=========");
				System.out.println(e1.getVolunteer());
				System.out.println("============Skills required by this task==============");
				e1.getRequiredSkill().forEach(e2 -> System.out.println(e2));
			});
		});

		Staff staff = new Staff("Lulie", "admin@gmail.com", "12345");
		staff.setAddress(address2);
		StaffImpl.addNewStaffInfo(staff);

		System.out.println("=====================Admin info=====================");
		System.out.println(staff);

		volunteer = volunteer1;

		System.out.println(
				"==============================================================================================");
		System.out.println("Test results");
		System.out.println(
				"==============================================================================================");

	}

	@Test
	public void testFindProjectsByStatus() {
		System.out.println("All projects with specific status: ");
		System.out.println("====================================================");
		CompletionStatus status = CompletionStatus.ONGOING;
		List<Project> projects = ProjectImpl.findProjectsByStatus(status);
		projects.forEach(e -> System.out.println(e));

		Assert.assertEquals("All prjects with this status are not retrieved", projects.size(), 2);

		System.out.println("====================================================");

	}

	@Test
	public void testGetAllProjectsInfoByStatus() {
		// TODO
		System.out.println("List of projects grouped by status");
		System.out.println("====================================================");
		List<Project> projects = ProjectImpl.getAllProjectsInfoByStatus();
		projects.forEach(e -> System.out.println(e));
		
		Assert.assertEquals("All projects are just not retrieved", projects.size(), 2);

		
		System.out.println("====================================================");
	}

	@Test
	public void testFindProjectsByKeywordAndCity() {
		// TODO
		System.out.println("List of projects by keyword and city, keyword: framework, city: Fairfield");
		System.out.println("====================================================");
		List<Project> projects = ProjectImpl.findProjectsByKeywordAndCity("%framework%", "Fairfield");
		projects.forEach(e -> System.out.println(e));
	
		
		System.out.println("====================================================");
	}

	@Test
	public void testFindProjectsByRequiredSkill() {
		// TODO
		System.out.println("List of projects by specific skill : PHP");
		System.out.println("====================================================");
		List<Project> projects = ProjectImpl.findProjectsByRequiredSkill("PHP");
		projects.forEach(e -> System.out.println(e));
		System.out.println("====================================================");

	}

	@Test
	public void testFindTasksByProjectIs() {
		System.out.println("List tasks of project 1:");
		System.out.println("====================================================");
		List<Task> tasks = ProjectImpl.findTasksByProject(project.getProjectId());
		tasks.forEach(e -> System.out.println(e));
		System.out.println("====================================================");
	}

	@Test
	public void testFindProjectsByVolunteerId() {
		// TODO
		System.out.println("List of projects a volunteer is participated:");
		System.out.println("====================================================");
		List<Project> projects = ProjectImpl.findProjectsByVolunteerId(volunteer.getVolunteerId());
		projects.forEach(e -> System.out.println(e));
		System.out.println("====================================================");
	}

	@Test
	public void testfindAllBeneficiaries() {
		System.out.println("List of beneficiaries and respective projects:");
		System.out.println("====================================================");
		List<Beneficiary> beneficiaries = BeneficiaryImpl.findAllBeneficiaries();
		beneficiaries.forEach(e -> System.out.println(e));
		System.out.println("====================================================");
	}

}
