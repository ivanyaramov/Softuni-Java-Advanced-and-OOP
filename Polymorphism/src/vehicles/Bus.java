package vehicles;

public class Bus extends Vehicle {
    private boolean Aircondition;
    public Bus(double quantity, double consumption, double capacity) {
        super(quantity, consumption, capacity);
        Aircondition=false;

    }
    public void setAirCondition(boolean bool){
      if(bool!=Aircondition){
          setConsumption(bool);
      }
      Aircondition=bool;
    }
    private void setConsumption(boolean bool){
        if(bool){
            this.consumption+=1.4;
        }
        else{
            this.consumption-=1.4;
        }

    }
}
