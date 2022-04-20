package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facades.HomeFacade;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.ExecutionException;

@Path("jokeanimal")
public class JokeAnimalResource {

    private static HomeFacade FACADE = new HomeFacade();
    private static Gson GSON = new GsonBuilder().create();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getRandomJokeAnimal() throws ExecutionException, InterruptedException {
        return GSON.toJson(FACADE.getJokeAnimalDTO());
    }
}