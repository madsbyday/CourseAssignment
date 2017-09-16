/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author vfgya_000
 */
@Entity
public class Person extends InfoEntity implements Serializable {

    public Person(String firstName, String lastName, String email, Address address)
    {
        super(email, address);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person()
    {
        
    }
    
    @ManyToMany(mappedBy = "persons")
    private List<Hobby> hobbys;
    
    private String firstName;
    
    private String lastName;


    public List<Hobby> getHobbys() {
        return hobbys;
    }

    public void setHobbys(List<Hobby> hobbys) {
        this.hobbys = hobbys;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    

    @Override
    public String toString()
    {
        return "Person{" + "hobbys=" + hobbys + ", firstName=" + firstName + ", lastName=" + lastName + '}';
    }
    
    
    
}
