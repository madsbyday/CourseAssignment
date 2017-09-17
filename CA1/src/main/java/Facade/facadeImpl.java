package Facade;

import entity.Address;
import entity.CityInfo;
import entity.Company;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class facadeImpl implements facadeInterface {

    EntityManagerFactory emf;

    public facadeImpl() {
    }

    ;

    @Override
    public void addEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public Person getPerson(Long id) {
        EntityManager em = emf.createEntityManager();

        Person p;

        try {
            p = em.find(Person.class, id);
        } finally {
            em.close();
        }

        return p;
    }

    @Override
    public Person getPerson2(Person p) {
        EntityManager em = emf.createEntityManager();

        Person person;

        try {
            em.getTransaction().begin();
            person = em.find(Person.class, p.getId());
            if (person != null) {
                person = p;
            }
        } finally {
            em.close();
        }

        return person;
    }

    @Override
    public List<Person> getPersons() {
        EntityManager em = emf.createEntityManager();

        List<Person> persons;

        try {
            persons = em.createQuery("SELECT p FROM Person p").getResultList();
        } finally {
            em.close();
        }

        return persons;
    }

    @Override
    public Person addPerson(Person person) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        return person;
    }

    @Override
    public Person editPerson(Person person) {
        EntityManager em = emf.createEntityManager();

        Person p;

        try {
            em.getTransaction().begin();
            p = em.find(Person.class, person.getId());
            if (p != null) {
                p = person;
                em.merge(p);
                em.getTransaction().commit();
            }
        } finally {
            em.close();
        }

        return p;
    }

    @Override
    public Person deletePerson(Long id) {
        EntityManager em = emf.createEntityManager();

        Person p;

        try {
            em.getTransaction().begin();
            p = em.find(Person.class, id);
            em.remove(p);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        return p;
    }

    @Override
    public Company getCompany(Long id) {
        EntityManager em = emf.createEntityManager();

        Company c;

        try {
            c = em.find(Company.class, id);
        } finally {
            em.close();
        }

        return c;
    }

    @Override
    public Company getCompany2(Company company) {
        EntityManager em = emf.createEntityManager();

        Company c;

        try {
            em.getTransaction().begin();
            c = em.find(Company.class, company.getId());
            if (c != null) {
                c = company;
            }
        } finally {
            em.close();
        }

        return c;
    }

    @Override
    public List<Company> getCompanies() {
        EntityManager em = emf.createEntityManager();

        List<Company> companies;

        try {
            companies = em.createQuery("SELECT c FROM Company c").getResultList();
        } finally {
            em.close();
        }

        return companies;
    }

    @Override
    public Company addCompany(Company company) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(company);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        return company;
    }

    @Override
    public Company deleteCompany(Long id) {
        EntityManager em = emf.createEntityManager();

        Company c;

        try {
            em.getTransaction().begin();
            c = em.find(Company.class, id);
            em.remove(c);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        return c;

    }

    @Override
    public Company editCompany(Company company) {
        EntityManager em = emf.createEntityManager();

        Company c;

        try {
            em.getTransaction().begin();
            c = em.find(Company.class, company.getId());
            if (c != null) {
                c = company;
                em.merge(c);
                em.getTransaction().commit();
            }
        } finally {
            em.close();
        }

        return c;

    }

    @Override
    public Address addAddress(Address a) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        return a;
    }

    @Override
    public Phone addPhone(Phone p) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } finally {
            em.close();

      @Override
        public List<Phone> getPhonesByPerson(long id) {
        EntityManager em = emf.createEntityManager();
        
        List<Phone> phones = null;
        
        Query query = null;
        
        try {
            em.getTransaction().begin();
            
            query = em.createQuery("SELECT p FROM Phone p WHERE p.infoEntity.id = " + id);
            phones = (List<Phone>)query.getResultList();
            
            return phones;


        }

        return p;
    }

    @Override
    public CityInfo getCityInfo(Long id) {
        EntityManager em = emf.createEntityManager();

        CityInfo ci;

        try {
            ci = em.find(CityInfo.class, id);
        } finally {
            em.close();
        }

        return ci;
    }

    @Override
    public Hobby addHobby(Hobby h) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(h);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        return h;
    }

}
