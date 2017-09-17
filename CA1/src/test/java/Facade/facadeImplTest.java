/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Address;
import entity.CityInfo;
import entity.Company;
import entity.Hobby;
import entity.Person;
import entity.Phone;
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
import tester.test;

/**
 *
 * @author Sanox
 */
public class facadeImplTest {

    private  facadeInterface f = new facadeImpl();
    
    public facadeImplTest() {
        
        f.addEntityManagerFactory(Persistence.createEntityManagerFactory("CAPU"));
        
    }

    @BeforeClass
    public static void setUpClass() {
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
        p.setId(200L);
        p.setFirstName("addTest");
        p.setLastName("testLastName");
        p.setEmail("testEmail");
        f.addPerson(p);

        Person exp = f.getPerson(200L);

        assertEquals(exp.getFirstName(), p.getFirstName());
    }

    @Test(expected = NullPointerException.class)
    public void testAddAndDeletePerson() {
        Person p = new Person();
        p.setId(201L);
        p.setFirstName("addTest");
        p.setLastName("testLastName");
        p.setEmail("testEmail");
        f.addPerson(p);
        f.getPerson(201L);         // Confirm that we do get it before Delete
        f.deletePerson(201L);
        Person exp = f.getPerson(201L);
        assertEquals(exp.getFirstName(), p.getFirstName()); //Exception Triggers
    }

    @Test
    public void testEditPerson() {
        Person p1 = f.getPerson(201L);

        Person edit = f.getPerson(201L);
        edit.setFirstName("EditName");
        f.editPerson(edit);             //Acutal Edit

        Person p2 = f.getPerson(201L);

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
        p.setId(400L);
        p.setFirstName("addTest");
        p.setLastName("testLastName");
        p.setEmail("testEmail");
        f.addPerson(p);
        // now there is 2 in the list
        persons = f.getPersons();
        assertTrue(persons.size() == 2);
    }

}
