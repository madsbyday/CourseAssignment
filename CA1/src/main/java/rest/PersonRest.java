/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import Facade.facadeImpl;
import converter.JSONConverter;
import entity.Person;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import Facade.facadeInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entity.Address;
import entity.Hobby;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import jdk.nashorn.internal.parser.JSONParser;
import jsonmapper.PersonWhole;

/**
 * REST Web Service
 *
 * @author Sanox
 */
@Path("person")
public class PersonRest
{

    @Context
    private UriInfo context;

    private facadeInterface f = new facadeImpl();
    PersonWhole pw = new PersonWhole();
    

    public PersonRest()
    {
        f.addEntityManagerFactory(Persistence.createEntityManagerFactory("CAPU"));
    }

    /**
     * Retrieves representation of an instance of rest.PersonRest
     *
     * @return an instance of java.lang.String
     */
    @Path("complete/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersonId(@PathParam("id") long id)
    {
        return pw.getWholePerson(id);
    } // returns person from database as json object

    @Path("complete")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getpersons() {
        return pw.getAllPersonWhole();
    }
    @Path("complete/city/{city}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getpersonsByCity(@PathParam("city") String zipcode) {
        return pw.getAllpersonWholeByZip(zipcode);
    }
    
    @Path("contactinfo/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersonInfoId(@PathParam("id") long id)
    {
        return pw.getpersonContact(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public String getPerson(@PathParam("id") Long id)
    {
        Person p = f.getPerson(id);

        if(p != null)
        {
            return new Gson().toJson(p);
        }
        
        return "{}";
    }
    
    @Path("contactinfo")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getpersonsInfo() {
        return pw.getAllpersonContact();
    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String createPerson(String content)
    {
        JsonObject body = new JsonParser().parse(content).getAsJsonObject();
        String firstName = null;
        String lastName = null;
        String mail = null;
        String street = null;
        String info = null;

        if (body.has("firstName"))
        {
            firstName = body.get("firstName").getAsString();
        }
        if (body.has("lastName"))
        {
            lastName = body.get("lastName").getAsString();
        }
        if (body.has("email"))
        {
            mail = body.get("email").getAsString();
        }
        if (body.has("address")) {
            street = body.getAsJsonObject("address").get("street").getAsString();
        }
        if (body.has("address")) {
            info = body.getAsJsonObject("address").get("additionalInfo").getAsString();
        }
        
        Address a = new Address(street, info, null); // null er city info *TO BE MADE*
        
        Person p = new Person(firstName, lastName, mail, a);
        f.addPerson(p);

        String json = new Gson().toJson(p);
        return json;
    }

    @Path("complete/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String editPerson(String content, @PathParam("id") Long id)
    {
        JsonObject body = new JsonParser().parse(content).getAsJsonObject();
        Person p = f.getPerson(id);

        if (body.has("firstName"))
        {
            p.setFirstName(body.get("firstName").getAsString());
        }
        if (body.has("lastName"))
        {
            p.setLastName(body.get("lastName").getAsString());
        }
        if (body.has("email"))
        {
            p.setEmail(body.get("email").getAsString());
        }
        f.editPerson(p);
        return pw.getWholePerson(p.getId());
    }

    @Path("{id}")
    @DELETE
    public void deletePerson(@PathParam("id") long id)
    {
        f.deletePerson(id);
    }
}
