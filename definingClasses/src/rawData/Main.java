package rawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        List<Car> list=new ArrayList<>();
        for(int i=0;i<a;i++){
            String line = scanner.nextLine();
            String[] arr=line.split(" ");
            String model=arr[0];
            int engineSpeed=Integer.parseInt(arr[1]);
            int enginePower=Integer.parseInt(arr[2]);
            int cargoWeight=Integer.parseInt(arr[3]);
            String cargoType=arr[4];
            List<Tires> listOfTires=new ArrayList<>();
            for(int k=5;k<=12;k+=2){
                double pressure=Double.parseDouble(arr[k]);
                int age=Integer.parseInt(arr[k+1]);
                Tires tire =new Tires(age,pressure);
                listOfTires.add(tire);
            }
            Engine engine=new Engine(engineSpeed,enginePower);
            Cargo cargo=new Cargo(cargoType,cargoWeight);
            Car car=new Car(model,engine,cargo,listOfTires);
            list.add(car);
        }

        String command = scanner.nextLine();
        Predicate<Car> forFragile=p->
        {
            for(Tires cur:p.getListOfTires()){
                if(cur.getPressure()<1){
                    return true;
                }
            }
            return false;
        };
        Predicate<Car> forFlamable=p->
        {
            return p.getEngine().getEnginePower() > 250;
        };
        if(command.equals("fragile")){
            list.stream()
                    .filter(forFragile)
                    .forEach(p-> System.out.println(p.getModel()));
        }
        else if(command.equals("flamable")){
            list.stream()
                    .filter(forFlamable)
                    .forEach(p-> System.out.println(p.getModel()));
        }
    }
}
