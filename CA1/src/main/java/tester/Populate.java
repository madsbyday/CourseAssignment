/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import entity.Hobby;
import entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author vfgya
 */
public class Populate
{

    public static void main(String[] args)
    {

        Person p1 = new Person("Lone", "Lassen", "LL@mail.com");

        EntityManagerFactory emfn = Persistence.createEntityManagerFactory("CAPU");
        EntityManager em = emfn.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(p1);
            em.getTransaction().commit();
        } finally {
            em.close();
       }
     
    }
}
