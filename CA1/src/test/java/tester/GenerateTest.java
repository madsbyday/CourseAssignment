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
public class GenerateTest {
    
    public GenerateTest() {
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
    public void testMakeCompanyEmail() {
        System.out.println("makeCompanyEmail");
        String gen1 = "test";
        String gen2 = " & ";
        String gen3 = "mail";
        Generate instance = new Generate();
        String expResult = "info@testmail.dk";
        String result = instance.makeCompanyEmail(gen1, gen2, gen3);
        assertEquals(expResult, result);
    }
    
}
