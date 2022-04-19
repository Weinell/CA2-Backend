package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facades.AnimalFacade;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
@Path("animal")
public class AnimalResource {

    private static AnimalFacade FACADE = new AnimalFacade();

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Path("rand")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getRandomAnimal() throws IOException {
        return GSON.toJson(FACADE.getRandomAnimal());
    }
}
