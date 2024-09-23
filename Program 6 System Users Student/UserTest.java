

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class UserTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class UserTest
{
    /**
     * Default constructor for test class UserTest
     */
    public UserTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void constructorTestDefaultLoggedIn()
    {
        User user1 = new User("Dr. Jones", "Indiana", "SuperUser");
        assertEquals("Access Denied", user1.toString());
        
    }

    @Test
    public void testConstructorSuperUser()
    {
        User user1 = new User("Asoka Tano", "Jedi", "SuperUser");
        assertEquals(true, user1.login("Asoka Tano", "Jedi"));
        assertEquals("User: Asoka Tano\nPassword: Jedi\nAccess Level: SuperUser", user1.toString());
    }
    
    @Test
    public void testConstructorAdmin()
    {
        User user1 = new User("Asoka Tano", "Jedi", "Admin");
        assertEquals(true, user1.login("Asoka Tano", "Jedi"));
        assertEquals("User: Asoka Tano\nPassword: Jedi\nAccess Level: Admin", user1.toString());
    }
    
    @Test
    public void testConstructorStandard()
    {
        User user1 = new User("Asoka Tano", "Jedi", "Standard");
        assertEquals(true, user1.login("Asoka Tano", "Jedi"));
        assertEquals("User: Asoka Tano\nPassword: Jedi\nAccess Level: Standard", user1.toString());
    }
    
    @Test
    public void testConstructorInvalidAccessType()
    {
        User user1 = new User("Asoka Tano", "Jedi", "Master User");
        assertEquals(true, user1.login("Asoka Tano", "Jedi"));
        assertEquals("User: Asoka Tano\nPassword: Jedi\nAccess Level: Standard", user1.toString());
    }
    
    @Test
    public void toStringTestLoggedIn()
    {
        User user1 = new User("Asoka Tano", "Jedi", "SuperUser");
        assertEquals(true, user1.login("Asoka Tano", "Jedi"));
        assertEquals("User: Asoka Tano\nPassword: Jedi\nAccess Level: SuperUser", user1.toString());
    }
    
    @Test
    public void toStringTestNOTLoggedIn()
    {
        User user1 = new User("Asoka Tano", "Jedi", "SuperUser");
        assertEquals("Access Denied", user1.toString());
    }
    
    @Test
    public void loginSuccess()
    {
        User user1 = new User("Asoka Tano", "Jedi", "Standard");
        assertEquals(true, user1.login("Asoka Tano", "Jedi"));
        assertEquals("User: Asoka Tano\nPassword: Jedi\nAccess Level: Standard", user1.toString());
    }
    
    @Test
    public void loginFailureWrongPassword()
    {
        User user1 = new User("Asoka Tano", "Jedi", "Standard");
        assertEquals(false, user1.login("Asoka Tano", "JediMaster"));
        assertEquals("Access Denied", user1.toString());
    }
    
    @Test
    public void loginFailureUserID()
    {
        User user1 = new User("Asoka Tano", "Jedi", "Standard");
        assertEquals(false, user1.login("Asoka Tanp", "Jedi"));
        assertEquals("Access Denied", user1.toString());
    }
    
    @Test
    public void loginFailureWrongIdAndPassword()
    {
        User user1 = new User("Asoka Tano", "Jedi", "Standard");
        assertEquals(false, user1.login("Adoka Tano", "Jedo"));
        assertEquals("Access Denied", user1.toString());
    }
    
    @Test
    public void loginFailureAlreadyLoggedIn()
    {
        //Create and log in
        User user1 = new User("Asoka Tano", "Jedi", "Standard");
        assertEquals(true, user1.login("Asoka Tano", "Jedi"));
        assertEquals("User: Asoka Tano\nPassword: Jedi\nAccess Level: Standard", user1.toString());
        // log in again with bad data, should stay logged in since they were logged in previously.
        assertEquals(true, user1.login("Asoka Tano", "JediMASTER"));
        assertEquals("User: Asoka Tano\nPassword: Jedi\nAccess Level: Standard", user1.toString());
    }
    
    @Test
    public void logoutTestWhenLoggedIn()
    {
        //create and log in
        User user1 = new User("Asoka Tano", "Jedi", "Standard");
        assertEquals(true, user1.login("Asoka Tano", "Jedi"));
        assertEquals("User: Asoka Tano\nPassword: Jedi\nAccess Level: Standard", user1.toString());
        // logout
        user1.logout();
        assertEquals("Access Denied", user1.toString());
    }
    
    @Test
    public void logoutTestWhenLoggedOut()
    {
        //create and do not log in 
        User user1 = new User("Asoka Tano", "Jedi", "Standard");
        assertEquals("Access Denied", user1.toString());
        // logout (should stay logged out)
        user1.logout();
        assertEquals("Access Denied", user1.toString());
    }
}


