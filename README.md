# ABCVolunteering

This is a very simple project which make uses of hibernate. It has 3 main packages

#Main packages
 - edu.mum.abcVolunteering.model - contains model classes
 - edu.mum.abcVolunteering.dao - Data access object - practically an entity manager object access point
 - edu.mum.abcVolunteering.business - DAO implementations


# resources folder, ER model and images
 - Contains the persistence.xml file
 - Images file
 		- ER model 
 		- Images used in the application

#Testing the app

under src/test/java

 - edu.mum.abcVolunteering.ProjectTest - contains all test cases of required operations
 - edu.mum.abcVolunteering.StaffTest - contains test cases for staff CRUD operation
 
#Authentication

User authentication is not done as I was just working on functionalities. It really needs more console to mimic.
I put 2 user levels - administrator and the other a volunteer in the design however.


# Main operations

 - Volunteers can offer their services for tasks on projects.
 - ability to see information about projects and their beneficiaries
 - ability to List tasks for a project
 - ability List projects by status
 - ability to Look for projects that requires a particular type of resource/skill
 - ability to Search projects by keywords and location
 - ability List projects and tasks where a volunteer have offered services, ordered by time of the task. 




