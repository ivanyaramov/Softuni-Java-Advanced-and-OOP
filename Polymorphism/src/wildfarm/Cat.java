package wildfarm;

import java.text.DecimalFormat;

public class Cat extends Feline {
    private String breed;

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Cat(String animalName, Double animalWeight, String livingRegion, String breed) {
        super(animalName, "Cat", animalWeight, livingRegion);
        this.breed=breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
        this.foodEaten+=food.getQuantity();
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("###.###");

        return String.format("%s[%s, %s, %s, %s, %d]",this.animalType,this.animalName,this.breed,df.format(this.animalWeight),getLivingRegion(),this.foodEaten);

    }
}
