/**
 * Write a description of class User here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class User
{
    private String userID;
    private Password password;
    private String accessLevel;
    private boolean loggedIn;
    public User(String u, String p, String a)
    {
        if (!("Admin".equals(accessLevel) || "SuperUser".equals(accessLevel)))
        {
            accessLevel = "Standard";
        }
        userID = u;
        password = new Password(p);
        accessLevel = a;
    }
    
    public boolean login(String u, String p)
    {
        if (u.equals(userID) && p.equals(password.getPassword()))
        {
            loggedIn = true;
        }
        return loggedIn;

    }
    public void logout()
    {
        loggedIn = false;
    }
    public String toString()
    
    {
       if (loggedIn == false)
        {
            return "Access Denied";
        }
       else
       {
           return "User: " + userID + "\nPassword: " + password + "\nAccess Level: " + accessLevel;
       }

    }

    
}

