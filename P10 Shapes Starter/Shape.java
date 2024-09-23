public class Shape
{
    private String label;
    private String color;
    public Shape(String l, String c)
    {
        label = l;
        color = c;
    }
    public Shape()
    {
        label = "Undefined Shape";
        color = "No Color Assigned";
    }
    public void setLabel(String l)
    {
        label = l;
    }
    public String getLabel()
    {
        return label;
    }
    public void setColor(String c)
    {
        color = c;
    }
    public String getColor()
    {
        return color; 
    }
    public String toString()
    {
        return "This shape is named : " + label + "and is the color " + color;
    }
}
