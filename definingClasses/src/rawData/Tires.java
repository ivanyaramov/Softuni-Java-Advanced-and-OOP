package rawData;

public class Tires {
    private int age;
    private double pressure;

    public Tires(int age, double pressure) {
        this.age = age;
        this.pressure = pressure;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }
}
