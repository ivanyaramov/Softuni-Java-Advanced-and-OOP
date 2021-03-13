package vehicles;

public abstract class Vehicle {
    protected double quantity;
    protected double consumption;
    protected double capacity;

    public Vehicle(double quantity, double consumption, double capacity) {
        this.quantity = quantity;
        this.consumption = consumption;
        this.capacity = capacity;
    }
public abstract void setAirCondition(boolean bool);
    public  void refuel(double amount){
        if(amount<=0){
            System.out.println("Fuel must be a positive number");
        }
        else if(amount+quantity>capacity){
            System.out.println("Cannot fit fuel in tank");
        }
        else{
            quantity+=amount;
        }
    }
    public boolean drive(double amount) {
        if(quantity<amount*consumption){
return false;
        }
        else{
            quantity-=amount*consumption;
            return true;
        }
    }
}
