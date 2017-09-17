/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.parsing.Parser;
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
public class CompanyRestIntegrationTest {

    public CompanyRestIntegrationTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/CA1";
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
    
    /*
    @Test
    public void testGetJson() {
        System.out.println("getJson");
        CompanyRest instance = new CompanyRest();
        String expResult = "";
        String result = instance.getJson();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testPutJson() {
        System.out.println("putJson");
        String content = "";
        CompanyRest instance = new CompanyRest();
        instance.putJson(content);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
     */
}
