/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Company;
import entity.Person;
import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FacadeTest {

    private facadeInterface f = new facadeImpl(Persistence.createEntityManagerFactory("TESTCAPU"));

    public FacadeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        Persistence.generateSchema("TESTCAPU", new HashMap());
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
    public void testGetPersonFromID() {

        Person p = f.getPerson(1L);
        Person exp = new Person();
        exp.setFirstName("testname");
        exp.setLastName("testlastname");
        exp.setEmail("test@Email.fake");

        assertEquals(p.getFirstName(), exp.getFirstName());
        assertEquals(p.getLastName(), exp.getLastName());
        assertEquals(p.getEmail(), exp.getEmail());
    }

    @Test
    public void testAddPersonAndGetPersonBack() {
        Person p = new Person();
        p.setId(2L);
        p.setFirstName("addTest");
        p.setLastName("testLastName");
        p.setEmail("testEmail");
        f.addPerson(p);

        Person exp = f.getPerson(2L);

        assertEquals(exp.getFirstName(), p.getFirstName());
    }

    @Test(expected = NullPointerException.class)
    public void testAddAndDeletePerson() {
        Person p = new Person();
        p.setId(3L);
        p.setFirstName("addTest");
        p.setLastName("testLastName");
        p.setEmail("testEmail");
        f.addPerson(p);
        f.getPerson(3L);         // Confirm that we do get it before Delete
        f.deletePerson(3L);
        Person exp = f.getPerson(3L);
        assertEquals(exp.getFirstName(), p.getFirstName()); //Exception Triggers
    }

    @Test
    public void testEditPerson() {
        Person p1 = f.getPerson(1L);

        Person edit = f.getPerson(1L);
        edit.setFirstName("EditName");
        f.editPerson(edit);             //Acutal Edit

        Person p2 = f.getPerson(1L);

        String before = p1.getFirstName();
        String after = p2.getFirstName();

        assertNotEquals(before, after);

    }

    @Test
    public void testGetPersonsAndAddToList() {

        List<Person> persons = f.getPersons();
        // there is only 1 person in the list
        assertTrue(persons.size() == 1);
        Person p = new Person();
        p.setId(4L);
        p.setFirstName("addTest");
        p.setLastName("testLastName");
        p.setEmail("testEmail");
        f.addPerson(p);
        // now there is 2 in the list
        persons = f.getPersons();
        assertTrue(persons.size() == 2);
    }

    @Test
    public void testAddCompany() {

    }

    @Test
    public void testDeleteCompany() {

    }

    @Test
    public void testGetCompany() {

    }

    @Test
    public void testGetCompanies() {

    }

    @Test
    public void testEditCompany() {

    }

}
