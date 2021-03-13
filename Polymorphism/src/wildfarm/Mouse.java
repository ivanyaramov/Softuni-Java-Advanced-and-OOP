package wildfarm;

public class Mouse extends Mammal {
    public Mouse(String animalName,  Double animalWeight, String livingRegion) {
        super(animalName, "Mouse", animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {
        if(food instanceof Vegetable){
            this.foodEaten+=food.getQuantity();
        }
        else{
            System.out.printf("Mice are not eating that type of food!%n");
        }
    }
}
