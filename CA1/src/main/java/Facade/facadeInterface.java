/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author vfgya_000
 */
public interface facadeInterface {
    public void addEntityManagerFactory(EntityManagerFactory emf);

    public EntityManager getEntityManager();
    public Person addPerson(Person p);
    public Person deletePerson(Long id);
    public Person getPerson(Long id);
    public Person getPerson2(Person p);
    public List<Person> getPersons();
    public Person editPerson(Person p);

    public Company addCompany(Company company);
    public Company deleteCompany(Long id);
    public Company getCompany(Long id);
    public Company getCompany2(Company company);
    public List<Company> getCompanies();
    public Company editCompany(Company company);

    public Address addAddress(Address a);
    public Phone addPhone(Phone p);
    
    public CityInfo getCityInfo(Long id);
    
    public Hobby addHobby(Hobby h);
}
