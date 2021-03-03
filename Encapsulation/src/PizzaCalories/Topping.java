package PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;
    public Topping(String type,double weight){
        setToppingType(type);
        setWeight(weight);

    }
    private void  setToppingType(String type){
if(!type.equals("Meat")&&!type.equals("Veggies")&&!type.equals("Cheese")&&!type.equals("Sauce")){
    throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.",type));
}
this.toppingType=type;
    }
    private void setWeight(double weight){
if(weight<1||weight>50){
    throw new IllegalArgumentException(String.format("%s weight should be in range [1..50].",this.toppingType));
}
this.weight=weight;
    }
    public double calculateCalories(){
        double sum=this.weight*2;
        switch(this.toppingType){
            case "Meat":sum*=1.2;break;
            case "Veggies":sum*=0.8;break;
            case "Cheese":sum*=1.1;break;
            case "Sauce":sum*=0.9;break;
        }
        return sum;
    }
}
