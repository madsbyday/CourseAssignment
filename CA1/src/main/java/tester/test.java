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
        
        puproperties.remove("javax.persistence.sql-load-script-source");
        Persistence.generateSchema("CAPU", puproperties);
        
        Generate g = new Generate();
        g.addPersonToDatabase();
        g.addPersonToDatabase();
        
    }
    
}
