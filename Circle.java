import java.lang.Math;
import java.awt.*;
public class Circle{
  private double pos_x;
  private double pos_y;
  private double radius;
  private Color c;

  public Circle(double pos_x, double pos_y, double radius){ //constructor
    this.radius=radius;
    this.pos_x=pos_x;
    this.pos_y=pos_y;
  }
    public double calculatePerimeter(){
    double perimeter=0;
    perimeter+=(2*Math.PI*radius);
    return perimeter;
  }
  public double calculateArea(){ //Here I am calculating the Area of the circle
    double area=0;
    area+=(Math.PI*radius*radius);
    return area;
  }
  public void setColor(Color c){
    this.c=c;
  }
  public void setPos(double pos_x, double pos_y){
    this.pos_x=pos_x;
    this.pos_y=pos_y;

  }
  public void setRadius(double radius){
    this.radius=radius;
  }
  public Color getColor(){
    return c;
  }
  public double getXPos(){
    return pos_x;
  }
  public double getYPos(){
    return pos_y;
  }
  public double getRadius(){
    return radius;
  }
}
