package PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstLine=scanner.nextLine();
        String[] pizzaString=firstLine.split(" ");
        Pizza pizza=new Pizza(pizzaString[1],Integer.parseInt(pizzaString[2]));
        String secondLine=scanner.nextLine();
        String[] doughString=secondLine.split(" ");
        Dough dough=new Dough(doughString[1],doughString[2],Double.parseDouble(doughString[3]));
        pizza.setDough(dough);
        int number=Integer.parseInt(pizzaString[2]);
        while(true){
            String a = scanner.nextLine();
            if(a.equals("END")){
                break;
            }
            String[]toppingString=a.split(" ");
            Topping topping=new Topping(toppingString[1],Double.parseDouble(toppingString[2]));
        pizza.addTopping(topping);
        }
        System.out.printf("%s - %.2f",pizza.getName(),pizza.getOverallCalories());


    }
}
