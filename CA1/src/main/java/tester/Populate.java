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

        Person p = new Person("Hans", "Andersen", "HA@mail.com");

        EntityManagerFactory emfn = Persistence.createEntityManagerFactory("CAPU");
        EntityManager em = emfn.createEntityManager();

//        try {
//            em.getTransaction().begin();
//            em.persist(p);
//            em.getTransaction().commit();
//        } finally {
//            em.close();
//        }
        List<Hobby> hobbies = null;

        Query query = null;

        try
        {
            em.getTransaction().begin();

            query = em.createQuery("SELECT h FROM Hobby h inner join h.persons person WHERE person.id = " + 1);

            hobbies = (List<Hobby>) query.getResultList();

            for (int i = 0; i < hobbies.size(); i++)
            {
                System.out.println(hobbies.get(i).getName());
            }
        } finally
        {
            em.close();
        }

    }

}
