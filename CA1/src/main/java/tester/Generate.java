/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import Facade.facadeImpl;
import Facade.facadeInterface;
import entity.Address;
import entity.CityInfo;
import entity.Company;
import entity.InfoEntity;
import entity.Person;
import entity.Phone;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javax.persistence.Persistence;

/**
 *
 * @author Alexander
 */
public class Generate {

    private facadeInterface f = new facadeImpl();

    public Generate() {
        f.addEntityManagerFactory(Persistence.createEntityManagerFactory("CAPU"));
    }

    Random rnd = new Random();

    String[] firstNames = {"Sofia", "Alma", "Emma", "Ella", "Ida", "Freja", "Clara", "Anna", "Laura", "Alberte",
        "Noah", "Victor", "Oliver", "Oscar", "William", "Lucas", "Carl", "Malthe", "Emil", "Alfred"};

    String[] lastNames = {"Jensen", "Nielsen", "Hansem", "Pederson", "Andersen", "Christensen", "Larsen",
        "Sørensen", "Rasmussen", "Jørgensen", "Petersen", "Madsen", "Kristensen", "Olsen", "Thomsen",
        "Christiansen", "Poulsen", "Johansen", "Møller", "Mortensen"};

    String[] hobbyDesc = {"Fun", "Hard", "Relaxing", "Social", "Quick", "Long"};
    String[] hobbyName = {"Running", "Wheightlifting", "Cycling", "Yoga", "Boxing", "Danscing", "Painting", "Movies", "Gaming"};

    String[] companyGen1 = {"Ove", "Axo", "Tee", "Lym", "Qaz", "Cem", "IO", "Gid", "Sor", "Wem", "App"};
    String[] companyGen2 = {" ", " & ", "-", "u", "mmm", "e", "ter", "q", "o", "im"};
    String[] companyGen3 = {"...", "!", "ver", "st", " A/S", "web", "$", "zom", "fer", "opp"};

    String[] companyDesc = {"Tech", "Sales", "Food", "Finance", "Legal", "Construcktion", "Cosmetic", "Animals", "Travel", "Entertaintment"};

    String[] streetEnd = {" St.", " Ave.", " Blvd.", " Rd.", " Ln."};
    String[] streetDesc = {"Residential", "Commercial"};

    String[] phoneDesc = {"Mobil", "Home", "Office", "Sale", "Help"};

    public void addPersonToDatabase() {
        String firstName = firstNames[rnd.nextInt(firstNames.length)];
        String lastName = lastNames[rnd.nextInt(firstNames.length)];
        String email = firstName + "@gmail.com";
        String street = (rnd.nextInt(250) + 1) + ". " + lastNames[rnd.nextInt(lastNames.length)] + " " + streetEnd[rnd.nextInt(streetEnd.length)];
        
        
        Address a = new Address(street, streetDesc[0], f.getCityInfo(ThreadLocalRandom.current().nextLong(1354)));
        Person pers = new Person(firstName, lastName, email, f.addAddress(a));
        
        String number = "" + (rnd.nextInt(90000000) + 10000000);
        
        Phone p = new Phone(number, phoneDesc[rnd.nextInt(2)]);
        f.addPhone(p);
        
        f.addPerson(pers);
    }

    public void addCompanyToDatabase() {
        String cvr = "" + (rnd.nextInt(90000) + 10000) + "";
        String gen1 = companyGen1[rnd.nextInt(companyGen1.length)];
        String gen2 = companyGen2[rnd.nextInt(companyGen2.length)];
        String gen3 = companyGen3[rnd.nextInt(companyGen3.length)];
        String name = gen1 + gen2 + gen3;
        String desc = companyDesc[rnd.nextInt(companyDesc.length)];
        int numEmployees = rnd.nextInt(100) + 1;

        String email = makeCompanyEmail(gen1, gen2, gen3);

        String street = (rnd.nextInt(250) + 1) + ". " + lastNames[rnd.nextInt(lastNames.length)] + " " + streetEnd[rnd.nextInt(streetEnd.length)];
        
        Address a = new Address(street, streetDesc[1], f.getCityInfo(ThreadLocalRandom.current().nextLong(1354)));
        Company c = new Company(cvr, name, desc, numEmployees, rnd.nextDouble() * 1000.0, email, f.addAddress(a));
        
        String number = "" + (rnd.nextInt(90000000) + 10000000);

        Phone p = new Phone(number, phoneDesc[rnd.nextInt(3) + 2]);
        f.addPhone(p);
        
        f.addCompany(c);
    }

