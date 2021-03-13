package vehicles;

public class Car extends Vehicle {
    public Car(double quantity, double consumption,double capacity) {
        super(quantity, consumption+0.9,capacity);
    }

    @Override
    public void setAirCondition(boolean bool) {

    }


}
