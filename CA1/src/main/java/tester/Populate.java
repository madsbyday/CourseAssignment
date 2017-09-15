/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import entity.Address;
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
        
        Address a1 = new Address("Hovedvej 1", "Recidential"); // Mangler CiryInfo
        Person p1 = new Person("Lone", "Lassen", "LL@mail.com", a1);

        EntityManagerFactory emfn = Persistence.createEntityManagerFactory("CAPU");
        EntityManager em = emfn.createEntityManager();

//        try {
//            em.getTransaction().begin();
//            em.persist(p1);
//            em.getTransaction().commit();
//        } finally {
//            em.close();
//       }
//        List<Hobby> hobbies = null;
//
//        Query query = null;
//
//        try
//        {
//            em.getTransaction().begin();
//
//            query = em.createQuery("SELECT h FROM Hobby h inner join h.persons person WHERE person.id = " + 1);
//
//            hobbies = (List<Hobby>) query.getResultList();
//
//            for (int i = 0; i < hobbies.size(); i++)
//            {
//                System.out.println(hobbies.get(i).getName());
//            }
//        } finally
//        {
//            em.close();
//        }

        Person p;

        long id = 1;
        try {
            p = em.find(Person.class, id);
        } finally {
            em.close();
        }

        System.out.println(
        p.toString()
        );
        for (int i = 0; i < p.getHobbys().size(); i++)
        {
            System.out.println(p.getHobbys().get(i).getName());
            System.out.println(p.getHobbys().get(i).getDescription());
        }
    }

}
