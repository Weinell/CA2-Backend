package dtos;

public class AnimalJokeDTO {
    private AnimalDTO animal;
    private JokeDTO joke;

    public AnimalJokeDTO(AnimalDTO animal, JokeDTO joke) {
        this.animal = animal;
        this.joke = joke;
    }
}
