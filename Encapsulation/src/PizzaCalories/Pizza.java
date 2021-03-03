package PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dought;
    private List<Topping> toppings;

    public Pizza(String name,int numberOfToppings){
setName(name);
setToppings(numberOfToppings);
toppings=new ArrayList<>();
    }
    private void setToppings(int toppingCount){
if(toppingCount<0||toppingCount>10){
    throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
}
    }
    private void setName(String name){
if(name.length()<1||name.length()>15||name.equals(" ")){
    throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
}
this.name=name;
    }
    public void setDough(Dough dough){
        this.dought=dough;
    }
    public String getName(){
        return this.name;
    }
    public void addTopping(Topping topping){
        this.toppings.add(topping);
    }
    public double getOverallCalories(){
        double sum=this.dought.calculateCalories();
        for(Topping cur: this.toppings){
            sum+=cur.calculateCalories();
        }
        return sum;
    }
}
