package dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    List<Car> data;
    String name;
    int capacity;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data=new ArrayList<>();
    }
    public void add(Car car){
        if(data.size()+1<=capacity){
            data.add(car);
        }
    }
    public boolean buy(String manufacturer,String model){
        for(int i=0;i<data.size();i++){
            Car cur=data.get(i);
            if(cur.getManufacturer().equals(manufacturer)&&cur.getModel().equals(model)){
                data.remove(i);
                return true;
            }
        }
        return false;
    }
    public Car getLatestCar(){
        int max=0;
        Car carLast=new Car("a","a",1);
        if(data.size()>0){
            for(Car car:data){
            if(car.getYear()>max){
                max=car.getYear();
                carLast=car;
            }
            }
            return carLast;
        }
        return null;
    }
    public Car getCar(String manufacturer,String model){
        for(int i=0;i<data.size();i++){
            Car cur=data.get(i);
            if(cur.getManufacturer().equals(manufacturer)&&cur.getModel().equals(model)){
                return cur;

            }
        }
        return null;
    }

    public int getCount(){
        return data.size();
    }
    public String getStatistics(){
        StringBuilder build=new StringBuilder();
        build.append(String.format("The cars are in a car dealership %s",name));
        for(Car cur: data){
            build.append(System.lineSeparator());
            build.append(cur.toString());
        }
        return build.toString();
    }
}
