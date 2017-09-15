/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonmapper;

import Facade.FacadeImpl;
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

    facadeInterface f = new FacadeImpl();

    public String getWholePerson(long id) {

        f.addEntityManagerFactory(Persistence.createEntityManagerFactory("CAPU"));

        Person p = f.getPerson(id);

        JsonObject joA = new JsonObject();
        joA.addProperty("street", p.getAddress().getStreet());
        joA.addProperty("additionalInfo", p.getAddress().getAdditionalInfo());
        joA.addProperty("city", p.getAddress().getCityInfo().getCity());
        joA.addProperty("zipcode", p.getAddress().getCityInfo().getZipCode());

        String jsonAddress = new Gson().toJson(joA);

        JsonArray ja = new JsonArray();

        for (int i = 0; i < p.getHobbys().size(); i++) {
            JsonObject joH = new JsonObject();
            joH.addProperty("description", p.getHobbys().get(i).getDescription());
            joH.addProperty("name", p.getHobbys().get(i).getName());
            ja.add(joH);
        }
        
        JsonArray jap = new JsonArray();
        List<Phone> phones = f.getPhonesByPerson(p.getId());
        
        for (int i = 0; i < phones.size(); i++)
        {
            JsonObject joP = new JsonObject();
            joP.addProperty("description", phones.get(i).getDescription());
            joP.addProperty("number", phones.get(i).getNumber());
            jap.add(joP);
        }

        JsonObject jo = new JsonObject();
        jo.addProperty("firstName", p.getFirstName());
        jo.addProperty("lastName", p.getLastName());
        jo.addProperty("email", p.getEmail());
        jo.add("address", joA);
        jo.add("hobbys", ja);
        jo.add("phones", jap);

        String jsonWhole = new Gson().toJson(jo);
        return jsonWhole;
    }

}
