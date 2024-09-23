
/**
 * Circle is-a Shape
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Circle extends Shape
{
    private int radius;
    public Circle(int r, String l, String c)
    {
        super(l,c);
        radius = r;
    }
    public void setRadius(int r)
    {
        radius=r;
    }
    public int getRadius()
    {
        return radius;
    }
    public double getArea()
    {
        return (double)(Math.PI*radius*radius);
    }
    public double getPerimeter()
    {
        return (double)(2 * Math.PI * radius);
    }
    public String toString()
    {
        return super.toString()+"\nIt is a circle with area "+getArea()+" and radius " + getRadius();
    }
}

