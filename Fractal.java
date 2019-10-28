import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class Fractal {
    private static Random rand=new Random();//imported and used in the circle class, changes things up and provides a new color each time
    private static double total_area=0;//used to find the sum of each individual shape's area
    //private static int calls=0;//used to help me know how many times the shapes is printed

    public static void main(String[] args) {
        Color pink=Color.PINK;

        //the pink (line 11) is used to set the first shape's color for the triangle and circle.
        Scanner s=new Scanner(System.in);//imported so user can pick the shape
        System.out.println("What shape would you like to draw?:"+'\n'+"Triangle, Rectangle, or Circle?");//prompts the user to pick the shape
        String shape = s.nextLine();//shape is the variable containing the user input.
        Canvas w = new Canvas(10000,10000);//full screen canvas is made, allows for bigger shapes.
        switch(shape){//switch case that runs based off of the user input
            case "Triangle":
            case "triangle":
                //lines 19/20 allows the input to not be case specific.
                Triangle tri1=new Triangle(510,50,350,-350);
                tri1.setColor(Color.pink);
                fractalTriangle(w,tri1);//this is the first triangle that is printed, and is used to make the smaller triangles in the pattern
                System.out.println("Great choice! Three is company!");//just for some humor
                System.out.println("The total area is: "+total_area);//provides the user with the total area of the shapes
                //System.out.println("Called "+calls+" times");//used this to tell me how many times the pattern is repeated
                break;
            case "Rectangle":
            case "rectangle":
                //lines 29/30 allows the input to not be case specific.
                Rectangle rect1= new Rectangle(510,270,400,200);
                rect1.setColor(Color.BLACK);
                fractalRectangle(w,rect1);
                System.out.println("Great choice! Rigid Rectangles, coming your way!");//just for some humor
                System.out.println("The total area is: "+total_area);
                //System.out.println("Called "+calls+" times");//used this to tell me how many times the pattern is repeated
                break;
            case"Circle":
            case "circle":
                //lines 37/38 allows the input to not be case specific.
                Circle circ1=new Circle(700,400,400);
                circ1.setColor(pink);
                fractalCircle(w,circ1);
                System.out.println("Great choice! Round is right!");//just for some humor
                System.out.println("The total area is: "+total_area);
                //System.out.println("Called "+calls+" times");//used this to tell me how many times the pattern is repeated
                break;
            default:
                break;
        }
    }
    public static void fractalCircle(Canvas w, Circle circ){
        w.drawShape(circ);//calls the canvas class to add the shapes
        total_area+=circ.calculateArea();
        Color col2= new Color(rand.nextInt(0xFFFFFF));
        //the line above and below (56 and 58) selects a random color to make the output a little more colorful and different each time
        Color col4=new Color(rand.nextInt(0xFFFFFF));
        double radius=circ.getRadius();
        double pos_y=circ.getYPos();
        double pos_x=circ.getXPos();
        //calls++;
        if(radius>2){//base case
            Circle circ2=new Circle(pos_x-radius/2,pos_y,radius/2);
            Circle circ3=new Circle(pos_x+radius/2, pos_y, radius/2);
            Circle circ4=new Circle(pos_x, pos_y-radius*.67, radius/3.);
            Circle circ5=new Circle(pos_x, pos_y+radius*.67, radius/3.);
            //the lines 56-59 make new circles and places them at the set locations with each recursive call
            circ2.setColor(col2);
            circ3.setColor(col2);
            circ4.setColor(col4);
            circ5.setColor(col4);
            //randomized colors for the circle
            fractalCircle(w,circ2);
            fractalCircle(w,circ3);
            fractalCircle(w,circ4);
            fractalCircle(w,circ5);
            //lines 74-77 recursively call the method
            //It should be noted that sometimes the random color used will be the same shade as the initial circle printed, making the new circles difficult to see. If this happens please run again.
        }
    }

    public static void fractalRectangle(Canvas w, Rectangle rect) {
        w.drawShape(rect);
        total_area+=rect.calculateArea();
        Color col2 =Color.BLACK;//new Color(rand.nextInt(0xFFFFFF)); was using random colors, but thought solid black looked best
        double width = rect.getWidth();
        double height = rect.getHeight();
        double xpos = rect.getXPos();
        double ypos = rect.getYPos();
        //calls++;
        if (width > 5) {//base case
            Rectangle rect2 = new Rectangle(xpos + width, ypos+height, width / 2, height / 2);
            Rectangle rect3 = new Rectangle(xpos-width/2, ypos+height, width / 2, height / 2);
            Rectangle rect4=new Rectangle(xpos+width,ypos-height/2,width/2,height/2);
            Rectangle rect5=new Rectangle(xpos-width/2,ypos-height/2,width/2,height/2);
            //lines 93-96 make new rectangles and place them at the four corners of the previous rectangles
            rect2.setColor(col2);
            rect3.setColor(col2);
            rect4.setColor(col2);
            rect5.setColor(col2);
            fractalRectangle(w,rect2);
            fractalRectangle(w,rect3);
            fractalRectangle(w,rect4);
            fractalRectangle(w,rect5);
        }
    }

    public static void fractalTriangle(Canvas w, Triangle tri){
        w.drawShape(tri);
        total_area+=tri.calculateArea();
        Color col2 =new Color(rand.nextInt(0xFFFFFF));
        Color col3 =new Color(rand.nextInt(0xFFFFFF));
        double width=tri.getWidth();
        double height=tri.getHeight();
        double xpos=tri.getXPos();
        double ypos=tri.getYPos();
        //calls++;
        if(width>1){
            Triangle tri2=new Triangle(xpos+width,ypos,width/2,height/2);
            Triangle tri3=new Triangle(xpos-width/2,ypos,width/2,height/2);
            Triangle tri4=new Triangle(xpos+width/4,ypos-height*2,width/2,height/-2);//height is divided by -2 to flip the triangle.
            //lines 120-122 make new triangles and display the pattern shown when ran
            tri2.setColor(col2);
            tri3.setColor(col2);
            tri4.setColor(col3);
            fractalTriangle(w,tri2);
            fractalTriangle(w,tri3);
            fractalTriangle(w,tri4);
        }
    }
}
