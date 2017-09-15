package rest;

import converter.JSONConverter;
import entity.Hobby;
import entity.Person;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import static io.restassured.RestAssured.given;
import java.util.List;
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
        List<Hobby> hobbys = null;
        Person postedPerson = new Person("Sofia", "Petersen", "Sofia@gmail.com");
        Person newPerson = given()
                        .contentType(ContentType.JSON)
                        .body(postedPerson)
                        .when().post("/api/person")
                        .as(Person.class);
        
        assertNotNull(newPerson.getId());
    }

    @Test
    public void testGetPersonId() {
        System.out.println("getPersonId");
        
        //Making a new person
        List<Hobby> hobbys = null;
        Person postedPerson = new Person("William", "Thomsen", "William@gmail.com");
        String js = JSONConverter.getJSONFromPerson(postedPerson);
        Person newPerson = given()
                        .contentType(ContentType.JSON)
                        .body(js)
                        .when().post("/api/person")
                        .as(Person.class);
        
        //See if we can get him
        Person gottenPerson = given()
                .contentType(ContentType.JSON)
                .body(js)
                .when().get("/api/person/complete/" + newPerson.getId()).as(Person.class); 
        
        assertNotNull(gottenPerson.getId());
        assertEquals("William", gottenPerson.getFirstName());

    }
    /*
    @Test
    public void testDeletePerson() {
        System.out.println("deletePerson");
        //Making a new person
        List<Hobby> hobbys = null;
        Person postedPerson = new Person(hobbys, "Anna", "Rasmussen", "Anna@gmail.com");
        Person newPerson = given()
                        .contentType(ContentType.JSON)
                        .body(postedPerson)
                        .when().post("/api/person")
                        .as(Person.class);
        
        //Deleting the person
        Person deletedPerson = given()
        .contentType(ContentType.JSON)
        .when().delete("/api/person/" + newPerson.getId()).as(Person.class);
        assertEquals("Anna", deletedPerson.getFirstName());
    }
*/
}
