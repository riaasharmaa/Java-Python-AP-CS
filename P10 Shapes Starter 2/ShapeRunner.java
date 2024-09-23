/**
 * Write a description of class ShapeRunner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ShapeRunner
{
    public static void main (String[] args)
    {
        Rectangle R1 = new Rectangle(20,30,"R1","Blue");
        Circle C1 = new Circle(15,"C1", "Red");
        System.out.println(R1);
        System.out.println(C1);
        System.out.println("The width of the rectangle " + R1.getLabel() + " is " + R1.getWidth() + " and the height is " + R1.getHeight());
        C1.setLabel("Sir Curmference");
        System.out.println(C1);
        Square S1 = new Square(5,"Huey","Green");
        System.out.println(S1); 
    }
}
