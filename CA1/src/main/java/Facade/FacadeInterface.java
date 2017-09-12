package Facade;

import entity.Company;
import entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public interface FacadeInterface {

    public void addEntityManagerFactory(EntityManagerFactory emf);

    public EntityManager getEntityManager();
    public Person addPerson(Person p);
    public Person deletePerson(Long id);
    public Person getPerson(Long id);
    public List<Person> getPersons();
    public Person editPerson(Person p);

    public Company addCompany(Company company);
    public Company deleteCompany(Long id);
    public Company getCompany(Long id);
    public List<Company> getCompanies();
    public Company editCompany(Company company);

}
