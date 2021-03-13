package vehicles;

public class Truck extends Vehicle{
    public Truck(double quantity, double consumption,double capacity) {
        super(quantity, consumption+1.6,capacity);
    }

    @Override
    public void setAirCondition(boolean bool) {

    }

    @Override
    public void refuel(double amount) {
        if(amount<=0){
            System.out.println("Fuel must be a positive number");
        }
        else if(amount+quantity>capacity){
            System.out.println("Cannot fit fuel in tank");
        }
        else{
            this.quantity=this.quantity+amount*0.95;
        }

    }
}
