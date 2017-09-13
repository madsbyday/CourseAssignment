/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import java.util.Random;

/**
 *
 * @author Alexander
 */
public class Generate {

    Random rnd = new Random();

    String[] firstNames = {"Sofia", "Alma", "Emma", "Ella", "Ida", "Freja", "Clara", "Anna", "Laura", "Alberte",
        "Noah", "Victor", "Oliver", "Oscar", "William", "Lucas", "Carl", "Malthe", "EmilAlfred"};

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

    String[] phoneDesc = {"Mobil", "Home", "Office"};

    public String generatePersons(int idBegin, int amount) {
        String insert;
        String result = "";
        int i = 1;
        while (i < amount) {
            String firstName = firstNames[rnd.nextInt(firstNames.length)];
            String lastName = lastNames[rnd.nextInt(firstNames.length)];
            String email = firstName + idBegin + "@gmail.com";
            String street = lastNames[rnd.nextInt(lastNames.length)] + " " + streetEnd[rnd.nextInt(streetEnd.length)];
            int number = rnd.nextInt(90000000) + 10000000;
            
            insert = "INSERT INTO INFOENTITY (ID, EMAIL, ADDRESS_ID) VALUES (" + idBegin + ", '"  + email + "', " + idBegin +"); \n"
                    + "INSERT INTO PERSON (FIRSTNAME, LASTNAME) VALUES ('" + firstName + "','" + lastName + "'); \n"
                    + "INSERT INTO ADDRESS (ID, ADDITIONALINFO, STREET, CITIINFO_ID) VALUES (" + idBegin + ", '" + streetDesc[0] + "', '" + (rnd.nextInt(100) + 1 + " " + street) + "', " + rnd.nextInt(1352) + "); \n"
                    + "INSERT INTO PHONE (DESCRIPTION, NUMBER, INFOENTITY_ID) VALUES ('" + phoneDesc[rnd.nextInt(phoneDesc.length - 1)] + "', '" + number + "', " + idBegin + "); \n"
                    + "\n";
            result += insert;

            idBegin++;
            i++;
        }
        return result;
    }

    public String generateCompany(int idBegin, int amount) {
        String insert;
        String result = "";
        int i = 1;
        while (i < amount) {
            int cvr = rnd.nextInt(90000) + 10000;
            String gen1 = companyGen1[rnd.nextInt(companyGen1.length)];
            String gen2 = companyGen2[rnd.nextInt(companyGen2.length)];
            String gen3 = companyGen3[rnd.nextInt(companyGen3.length)];
            String name = gen1 + gen2 + gen3;
            String desc = companyDesc[rnd.nextInt(companyDesc.length)];
            String street = lastNames[rnd.nextInt(lastNames.length)] + " " + streetEnd[rnd.nextInt(streetEnd.length)];
            int number = rnd.nextInt(90000000) + 10000000;
            String email = makeEmail(gen1, gen2, gen3);

            System.out.println(name + " " + desc + " " + email);
            
            insert = "INSERT INTO COMPANY (ID, CVR, DESCRIPTION, EMAIL, MARKETVALUE, NAME, NUMEMPLOYEES, ADDRESS_ID) "
                    + " VALUES (" + idBegin + ", '" + cvr + "', '" + desc + "', '" + email + "', " + (rnd.nextDouble()* 20000.0) + ", '" + name + "', " + (rnd.nextInt(100) + 1) + ", " + idBegin + "); \n"
                    + "INSERT INTO ADDRESS (ID, ADDITIONALINFO, STREET, CITIINFO_ID) VALUES (" + idBegin + ", '" + streetDesc[1] + "', '" + (rnd.nextInt(100) + 1 + " " + street) + "', " + rnd.nextInt(1352) + "); \n"
                    + "INSERT INTO PHONE (DESCRIPTION, NUMBER, INFOENTITY_ID) VALUES ('" + phoneDesc[2] + "', '" + number + "', " + idBegin + "); \n"
                    + "\n";
            result += insert;

            idBegin++;
            i++;
        }
        return result;
    }

    public String makeEmail(String gen1, String gen2, String gen3) {
        String email = "info@" + gen1;
        if (!gen2.equalsIgnoreCase(" ") && !gen2.equalsIgnoreCase(" & ") && !gen2.equalsIgnoreCase("!")){
            email += gen2;
        }
        if (!gen3.equalsIgnoreCase("...") && !gen3.equalsIgnoreCase("!") && !gen3.equalsIgnoreCase(" A/S") && !gen3.equalsIgnoreCase("$")) {
            email += gen3;
        }
        return email + ".dk";
    }
}
