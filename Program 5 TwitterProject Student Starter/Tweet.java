/**
 * Write a description of class Tweet here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tweet
{
    // instance variables - replace the example below with your own
    private String twt;
    private String handle;
    
    public Tweet(String x, String y)
    {
        if(twt.length()>140){
            twt = twt.substring(0,140);
        }
        else{
            twt=x;
        }
       handle = "@" + y;
    }
    public String getBody()
    {
        return twt;
    }
    public String getHandle()
    {
        return handle;
    }
    
    public String getAllRecipients()
    {
        String a= twt;
        String b ="";
        while (a.indexOf("@") != 1)
        {
            a = a.substring(1+a.indexOf("@"));
            if(a.indexOf(" ")==-1)
            {
                b += "@" + a + "\n";
            }
            else
            {
                b += "@" + a.substring(0,a.indexOf(" ")) + "\n";
            }
                
                
                
                
         
         }
    return b;
    
    }
    public String getAllHashtags()
    {
        String a= twt;
        String b ="";
        while (a.indexOf("#") != 1)
        {
            a = a.substring(1+a.indexOf("#"));
            if(a.indexOf(" ")==-1)
            {
                b += "#" + a + "\n";
            }
            else
            {
                b += "#" + a.substring(0,a.indexOf(" ")) + "\n";
            }
             
                
         
         }
    return b;
    
    }
    public String toString()
    {
        return handle + ": " + twt;
    }
    
}

