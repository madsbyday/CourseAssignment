/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonmapper;

import Facade.facadeImpl;
import Facade.facadeInterface;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import java.util.List;
import javax.persistence.Persistence;

/**
 *
 * @author vfgya
 */
public class PersonWhole {

    facadeInterface f = new facadeImpl(Persistence.createEntityManagerFactory("CAPU"));

    public PersonWhole() {
        //f.addEntityManagerFactory(Persistence.createEntityManagerFactory("CAPU"));
    }

   public JsonObject getAddressAsJson(Person p)
    {
        JsonObject joA = new JsonObject();
        try
        {
            joA.addProperty("street", p.getAddress().getStreet());
            joA.addProperty("additionalInfo", p.getAddress().getAdditionalInfo());
            joA.addProperty("city", p.getAddress().getCityInfo().getCity());
            joA.addProperty("zipcode", p.getAddress().getCityInfo().getZipCode());
        } catch (NullPointerException ex)
        {
            joA.addProperty("street", "");
            joA.addProperty("additionalInfo", "");
            joA.addProperty("city", "");
            joA.addProperty("zipcode", "");
            return joA;
        }
        return joA;
    }

    public JsonArray getHobbies(Person p)
    {
        JsonArray ja = new JsonArray();

        if (p.getHobbys().size() != 0)
        {
            for (int i = 0; i < p.getHobbys().size(); i++)
            {
                JsonObject joH = new JsonObject();
                joH.addProperty("description", p.getHobbys().get(i).getDescription());
                joH.addProperty("name", p.getHobbys().get(i).getName());
                ja.add(joH);
            }
        }
        return ja;
    }

    public JsonArray getPhones(Person p)
    {
        JsonArray jap = new JsonArray();
        try
        {
            List<Phone> phones = f.getPhonesByPerson(p.getId());

            for (int i = 0; i < phones.size(); i++)
            {
                JsonObject joP = new JsonObject();
                joP.addProperty("description", phones.get(i).getDescription());
                joP.addProperty("number", phones.get(i).getNumber());
                jap.add(joP);
            }
        } catch (NullPointerException ex)
        {
            return jap;
        }
        return jap;
    }

    public String getWholePerson(long id)
    {

        Person p = f.getPerson(id);

        JsonObject jo = new JsonObject();
        jo.addProperty("firstName", p.getFirstName());
        jo.addProperty("lastName", p.getLastName());
        jo.addProperty("email", p.getEmail());
        jo.add("address", getAddressAsJson(p));
        jo.add("hobbys", getHobbies(p));
        jo.add("phones", getPhones(p));

        String jsonWhole = new Gson().toJson(jo);
        return jsonWhole;
    }

    public String getAllPersonWhole()
    {

        List<Person> persons = f.getPersons();

        JsonObject jow = new JsonObject();

        JsonArray ja = new JsonArray();
        for (int i = 0; i < persons.size(); i++)
        {
            JsonObject jo = new JsonObject();
            jo.addProperty("firstName", persons.get(i).getFirstName());
            jo.addProperty("lastName", persons.get(i).getLastName());
            jo.addProperty("email", persons.get(i).getEmail());
            jo.add("address", getAddressAsJson(persons.get(i)));
            jo.add("hobbys", getHobbies(persons.get(i)));
            jo.add("phones", getPhones(persons.get(i)));
            ja.add(jo);
        }

        for (int i = 0; i < ja.size(); i++)
        {
            jow.add("persons", ja);
        }

        String jsonall = new Gson().toJson(jow);
        return jsonall;
    }

    public String getAllpersonWholeByZip(String zipcode)
    {
        List<Person> persons = f.getPersons();

        JsonObject jow = new JsonObject();

        JsonArray ja = new JsonArray();
        for (int i = 0; i < persons.size(); i++)
        {
            if (persons.get(i).getAddress().getCityInfo().getZipCode().equals(zipcode))
            {
                JsonObject jo = new JsonObject();
                jo.addProperty("firstName", persons.get(i).getFirstName());
                jo.addProperty("lastName", persons.get(i).getLastName());
                jo.addProperty("email", persons.get(i).getEmail());
                jo.add("address", getAddressAsJson(persons.get(i)));
                jo.add("hobbys", getHobbies(persons.get(i)));
                jo.add("phones", getPhones(persons.get(i)));
                ja.add(jo);

            }
        }

        for (int i = 0; i < ja.size(); i++)
        {
            jow.add("persons", ja);
        }

        String jsonall = new Gson().toJson(jow);
        return jsonall;
    }
    public String getAllpersonContact() {
         List<Person> persons = f.getPersons();

        JsonObject jow = new JsonObject();

        JsonArray ja = new JsonArray();
        for (int i = 0; i < persons.size(); i++)
        {
            JsonObject jo = new JsonObject();
            jo.addProperty("email", persons.get(i).getEmail());
            jo.add("address", getAddressAsJson(persons.get(i)));
            jo.add("phones", getPhones(persons.get(i)));
            ja.add(jo);
        }

        for (int i = 0; i < ja.size(); i++)
        {
            jow.add("persons", ja);
        }

        String jsonall = new Gson().toJson(jow);
        return jsonall;
    }
    public String getpersonContact(long id) {
        Person p = f.getPerson(id);

        JsonObject jo = new JsonObject();
        jo.addProperty("email", p.getEmail());
        jo.add("address", getAddressAsJson(p));
        jo.add("phones", getPhones(p));

        String jsonWhole = new Gson().toJson(jo);
        return jsonWhole;
    }
    
}
