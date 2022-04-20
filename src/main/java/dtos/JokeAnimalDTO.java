package dtos;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class JokeAnimalDTO {
    private JsonObject jokeObj;
    private JsonObject animalObj;

    public JokeAnimalDTO(String joke, String animal) {
        this.jokeObj = new Gson().fromJson(joke, JsonObject.class);
        this.animalObj = new Gson().fromJson(animal, JsonObject.class);
    }

    @Override
    public String toString() {
        return "JokeAnimalDTO{" + "joke=" + jokeObj.get("value").toString() + ", animal=" + animalObj.get("name").toString() + '}';
    }
}
