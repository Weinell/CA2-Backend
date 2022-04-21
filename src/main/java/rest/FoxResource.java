package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facades.JokeFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path("fox")
public class FoxResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final JokeFacade FACADE =  new JokeFacade();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"This is a funny joke\"}";
    }
    @Path("rand")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllJoke() throws IOException {

        return GSON.toJson(FACADE.getRandomJoke());
    }

}
