
/**
 * Write a description of class HSStudent here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HSStudent extends Student
{
    // instance variables - replace the example below with your own
    private int cHours;
    private String year;
    /**
     * Constructor for objects of class HSStudent
     */
    public HSStudent(String n, int i, String sn, double g, int c)
    {
        // initialise instance variables
        super(n, i, sn, g);
        updateStatus(c);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean updateStatus(int num)
    {
        cHours+=num;
        if(cHours<=8)  year= "Freshman";
        else if(cHours<=16)  year= "Sophomore";
        else if(cHours<=24)  year= "Junior";
        else if(cHours<=27)  year= "Senior";
        else {
            year="Graduate";
            return true;
        }
        return false;
    }
    public String toString() 
    {
        return super.toString()+"\tYear: "+year;
    }
}
