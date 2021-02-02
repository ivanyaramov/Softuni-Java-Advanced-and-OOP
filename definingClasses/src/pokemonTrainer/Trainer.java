package pokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> lisOfPokemons;

    public Trainer(String name, int numberOfBadges, List<Pokemon> lisOfPokemons) {
        this.name = name;
        this.numberOfBadges = numberOfBadges;
        this.lisOfPokemons = lisOfPokemons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public void setNumberOfBadges(int numberOfBadges) {
        this.numberOfBadges = numberOfBadges;
    }

    public List<Pokemon> getLisOfPokemons() {
        return lisOfPokemons;
    }

    public void setLisOfPokemons(List<Pokemon> lisOfPokemons) {
        this.lisOfPokemons = lisOfPokemons;
    }
}
