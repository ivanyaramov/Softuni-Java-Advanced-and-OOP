package TrafficLights;

public class TrafficLight {
    TrafficLightState state;

    public TrafficLight(String state) {
        this.state=TrafficLightState.valueOf(state);
    }
    public void move(){
        switch(this.state){
            case RED:this.state=TrafficLightState.GREEN;
                break;
            case GREEN:this.state=TrafficLightState.YELLOW;
                break;
            case YELLOW:this.state=TrafficLightState.RED;
                break;
        }

    }

    @Override
    public String toString() {
        return String.valueOf(state);
    }
}
