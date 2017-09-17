# CourseAssignment 1
By Alexander Nielsen, Jonas El Sabban, Mads Køster Andersen

DAT - Groupe 4

[Link to our website](http://207.154.229.78:8080/ "CA1") 

---
### Testing our project
* Click the link to our website and try to use our features. You should be able to create person and then get get them again.
* Download this project as a zip file. Then in Netbeans click on 'file' --> 'Import Project' --> 'From ZIP'. 
* Click 'Clean & Build' to run all of our tests.
* In the Package tester is a java file called test.java, run that file to generate a bunch of new data for the database. 

Clean and Build will run our tests and if it says "BUILD SUCCESS" in the output. Then our tests where a success.

We only have one plain Unit Test which test which is the makeCompanyEmail method in the Generate.java class. It test that the email for a company can't have illigal symbols; ' & ', '!', '...' and so on. 

(FACADE TESTS - JONAS)

Our rest assured tests:
* testServerIsRunning: which test the connection.
* testCreatePerson: which test if we can make a person.
* testGetPerson: First we make a new person so we have an id. Then we see if we can get the person.
* testDeletePerson: First we create a new person so we again have a new id. Then we delete the person. 

All of our test should pass. 

### Who have done what
| Class               | Alexander | Jonas | Mads |
| --------------------|:---------:|:-----:|:----:|
| demo.html           |           |   X   |   X  |
| index.html          |           |   X   |      |
| js_script           |           |   X   |   X  |
|facadeImpl.java      |     X     |   X   |   X  |
|facadeInterface.java |     X     |   X   |   X  |
|Address.java         |     X     |       |      |
|CityInfo.java        |     X     |       |      |
|Company.java         |           |       |   X  |
|Hobby.java           |           |       |   X  |
|InfoEntity.java      |           |       |   X  |
|Person.java          |           |       |   X  |
|Phone.java           |     X     |       |      |
|PersonWhole.java     |           |       |   X  |
|Generate.java        |     X     |       |      |
|Populate.java        |           |       |   X  |
|test.java            |     X     |       |      |
|CompanyRestIT.java   |           |       |      |
|PersonRestIT.java    |     X     |       |      |
|GenerateTest.java    |     X     |       |      |


