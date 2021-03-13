package wildfarm;

public class Zebra extends Mammal {
    public Zebra(String animalName, Double animalWeight, String livingRegion) {
        super(animalName, "Zebra", animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }
    @Override
    public void eat(Food food) {
        if(food instanceof Vegetable){
            this.foodEaten+=food.getQuantity();
        }
        else{
            System.out.printf("Zebras are not eating that type of food!%n");
        }
    }


}
