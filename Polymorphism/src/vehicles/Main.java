package vehicles;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String carAsString = scanner.nextLine();
        Vehicle car=createVeh(carAsString);
        String truckAsString = scanner.nextLine();
        Vehicle truck=createVeh(truckAsString);
        String busAsString = scanner.nextLine();
        Vehicle bus=createVeh(busAsString);

        int n = Integer.parseInt(scanner.nextLine());
        for(int i=0;i<n;i++){
         execution(car,truck,bus,scanner);
        }
        System.out.printf("Car: %.2f%n",car.quantity);
        System.out.printf("Truck: %.2f%n",truck.quantity);
        System.out.printf("Bus: %.2f",bus.quantity);

    }
    public static void execution(Vehicle car,Vehicle truck,Vehicle bus,Scanner scanner){
        DecimalFormat df = new DecimalFormat("###.##");

        String[] arr=scanner.nextLine().split(" ");
String command=arr[0];
String veh=arr[1];
double amount=Double.parseDouble(arr[2]);
switch(command){
    case "Drive":
        switch(veh){
            case "Bus":
                bus.setAirCondition(true);
                if(bus.drive(amount)){
                    System.out.print("Bus travelled ");
                    System.out.print(df.format(amount));
                    System.out.println(" km");
                }
                else{
                    System.out.println("Bus needs refueling");
                }
                break;
            case "Car":
                if(car.drive(amount)){
                    System.out.print("Car travelled ");
                    System.out.print(df.format(amount));
                    System.out.println(" km");
                }
                else{
                    System.out.println("Car needs refueling");
                }
                break;
            case "Truck":
                if(truck.drive(amount)){
                    System.out.print("Truck travelled ");
                    System.out.print(df.format(amount));
                    System.out.println(" km");
                }
                else{
                    System.out.println("Truck needs refueling");
                }
                break;
        }
        break;

    case "Refuel":
        switch(veh) {
            case "Bus":
                bus.refuel(amount);
                break;
            case "Car":
                car.refuel(amount);

                break;
            case "Truck":
                truck.refuel(amount);
                break;
        }
        break;

    case "DriveEmpty":
        bus.setAirCondition(false);
        if(bus.drive(amount)){
            System.out.print("Bus travelled ");
            System.out.print(df.format(amount));
            System.out.println(" km");
        }
        else{
            System.out.println("Bus needs refueling");
        }
        break;



}
    }
    public static Vehicle createVeh(String line){
        String[] arr=line.split(" ");
        String type=arr[0];
        double quantity=Double.parseDouble(arr[1]);
        double liters=Double.parseDouble(arr[2]);
        double capacity=Double.parseDouble(arr[3]);
        if(type.equals("Car")){
            Vehicle veh=new Car(quantity,liters,capacity);
            return veh;
        }
        else if(type.equals("Truck")){
            Vehicle veh=new Truck(quantity,liters,capacity);
            return veh;
        }
        else{
            Vehicle veh=new Bus(quantity,liters,capacity);
            return veh;
        }

    }
}
