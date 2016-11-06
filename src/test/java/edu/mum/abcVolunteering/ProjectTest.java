package edu.mum.abcVolunteering;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import edu.mum.abcVolunteering.model.Address;
import edu.mum.abcVolunteering.model.Beneficiary;
import edu.mum.abcVolunteering.model.CompletionStatus;
import edu.mum.abcVolunteering.model.Project;
import edu.mum.abcVolunteering.model.Skill;
import edu.mum.abcVolunteering.model.Task;
import edu.mum.abcVolunteering.model.Volunteer;


public class ProjectTest {

//	@Before
//	public void setUp() throws Exception {
//		
//		
//		
//	}

	@Test
	public void testAddNewProjectInfo() {
		//create image1
		
		InputStream targetStream = null;
		try{
			
		 targetStream = new FileInputStream(new File("G:\\MUMCourses\\Enterprise architecture\\lab\\solutions\\assignment2\\exercise02-1\\exercise02-1\\target\\classes\\images\\avator.jpg"));
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		InputStream targetStream2 = null;
		try{
			
		 targetStream2 = new FileInputStream(new File("G:\\MUMCourses\\Enterprise architecture\\lab\\solutions\\assignment2\\exercise02-1\\exercise02-1\\target\\classes\\images\\avator.jpg"));
		}
		catch(Exception e){
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
		
		List<Skill> requirdSkillForTask2 = new  ArrayList<>();
		requirdSkillForTask2.add(skill3);
		
		List<Skill> requiredSkillForTask3 = new ArrayList<>();
		
		Task task1 = new Task(CompletionStatus.NOTSTARTED, "11/10/2016", "11/30/2016", requiredSkillForTask1);
		Task task2 = new Task(CompletionStatus.NOTSTARTED, "11/06/2016", "11/30/2016", requiredSkillForTask1);
		Task task3 = new Task(CompletionStatus.ONGOING, "11/06/2016", "11/30/2016", requiredSkillForTask3);
		
		Volunteer volunteer1 = new Volunteer("yishagerew", "11/01/2016", address1);
		Volunteer volunteer2 = new Volunteer("James", "11/01/2016", address2);
		
		task1.setVolunteer(volunteer1);
		task2.setVolunteer(volunteer1);
		task3.setVolunteer(volunteer2);
		
		List<Task> listOfTasks1 = new ArrayList<>();
		listOfTasks1.add(task1);
		listOfTasks1.add(task2);
		
		List<Task> listOfTask2 = new ArrayList<>();
		listOfTask2.add(task3);
		
		Project project1 = new Project(address1, "PHP and javascript", "11/06/2016", "04/10/2017",CompletionStatus.ONGOING,listOfTasks1);
		Project project2 = new Project(address2, "java and framework", "11/06/2016", "04/10/2017", CompletionStatus.ONGOING, listOfTask2);
		
		Beneficiary google = new Beneficiary("Google", profilePhoto1, "11/02/2016");
		google.getProjects().add(project1);
		Beneficiary yahoo = new Beneficiary("Yahoo", profilePhoto2, "11/02/2016");
		yahoo.getProjects().add(project2);
		
		
		
		
	}

	@Test
	public void testDeleteProjectInfo() {
		// TODO
	}

	@Test
	public void testFindProjectById() {
		// TODO
	}

	@Test
	public void testGetAllProjectsInfo() {
		// TODO
	}

	@Test
	public void testFindProjectsByStatus() {
		// TODO
	}

	@Test
	public void testFindProjectsByKeywordAndCity() {
		// TODO
	}

	@Test
	public void testFindProjectsByRequiredSkill() {
		// TODO
	}

	@Test
	public void testFindTasksByProjectIs() {
		// TODO
	}

	@Test
	public void testFindProjectsByVolunteerId() {
		// TODO
	}

}
