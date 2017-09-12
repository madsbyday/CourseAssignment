/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import Facade.FacadeImpl;
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
import Facade.FacadeInterface;

/**
 * REST Web Service
 *
 * @author Sanox
 */
@Path("person")
public class PersonRest {

    @Context
    private UriInfo context;

    private FacadeInterface f = new FacadeImpl(Persistence.createEntityManagerFactory("CAPU"));
    
    public PersonRest() {
    }

    /**
     * Retrieves representation of an instance of rest.PersonRest
     * @return an instance of java.lang.String
     */
    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersonId(@PathParam("id") Long id) {
        
        Person p = f.getPerson(id);
        String json = JSONConverter.getJSONFromPerson(p);
        return json;
    }

    /**
     * PUT method for updating or creating an instance of PersonRest
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
