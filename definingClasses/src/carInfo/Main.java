package carInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Car> list =new ArrayList<>();
        int a = Integer.parseInt(scanner.nextLine());
        for(int i=0;i<a;i++){
            Car car=new Car();
            String line = scanner.nextLine();
            String[]arrString=line.split(" ");
            car.setBrand(arrString[0]);
            car.setModel(arrString[1]);
            car.setHorsePower(Integer.parseInt(arrString[2]));
            list.add(car);
        }
        for(Car car: list){
            System.out.println(car.carInfo());
        }

    }
}
