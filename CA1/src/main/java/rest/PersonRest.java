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
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import jdk.nashorn.internal.parser.JSONParser;

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
    public String getPersonId(@PathParam("id") Long id)
    {

        Person p = f.getPerson(id);
        String json = new Gson().toJson(p);
        return json;
    }

    /**
     * PUT method for updating or creating an instance of PersonRest
     *
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String createPerson(String content)
    {
        JsonObject body = new JsonParser().parse(content).getAsJsonObject();
        String firstName = null;
        String lastName = null;
        String mail = null;
        
        if (body.has("firstName")) {
            firstName = body.get("firstName").getAsString();
        }
        if (body.has("lastName")) {
            lastName = body.get("lastName").getAsString();
        }
        if (body.has("email")) {
            mail = body.get("email").getAsString();
        }
        
        Person p = new Person(null, firstName, lastName, mail);
        f.addPerson(p);
        
        String json = new Gson().toJson(p);
        return json;
    }
    
    @Path("complete/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String editPerson(String content, @PathParam("id") Long id) {
        JsonObject body = new JsonParser().parse(content).getAsJsonObject();
        Person p = f.getPerson(id);
        
        if (body.has("firstName")) {
            p.setFirstName(body.get("firstName").getAsString());
        }
        if (body.has("lastName")) {
            p.setLastName(body.get("lastName").getAsString());
        }
        if (body.has("email")) {
            p.setEmail(body.get("email").getAsString());
        }
        
        f.editPerson(p);
        
        String json = new Gson().toJson(p);
        return json;
    }
    
    @Path("{id}")
    @DELETE
    public void deletePerson(@PathParam("id") long id) {
        f.deletePerson(id);
    }
}
