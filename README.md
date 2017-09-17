# CourseAssignment 1
By Alexander Nielsen, Jonas El Sabban, Mads Køster Andersen

DAT - Groupe 4

[Link to our website](http://207.154.229.78:8080/CA1-1.0-SNAPSHOT/ "CA1") 
---

### Testing our project
* Click the link to our website and try to use our features. You should be able to create person and then get get them again.
* Download this project as a zip file. Then in Netbeans click on 'file' --> 'Import Project' --> 'From ZIP'. 
* In the Package tester is a java file called test.java, run that file to clean the database and generate a bunch of new data.
* Click 'Clean & Build' to run all of our tests.


Clean and Build will run our tests and if it says "BUILD SUCCESS" in the output. Then our tests where a success.

We only have one plain Unit Test which test which is the makeCompanyEmail method in the Generate.java class. It test that the email for a company can't have illigal symbols; ' & ', '!', '...' and so on. 

Our rest assured tests:
* testServerIsRunning: which test the connection.
* testCreatePerson: which test if we can make a person.
* testGetPerson: First we make a new person so we have an id. Then we see if we can get the person.
* testDeletePerson: First we create a new person so we again have a new id. Then we delete the person. 

All of our test should pass. 

### Rest API
We have in our project used the rest-api to operate on our database via our facade.
We have made various methods which uses the get method to produce json objects which we print out on our html sites.

- **getPersonId:** gets an id from a parameter and uses it to produce a json object with a person and all of his/hers information.

- **getpersons:** works almost the same as the previous method only this produces all of the persons in the database.

- **getpersonsByCity:** returns some persons with a given zipcode which it gets from a parameter.

- **getPersonInfoId:** returns a person’s contact information with a given person id from a parameter.

- **getpersonsInfo:** does the same thing as the previous but returns all persons contact information with no given id.

Here we use the post method which is used for creation of objects.
- **createPerson:** consumes and produces a json object with some data and adds a new person to the database with said data.

The put method is used here to update our database.
- **editPerson:** consumes and produces a json object with some data and updates a person with the given id to the database with said data.

And at last the delete method which we use to remove from the database.
- **deletePerson:** deletes a person with a given id which it gets from a parameter.


### Who have done what
| Class               | Alexander | Jonas | Mads |
| --------------------|:---------:|:-----:|:----:|
| demo.html           |           |   X   |   X  |
| index.html          |           |   X   |      |
| js_script           |           |   X   |   X  |
|styleSheet.css       |           |       |   X  |
|facadeImpl.java      |     X     |   X   |   X  |
|facadeInterface.java |     X     |   X   |   X  |
|JSONConverter.java   |           |       |   X  |
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


