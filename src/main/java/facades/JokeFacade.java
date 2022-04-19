package facades;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.JokeDTO;
import utils.HttpUtils;

import java.io.IOException;

public class JokeFacade {

    private static final Gson gson = new GsonBuilder().create();


    public JokeDTO getRandomJoke() throws IOException {

        String json = HttpUtils.fetchData("https://api.chucknorris.io/jokes/random");

        return gson.fromJson(json, JokeDTO.class);
    }


}
