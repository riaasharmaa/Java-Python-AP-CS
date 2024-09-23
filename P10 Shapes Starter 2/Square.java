/**
 * Write a description of class Square here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Square extends Rectangle
{
    private int sideLength;
    public Square(int sl, String l, String c)
    {
        super(sl,sl,l,c);
        sideLength = sl;
    }
    public String toString()
    {
        return "This shape is named : " + super.getLabel() + " and is the color " + super.getColor();
    }
}
