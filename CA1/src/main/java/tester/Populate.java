/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import entity.Person;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author vfgya
 */
public class Populate
{
    
    public static void main(String[] args)
    {
        
        Person p = new Person(null,"Hans", "Andersen", "HA@mail.com");
        
        EntityManagerFactory emfn = Persistence.createEntityManagerFactory("CAPU");
        EntityManager em = emfn.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
}
