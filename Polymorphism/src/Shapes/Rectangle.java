package Shapes;

public class Rectangle extends Shape {
    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
        setArea(calculateArea());
        setPerimeter(calculatePerimeter());
    }

    private Double height;
    private Double width;

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }

    @Override
    Double calculatePerimeter() {
        return (height+width)*2;
    }

    @Override
    Double calculateArea() {
        return height*width;
    }
}
