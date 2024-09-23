
/**
 * Write a description of class UserRunner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class UserRunner
{
    public static void main(String[] args)
    {
        User u1 = new User ("Babbage", "2Bo!2b?Shkspr", "Master");
        System.out.println(u1);
        u1.login("Ria","PurpleGirl");
        System.out.println(u1);
        u1.login("Babbage", "2Bo!2b?Shkspr");
        System.out.println(u1);
        u1.logout();
        System.out.println(u1);
        User u2 = new User ("Lovelace", "ttls,hI1derwUr!", "Admin");
        u2.login("Lovelace", "ttls,hI1derwUr!");
        System.out.println(u2);
    }
    
}
