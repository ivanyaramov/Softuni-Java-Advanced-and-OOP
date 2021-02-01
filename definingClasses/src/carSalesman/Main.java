package carSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        List<Car> listCar=new ArrayList<>();
        List<Engine> listEngine=new ArrayList<>();
        for(int i=0;i<N;i++){
            String line=scanner.nextLine();
            String[]arr=line.split(" ");
            if(arr.length==4){
                Engine4(listEngine,arr[0],Integer.parseInt(arr[1]),arr[2],arr[3]);
            }
            if(arr.length==3){
                Engine3(listEngine,arr[0],Integer.parseInt(arr[1]),arr[2]);
            }
            if(arr.length==2){
                Engine2(listEngine,arr[0],Integer.parseInt(arr[1]));
            }

        }
        int M=Integer.parseInt(scanner.nextLine());
        for(int i=0;i<M;i++){
            String line=scanner.nextLine();
            String[] arr=line.split(" ");
            String name=arr[0];
            String engName=arr[1];
            Engine engine = null;
            for(Engine cur:listEngine){
                if(cur.getModel().equals(engName)){
                    engine=cur;
                    break;
                }
            }
            if(arr.length==4){
                Car4(listCar,name,engine,arr[2],arr[3]);
            }
            if(arr.length==3){
                Car3(listCar,name,engine,arr[2]);
            }
            if(arr.length==2){
                Car2(listCar,name,engine);
            }

        }
Consumer<Engine> printEngine=p->
{
    System.out.printf("%s:%n",p.getModel());
    System.out.printf("Power: %d%n",p.getPower());
    System.out.printf("Displacement: %s%n",p.getDisplacement());
    System.out.printf("Efficiency: %s%n",p.getEfficiency());
};
        Consumer<Car> printCar=p->
        {
            System.out.println(p.getModel()+":");
            printEngine.accept(p.getEngine());
            System.out.printf("Weight: %s%n",p.getWeight());
            System.out.printf("Color: %s%n",p.getColor());

        };

        listCar.stream()
                .forEach(printCar);

    }
    public static void Engine4(List<Engine> listEngine,String model,int power,String displacement,String efficiency ){
        Engine engine=new Engine(model,power,displacement,efficiency);
        listEngine.add(engine);
    }
    public static void Engine3(List<Engine> listEngine,String model,int power,String third ){
        Engine engine;
        if(Character.isDigit(third.charAt(0))){
            engine=new Engine(model,power,third,"n/a");
        }
        else{
            engine=new Engine(model,power,"n/a",third);
        }

        listEngine.add(engine);
    }
    public static void Engine2(List<Engine> listEngine,String model,int power){
        Engine engine=new Engine(model,power,"n/a","n/a");
        listEngine.add(engine);
    }
    public static void Car4(List<Car> listCar,String model,Engine engine,String weight,String color){
        Car car=new Car(model,engine,weight,color);
        listCar.add(car);
    }
    public static void Car3(List<Car> listCar,String model,Engine engine,String third){
        Car car;
        if(Character.isDigit(third.charAt(0))){
            car=new Car(model,engine,third,"n/a");
        }
        else{
            car=new Car(model,engine,"n/a",third);
        }
        listCar.add(car);
    }
    public static void Car2(List<Car> listCar,String model,Engine engine){
        Car car=new Car(model,engine,"n/a","n/a");
        listCar.add(car);
    }
}
