package animals;

public abstract class Animal {
    public Animal(String name, String favouriteFood) {
        this.name = name;
        this.favouriteFood = favouriteFood;
    }

    protected String name;
    protected String favouriteFood;
    public abstract String explainSelf();

}
