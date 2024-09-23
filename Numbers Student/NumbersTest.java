
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class AListTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class NumbersTest
{
    private Numbers list;
    private ArrayList<Integer> temp;
    /**
     * Default constructor for test class AListTest
     */
    public NumbersTest()
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
        temp = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++)
            temp.add(i+1);
        temp.set(4, 37);
        list = new Numbers(temp);
    }
    
    @Test
    public void testGetNums()
    {
        ArrayList<Integer> data = list.getNums();
        for (int i = 0; i < temp.size(); i++)
            assertEquals(temp.get(i), data.get(i) );
    }
    
    @Test
    public void testAddNegatives()
    {
        list.addNegatives();
        assertEquals("[-1, 1, 2, -999, 4, 37, 6, 7, 8, 9, 10, -100]", list.toString());
        //ArrayList<Integer> data = list.getNums();
        //for (int i = 0; i < temp.size(); i++)
        //    assertEquals(temp.get(i), data.get(i) );
    }
    @Test
    public void testSpecialConstructor()
    {
        list = new Numbers(5);
        assertEquals("[5, 10, 15, 20, 25]", list.toString());
        
    }
    
    @Test
    public void testRemoveEven()
    {
        int count = list.removeEven();
        assertEquals(5, count);
        ArrayList<Integer> data = list.getNums();
        assertEquals("[1, 3, 37, 7, 9]", list.toString());
        ArrayList<Integer> data2 = new ArrayList<Integer>();
        data2.add(2);
        data2.add(4);
        data2.add(6);
        data2.add(8);
        data2.add(25);
        list = new Numbers(data2);
        count = list.removeEven();
        assertEquals(4, count);
        assertEquals("[25]", list.toString());
    }
    
    @Test
    public void testfindMaxLocation()
    {
         assertEquals(4, list.findMaxLocation() );
         // put the max somewhere else and try again
         ArrayList<Integer> data = list.getNums();
         data.set(0, 100);
         list = new Numbers(data);
         assertEquals(0, list.findMaxLocation() );
         // put the max somewhere else and try again
         data.set(5, 101);
         list = new Numbers(data);
         assertEquals(5, list.findMaxLocation() );
    }
    @Test
    public void testGetSum()
    {
         assertEquals(87, list.getSum() );
         // change a value and try again
         ArrayList<Integer> data = list.getNums();
         data.set(2, 14);
         list = new Numbers(data);
         assertEquals(98, list.getSum());
        
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
}
