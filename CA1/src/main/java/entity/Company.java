/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author vfgya_000
 */
@Entity
public class Company extends InfoEntity implements Serializable {

    public Company(String name, String description, int numEmployees, double marketValue, String email)
    {
        super(email);
        this.name = name;
        this.description = description;
        this.numEmployees = numEmployees;
        this.marketValue = marketValue;
    }

    public Company()
    {
        
    }
    
    
    
    
    private String name;
    
    private String description;
    
    private String cvr;
    
    private int numEmployees;
    
    private double marketValue;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCvr() {
        return cvr;
    }

    public void setCvr(String cvr) {
        this.cvr = cvr;
    }

    public int getNumEmployees() {
        return numEmployees;
    }

    public void setNumEmployees(int numEmployees) {
        this.numEmployees = numEmployees;
    }

    public double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(double marketValue) {
        this.marketValue = marketValue;
    }

    
}
