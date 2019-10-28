import java.lang.Math;
import java.awt.*;
public class Triangle{
  private double pos_x;
  private double pos_y;
  private double width;
  private double height;
  private Color c;

  public Triangle(double pos_x, double pos_y, double width, double height){
    this.width=width;
    this.height=height;
    this.pos_x=pos_x;
    this.pos_y=pos_y;
  }
  public double calculatePerimeter(){
    double a=45.0;
    double angle=Math.toRadians(a);
    double side=(width/(2*Math.cos(angle)));
    double perimeter=0.0;
    perimeter+=(width+2*side);
    return perimeter;
  }
  public double calculateArea(){
    double area=0.0;
    area+=(Math.abs(height*width*.5));//used absolute value because I used negative values in my triangle pattern. This calculates the correct total area for the shapes printed
    return area;
  }
  public void setColor(Color c){
    this.c=c;
  }
  public void setPos(double pos_x, double pos_y){
    this.pos_x=pos_x; this.pos_y=pos_y;
  }
  public void setHeight(double height){
    this.height=height;
  }
  public void setWidth(double width){
    this.width=width;
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
  public double getHeight(){
    return height;
  }
  public double getWidth(){
    return width;
  }
}
