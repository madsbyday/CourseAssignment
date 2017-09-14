/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonmapper;

import Facade.facadeImpl;
import Facade.facadeInterface;
import entity.Hobby;
import entity.Person;
import java.util.List;

/**
 *
 * @author vfgya
 */
public class PersonWhole
{
    
    private String firstName;

    private String lastName;
    
    private String mail;
    
    private String street;
    
    private String ai;
    
    private List<Hobby> hobbies;


    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getMail()
    {
        return mail;
    }

    public void setMail(String mail)
    {
        this.mail = mail;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getAi()
    {
        return ai;
    }

    public void setAi(String ai)
    {
        this.ai = ai;
    }

    public List<Hobby> getHobbies()
    {
        return hobbies;
    }

    public void setHobbies(List<Hobby> hobbies)
    {
        this.hobbies = hobbies;
    }

    
    
    
}
