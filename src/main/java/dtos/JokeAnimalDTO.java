package dtos;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class JokeAnimalDTO {
    private JsonObject jokeObj;
    private JsonObject animalObj;

    private JsonObject foxObj;

    public JokeAnimalDTO(String joke, String animal, String fox) {
        this.jokeObj = new Gson().fromJson(joke, JsonObject.class);
        this.animalObj = new Gson().fromJson(animal, JsonObject.class);
        this.foxObj = new Gson().fromJson(fox, JsonObject.class);
    }

    @Override
    public String toString() {
        return "JokeAnimalDTO{" + "joke=" + jokeObj.get("value").toString() + ", animal=" + animalObj.get("name").toString() + ", fox=" + foxObj.get("image").toString() + '}';
    }
}
