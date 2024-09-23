/**
 * Write a description of class Rectangle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rectangle extends Shape 
{
    private int width;
    private int height;
    
    public Rectangle(int w, int h, String l, String c)
    {
        super(l,c);
        width = w;
        height = h;
    }
    public void setWidth(int w)
    {
        width = w;
    }
    public int getWidth()
    {
        return width;
    }
    public void setHeight(int h)
    {
        height = h;
    
    }
    public int getHeight()
    {
        return height;
    }
    public int getArea()
    {
        return width*height;
    }
    public int getPerimeter()
    {
        return 2*width+2*height;
    }
    
}