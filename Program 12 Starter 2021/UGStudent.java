
/**
 * Write a description of class UGStudent here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class UGStudent extends Student
{
    // instance variables - replace the example below with your own
    private String major;
    private int cHours;
    private String year;

    /**
     * Constructor for objects of class UGStudent
     */
    public UGStudent(String n, int i, String sn, double g, int c
    , String m)
    {
        super(n, i, sn, g);
        updateStatus(c);
        major=m;
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
        if(cHours<=30)  year= "Freshman";
        else if(cHours<=60)  year= "Sophomore";
        else if(cHours<=90)  year= "Junior";
        else if(cHours<=119)  year= "Senior";
        else {
            year="Graduate";
            return true;
        }
        return false;
    }
    public String toString() 
    {
        return super.toString()+"\tMajor: "+major+"\tYear: "+year;
    }
}
