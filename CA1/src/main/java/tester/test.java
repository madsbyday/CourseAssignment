/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import java.util.HashMap;
import javax.persistence.Persistence;

/**
 *
 * @author vfgya_000
 */
public class test {

    public static void main(String[] args) {
        HashMap puproperties = new HashMap();

        puproperties.put("javax.persistence.sql-load-script-source", "scripts/initdb.sql");
        Persistence.generateSchema("CAPU", puproperties);
        
        puproperties.put("javax.persistence.sql-load-script-source", "scripts/populate.sql");
        Persistence.generateSchema("CAPU", puproperties);
        
        Generate g = new Generate();
  
        g.addHobbiesToDatabase(); // This function makes 50 hobbies
        
        // Change depending for how many person and companys you want to generate
        int numberToGenerate = 20;
        for (int i = 0; i < numberToGenerate; i++) {
        g.addPersonToDatabase(); // This function makes 1 person
        }
        for (int i = 0; 9 < numberToGenerate; i++) {
            g.addCompanyToDatabase(); // This function makes 1 company
        }
    }
    
}
