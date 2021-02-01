package carConstructors;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        List<Car> list=new ArrayList<>();
        for(int i=0;i<a;i++){
            String line = scanner.nextLine();
            String[] arrString=line.split(" ");
            Car car;
            if(arrString.length==1){
                car=new Car(arrString[0]);
            }
            else{
                car=new Car(arrString[0],arrString[1],Integer.parseInt(arrString[2]));
            }
            list.add(car);
        }

        for(Car car: list){
            System.out.println(car.carInfo());
        }

    }
}
