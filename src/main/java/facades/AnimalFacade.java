package facades;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.AnimalDTO;
import utils.HttpUtils;

import java.io.IOException;

public class AnimalFacade {

    private static Gson gson = new GsonBuilder().create();

    public AnimalDTO getRandomAnimal() throws IOException {
        String json = HttpUtils.fetchData("https://zoo-animal-api.herokuapp.com/animals/rand");
        return gson.fromJson(json, AnimalDTO.class);
    }
}
