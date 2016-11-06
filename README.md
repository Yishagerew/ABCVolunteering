# ABCVolunteering

This is a very simple project which make uses of hibernate. It has 3 main packages
 - edu.mum.abcVolunteering.model - contains model classes
 - edu.mum.abcVolunteering.dao - Data access object - practically an entity manager object access point
 - edu.mum.abcVolunteering.business - DAO implementations


resources folder:
 - Contains the persistence.xml file
 - Images file
 		- ER model 
 		- Images used in the application

under src/test/java

edu.mum.abcVolunteering.ProjectTest - contains all test cases

Note: User authentication is not done as I was just working on functionalities.
I put 2 user levels - administrator and the other a volunteer.
It could easily be set if it is a real application.

Main operations:

 - Volunteers can offer their services for tasks on projects.
 - ability to see information about projects and their beneficiaries
 - ability to List tasks for a project
 - ability List projects by status
 - ability to Look for projects that requires a particular type of resource/skill
 - ability to Search projects by keywords and location
 - ability List projects and tasks where a volunteer have offered services, ordered by time of the task.




