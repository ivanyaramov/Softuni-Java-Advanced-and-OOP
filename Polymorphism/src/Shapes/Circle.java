package Shapes;

public class Circle extends Shape{
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
        setArea(calculateArea());
        setPerimeter(calculatePerimeter());
    }

    public final Double getRadius() {
        return radius;
    }

    @Override
    Double calculatePerimeter() {
        return Math.PI*radius*2;
    }

    @Override
    Double calculateArea() {
        return radius*radius*Math.PI;
    }
}
