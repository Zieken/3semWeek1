/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import entities.Animal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Kasper Jeppesen
 */
@Path("animal")
public class AnimalResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AnimalResource
     */
    public AnimalResource() {
    }
    
    public List<Animal> createAnimals()
    {
        Animal elefant = new Animal(1955, "Elefant", "The sound of an elefant");
        Animal mouse = new Animal(2017, "Mouse", "The sound of an mouse");
        Animal turtle = new Animal(1901, "Turtle", "The sound of an turtle");
        Animal horse = new Animal(2009, "Horse", "The sound of an horse");
        
        List animals = new ArrayList();
        animals.add(elefant);
        animals.add(mouse);
        animals.add(turtle);
        animals.add(horse);
        
        return animals;
        
    }

    /**
     * Retrieves representation of an instance of rest.AnimalResource
     * @return an instance of java.lang.String
     */
    @GET
    //@Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
       return "Hello from my first webservice";
    }
    
    @GET
    @Path("chosen")
    @Produces(MediaType.APPLICATION_JSON)
    public String chooseAnimal()
    {
        Random rand = new Random();
        List animals = createAnimals();
        
        Animal chosenAnimal = (Animal) animals.get(rand.nextInt(animals.size()));
        return new Gson().toJson(chosenAnimal);
    }

    /**
     * PUT method for updating or creating an instance of AnimalResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
