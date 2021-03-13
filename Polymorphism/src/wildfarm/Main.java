package wildfarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Mammal> list=new ArrayList<>();
        while(true){
            String animalAsString = scanner.nextLine();
            if(animalAsString.equals("End")){
                break;
            }
            String[] arrAnimal=animalAsString.split(" ");
            String foodAsString=scanner.nextLine();
            String[] arrFood=foodAsString.split(" ");
            Mammal animal=createMammal(arrAnimal);
            Food food=createFood(arrFood);
            animal.makeSound();
            animal.eat(food);
            list.add(animal);


        }
        for(Mammal cur: list){
            System.out.println(cur);
        }

    }
    public static Mammal createMammal(String[] arr){
        String type=arr[0];
        String name=arr[1];
        Double weight=Double.parseDouble(arr[2]);
        String region=arr[3];
        switch(type){
            case "Cat":
                Mammal cat=new Cat(name,weight,region,arr[4]);
                return cat;
            case "Tiger":
                Mammal tiger=new Tiger(name,weight,region);
                return tiger;
            case "Zebra":
                Mammal zebra=new Zebra(name,weight,region);
                return zebra;
                case "Mouse":
                Mammal mouse=new Mouse(name,weight,region);
                return mouse;

        }
return null;
    }

    public static Food createFood(String[] arr){
        String type=arr[0];
        Integer amount=Integer.parseInt(arr[1]);
        if(type.equals("Vegetable")){
            Vegetable vegetable=new Vegetable(amount);
            return vegetable;
        }
        else{
            Meat meat=new Meat(amount);
            return meat;
        }

    }
}
