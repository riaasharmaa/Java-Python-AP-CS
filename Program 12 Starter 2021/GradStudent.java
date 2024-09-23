
/**
 * Write a description of class GradStudent here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GradStudent extends Student
{
    // instance variables - replace the example below with your own
    private String degree;
    private int cHours;
    private int dPages;
    private String dStatus;
    /**
     * Constructor for objects of class GradStudent
     */
    public GradStudent(String n, int i, String sn, double g, int c, 
    int dp, String d)
    {
        super(n, i, sn, g);
        dPages=dp;
        updateStatus(c);
        degree=d;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean updateStatus(int num)
    {
        if(cHours<60)   cHours+=num;
        else    dPages+=num;
        
        if(cHours<60)  dStatus= "Planning";
        else if(dPages<100)  dStatus= "ABD - Writing";
        else if(dPages<=249)  dStatus= "ABD - Revising";
        else {
            dStatus="PhD Earned";
            return true;
        }
        return false;
    }
    public String toString() 
    {
        return super.toString()+"\tStatus: " + dStatus;
    }
}
