/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

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
public class GeneratorTest {
    
    public GeneratorTest() {
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
    public void testGeneratePersons() {
        System.out.println("generatePersons");
        int idBegin = 1;
        int amount = 20;
        Generator instance = new Generator();
        String result = instance.generatePersons(idBegin, amount);
        System.out.println(result);
        assertTrue(true);
    }


    @Test
    public void testGenerateCompany() {
        System.out.println("generateCompany");
        int idBegin = 30;
        int amount = 20;
        Generator instance = new Generator();
        String result = instance.generateCompany(idBegin, amount);
        System.out.println(result);    
        assertTrue(true);
    }
    
}
