

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ActivityTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ActivityTest
{
    Activity a1,a2,a3,a4,a5,a6,a7,a8;
    /**
     * Default constructor for test class ActivityTest
     */
    public ActivityTest()
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
        a1 = new Activity ("Event 1", "Wednesday", 1700, 30);
        a2 = new Activity ("Event 2", "Tuesday", 1700, 60);
        a3 = new Activity ("Event 3", "Wednesday", 1700, 90);
        a4 = new Activity ("Event 4", "Thursday", 1700, 135);
        a5 = new Activity ();
        a6 = new Activity ("Event 6", "Wednesday", 1800, 60);
        a7 = new Activity ("Event 7", "Wednesday", 1900, 60);
        a8 = new Activity ("Event 8", "Wednesday", 1815, 30);
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
    public void defaultConstructor()
    {
        Activity a9 = new Activity();
        assertEquals("Unknown", a9.getName());
        assertEquals("Monday", a9.getDay());
        assertEquals(1700, a9.getStartTime());
        assertEquals(60, a9.getDuration());
    }
    @Test
    public void paramConstructor()
    {
        Activity a10 = new Activity("Thing","Sunday", 1200, 90);
        assertEquals("Thing", a10.getName());
        assertEquals("Sunday", a10.getDay());
        assertEquals(1200, a10.getStartTime());
        assertEquals(90, a10.getDuration());
    }
    @Test
    public void getters()
    {
        assertEquals("Event 2", a2.getName());
        assertEquals("Tuesday", a2.getDay());
        assertEquals(1700, a2.getStartTime());
        assertEquals(60, a2.getDuration());
    }
    @Test
    public void setters()
    {
        a2.setName("New");
        a2.setDay("Saturday");
        a2.setStartTime(500);
        a2.setDuration(180);
        assertEquals("New", a2.getName());
        assertEquals("Saturday", a2.getDay());
        assertEquals(500, a2.getStartTime());
        assertEquals(180, a2.getDuration());
    }
    @Test
    public void endTime()
    {
        Activity a11 = new Activity("stuff", "Monday", 1730, 45);
        Activity a12 = new Activity("stuff", "Monday", 1715, 45);
        Activity a13 = new Activity("stuff", "Monday", 1710, 45);
        int x = a11.getDuration();
        assertEquals(1815, a11.getEndTime());
        assertEquals(x, a11.getDuration());
        x = a12.getDuration();
        assertEquals(1800, a12.getEndTime());
        assertEquals(x, a12.getDuration());
        x = a13.getDuration();
        assertEquals(1755, a13.getEndTime());
        assertEquals(x, a13.getDuration());
        x = a1.getDuration();
        assertEquals(1730, a1.getEndTime());
        assertEquals(x, a1.getDuration());
        x = a2.getDuration();
        assertEquals(1800, a2.getEndTime());
        assertEquals(x, a2.getDuration());
        x = a3.getDuration();
        assertEquals(1830, a3.getEndTime());
        assertEquals(x, a3.getDuration());
        x = a4.getDuration();
        assertEquals(1915, a4.getEndTime());
        assertEquals(x, a4.getDuration());
        x = a5.getDuration();
        assertEquals(1800, a5.getEndTime());
        assertEquals(x, a5.getDuration());
       
    }
    @Test
    public void overlap()
    {
        assertEquals(true, a3.overlap(a6));  //partial overlap
        assertEquals(true, a6.overlap(a3));
        assertEquals(false, a1.overlap(a6));  //no overlap, not adjacent
        assertEquals(false, a6.overlap(a1));
        assertEquals(false, a7.overlap(a6));  //adjacent, but no overlap
        assertEquals(false, a6.overlap(a7));
        assertEquals(true, a8.overlap(a6));   //one event completely overlapped
        assertEquals(true, a6.overlap(a8));
        assertEquals(false, a1.overlap(a2));  //different day, but matching times
        assertEquals(false, a2.overlap(a1));
        
        Activity a15 = new Activity ("Event 1", "Wednesday", 1700, 30);
        assertEquals(true, a15.overlap(a1));  //same start time
        assertEquals(true, a1.overlap(a15));
        Activity a16 = new Activity ("Event 1", "Tuesday", 1701, 30);
         assertEquals(false, a15.overlap(a16));  //same start time, diff day
        assertEquals(false, a16.overlap(a15));
    }
    @Test
    public void testToString()
    {
        assertEquals("Event 4\tThursday\t1700\t135", a4.toString());
    }
}