    public String makeCompanyEmail(String gen1, String gen2, String gen3) {
        String email = "info@" + gen1;
        if (!gen2.equalsIgnoreCase(" ") && !gen2.equalsIgnoreCase(" & ") && !gen2.equalsIgnoreCase("!")) {
            email += gen2;
        }
        if (!gen3.equalsIgnoreCase("...") && !gen3.equalsIgnoreCase("!") && !gen3.equalsIgnoreCase(" A/S") && !gen3.equalsIgnoreCase("$")) {
            email += gen3;
        }
        return email + ".dk";
    }

    /* GENERATE SQL STRING FOR PERSON AND COMPANY 
    ***DOES NOT WORK DUE TO MISMATCH OF ID'S***
    
    public String generatePersons(int idBegin, int amount) {
        String insert;
        String result = "";
        int i = 1;
        while (i <= amount) {
            String firstName = firstNames[rnd.nextInt(firstNames.length)];
            String lastName = lastNames[rnd.nextInt(firstNames.length)];
            String email = firstName + idBegin + "@gmail.com";
            String street = lastNames[rnd.nextInt(lastNames.length)] + " " + streetEnd[rnd.nextInt(streetEnd.length)];

            insert = "INSERT INTO ADDRESS (ID, ADDITIONALINFO, STREET, CITYINFO_ID) VALUES (" + idBegin + ", '" + streetDesc[0] + "', '" + (rnd.nextInt(100) + 1 + " " + street) + "', " + 1 + "); \n"
                    + "INSERT INTO INFOENTITY (ID, DTYPE, EMAIL, ADDRESS_ID) VALUES (" + idBegin + ", 'Person','" + email + "', " + idBegin + "); \n"
                    + "INSERT INTO PERSON (ID, FIRSTNAME, LASTNAME) VALUES (" + idBegin + ",'" + firstName + "','" + lastName + "'); \n";

            int j = 0;
            while (j < rnd.nextInt(2) + 1) {
                int number = rnd.nextInt(90000000) + 10000000;
                insert += "INSERT INTO PHONE (DESCRIPTION, NUMBER, INFOENTITY_ID) VALUE ('" + phoneDesc[rnd.nextInt(phoneDesc.length - 3)] + "', " + number + ", " + idBegin + "); \n";
                j++;
            }
            result += (insert + "\n");

            idBegin++;
            i++;
        }
        return result + "\n";
    }

    public String generateCompany(int idBegin, int amount) {
        String insert;
        String result = "";
        int i = 1;
        while (i <= amount) {
            String cvr = "" + (rnd.nextInt(90000) + 10000) + "";
            String gen1 = companyGen1[rnd.nextInt(companyGen1.length)];
            String gen2 = companyGen2[rnd.nextInt(companyGen2.length)];
            String gen3 = companyGen3[rnd.nextInt(companyGen3.length)];
            String name = gen1 + gen2 + gen3;
            String desc = companyDesc[rnd.nextInt(companyDesc.length)];
            String street = lastNames[rnd.nextInt(lastNames.length)] + " " + streetEnd[rnd.nextInt(streetEnd.length)];
            int numEmployees = rnd.nextInt(100) + 1;

            String email = makeEmail(gen1, gen2, gen3);

            int mainNum = rnd.nextInt(90000000) + 10000000;
            insert = "INSERT INTO ADDRESS (ID, ADDITIONALINFO, STREET, CITYINFO_ID) VALUES (" + idBegin + ", '" + streetDesc[1] + "', '" + (rnd.nextInt(100) + 1 + " " + street) + "', " + 1 + "); \n"
                    + "INSERT INTO INFOENTITY (ID, DTYPE, EMAIL, ADDRESS_ID) VALUES (" + idBegin + ", 'Company','" + email + "', " + idBegin + "); \n"
                    + "INSERT INTO COMPANY (ID, CVR, DESCRIPTION, MARKETVALUE, NAME, NUMEMPLOYEES) "
                    + "VALUES (" + idBegin + ", '" + cvr + "', '" + desc + "', " + (rnd.nextDouble() * 20000.0) + ", '" + name + "', " + numEmployees + "); \n"
                    + "INSERT INTO PHONE (DESCRIPTION, NUMBER, INFOENTITY_ID) VALUE ('" + phoneDesc[2] + "', " + mainNum + ", " + idBegin + "); \n";
            int j = 0;
            while (j < rnd.nextInt(10) + 1) {
                int secNum = rnd.nextInt(90000000) + 10000000;
                insert += "INSERT INTO PHONE (DESCRIPTION, NUMBER, INFOENTITY_ID) VALUE ('" + phoneDesc[rnd.nextInt(phoneDesc.length - 2) + 2] + "', " + secNum + ", " + idBegin + "); \n";
                j++;
            }
            result += (insert + "\n");

            idBegin++;
            i++;
        }
        return result;
    }
     */
}
