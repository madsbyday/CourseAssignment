package rest;

import Facade.facadeImpl;
import Facade.facadeInterface;
import converter.JSONConverter;
import entity.Address;
import entity.Hobby;
import entity.Person;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import static io.restassured.RestAssured.given;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javax.persistence.Persistence;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alexander
 */
public class PersonRestIntegrationTest {

    public PersonRestIntegrationTest() {
    }

    private facadeInterface f = new facadeImpl(Persistence.createEntityManagerFactory("CAPU"));

    @BeforeClass
    public static void setUpClass() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/CA1/";
        RestAssured.defaultParser = Parser.JSON;
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testServerIsRunning() {
        System.out.println("serverIsRunning");

        given().
                when().get().
                then().statusCode(200);
    }

    @Test
    public void testCreatePerson() {
        System.out.println("createPerson");
        //Making a new person
        Address a = new Address("Test", "Test street", null); // null er CityInfo
        Person postedPerson = new Person("Sofia", "Petersen", "Sofia@gmail.com", a);
        Person newPerson = given()
                .contentType(ContentType.JSON)
                .body(postedPerson)
                .when().post("/api/person")
                .as(Person.class);

        assertNotNull(newPerson.getId());
    }
/*
    @Test
    public void testGetPersonId() {
        System.out.println("getPersonId");

        //Making a new person
        Address a = new Address("Test", "Test Street", null); // CityInfo er null
        Person postedPerson = new Person("William", "Thomsen", "William@gmail.com", a);
        Person newPerson = given()
                .contentType(ContentType.JSON)
                .body(postedPerson)
                .when().post("/api/person")
                .as(Person.class);

        //See if we can get him
        Person gottenPerson = given()
                .contentType(ContentType.JSON)
                .when().get("/api/person/complete/" + newPerson.getId()).as(Person.class);

        assertNotNull(gottenPerson.getId());
        assertEquals("William", gottenPerson.getFirstName());

    }
*/
    @Test
    public void testDeletePerson() {
        System.out.println("deletePerson");
        //Making a new person
        Address a = new Address("Test", "Test Street", null); // null er CityInfo
        Person postedPerson = new Person("Anna", "Rasmussen", "Anna@gmail.com", a);
        Person newPerson = given()
                .contentType(ContentType.JSON)
                .body(postedPerson)
                .when().post("/api/person")
                .as(Person.class);

        //Deleting the person
        Person deletedPerson = given()
                .contentType(ContentType.JSON)
                .when().delete("/api/person/" + newPerson.getId()).as(Person.class);
        assertNull(deletedPerson);
    }
/*
    @Test
    public void testGetpersons() {
        System.out.println("getpersons");
        PersonRest instance = new PersonRest();
        String expResult = "";
        String result = instance.getpersons();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testEditPerson() {
        System.out.println("editPerson");
        String content = "";
        Long id = null;
        PersonRest instance = new PersonRest();
        String expResult = "";
        String result = instance.editPerson(content, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
}
