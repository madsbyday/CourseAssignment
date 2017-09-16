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
  
        g.addPersonToDatabase(); // This function makes 1 person
        g.addCompanyToDatabase(); // This function makes 1 company
        
        g.addHobbiesToDatabase(); // This function makes 50 hobbies

    }
    
}
