package facades;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.JokeDTO;
import utils.HttpUtils;

import java.io.IOException;

public class FoxFacade {

    private static final Gson gson = new GsonBuilder().create();


    public JokeDTO getRandomFox() throws IOException {

        String json = HttpUtils.fetchData("https://randomfox.ca/floof/?ref=apilist.fun");

        return gson.fromJson(json, JokeDTO.class);
    }

}
