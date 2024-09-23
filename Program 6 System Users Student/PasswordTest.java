

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PasswordTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PasswordTest
{
    /**
     * Default constructor for test class PasswordTest
     */
    public PasswordTest()
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
    public void constuctorTest()
    {
        Password password1 = new Password("Test");
        assertEquals("Test", password1.getPassword());
        assertEquals("Password: Test", password1.toString());
    }
}

