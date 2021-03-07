package animals;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> list=new ArrayList<>();
        while(true){
            String line = scanner.nextLine();
            if(line.equals("Beast!")){
                break;
            }
            String[] data=scanner.nextLine().split(" ");
            String name=data[0];
            int age=Integer.parseInt(data[1]);
            String gender=data[2];
            switch(line){
                case "Dog":InvInput(data);Dog dog=new Dog(name,age,gender);list.add(dog); break;
                case "Cat":InvInput(data);Cat cat=new Cat(name,age,gender);list.add(cat); break;
                case "Frog":InvInput(data);Frog frog=new Frog(name,age,gender);list.add(frog); break;
                case "Kitten":InvInputForCat(data);Kitten kitten=new Kitten(name,age);list.add(kitten); break;
                case "Tomcat":InvInputForCat(data);Tomcat tomcat=new Tomcat(name,age);list.add(tomcat); break;
                default:throw new IllegalArgumentException("Invalid input!");

            }

        }
        for(Animal cur:list){
            System.out.println(cur);
        }
    }
    public static void InvInput(String[] arr){
        if(arr.length!=3){
            throw new IllegalArgumentException("Invalid input!");
        }

    }
    public static void InvInputForCat(String[] arr) {
        if (arr.length < 2) {
            throw new IllegalArgumentException("Invalid input!");
        }
    }
}
