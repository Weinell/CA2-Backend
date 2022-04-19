package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facades.AnimalFacade;
import facades.FacadeExample;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

//Todo Remove or change relevant parts before ACTUAL use
@Path("animal")
public class AnimalResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static AnimalFacade FACADE = new AnimalFacade();
            
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }

    @Path("rand")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getRandomAnimal() throws IOException {
        return GSON.toJson(FACADE.getRandomAnimal());
    }
}
