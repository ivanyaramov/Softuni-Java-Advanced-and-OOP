package PointinRectangle;

public class Rectangle {
    Point bottomLeft;
    Point topRight;
    public Rectangle(Point bottomLeft,Point topRight){
        this.bottomLeft=bottomLeft;
        this.topRight=topRight;
    }
    public boolean contains(Point point){
        return point.x>=bottomLeft.x && point.y>=bottomLeft.y&&point.x<=topRight.x&&point.y<=topRight.y;
    }
}
