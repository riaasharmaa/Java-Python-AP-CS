
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SalesAnalyzerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class FullSalesAnalyzerTest
{
    private SalesAnalyzer salesAna1;

    /**
     * Default constructor for test class SalesAnalyzerTest
     */
    public FullSalesAnalyzerTest()
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
        String[] names = {"Artemis", "Beecher", "Carina", "Doctor", "Emma", "Frodo", "Gumby", "Hogarth"};
        int[] sales = {150, 200, 140, 230, 230, 200, 120, 230};
        salesAna1 = new SalesAnalyzer(names, sales);
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
    public void maxSaleAmount()
    {
        assertEquals(230, salesAna1.maxSale());
    }

    @Test
    public void minSaleAmount()
    {
        assertEquals(120, salesAna1.minSale());
    }

    @Test
    public void averageSaleAmount()
    {
        assertEquals(187.5, salesAna1.averageSale(), 0.01);
    }

    @Test
    public void totalSales()
    {
        assertEquals(1500, salesAna1.totalSales());
    }

    @Test
    public void numAtOrAbove200()
    {
        assertEquals(5, salesAna1.numSalesAtOrAbove(200));
    }

    @Test
    public void report()
    {
        System.out.println("This method should return a string that matches the table below:");
        System.out.println("Salesperson   Sales\n"+
            "--------------------\n"+
            "Artemis" + "\t\t" + 150+"\n"+
            "Beecher" + "\t\t" + 200+"\n"+
            "Carina" + "\t\t" + 140+"\n"+
            "Doctor" + "\t\t" + 230+"\n"+
            "Emma" + "\t\t" + 230+"\n"+
            "Frodo" + "\t\t" + 200+"\n"+
            "Gumby" + "\t\t" + 120+"\n"+
            "Hogarth" + "\t\t" + 230+"\n");

        System.out.println(salesAna1.report());
    }

    @Test
    public void maxPeople()
    {
        String[] names = {"Doctor", "Emma", "Hogarth"};
        assertArrayEquals(names, salesAna1.maxSalesPeople());
    }

    @Test
    public void peopleAbove200()
    {
        String[] names = {"Beecher", "Doctor", "Emma", "Frodo", "Hogarth"};
        assertArrayEquals(names, salesAna1.peopleWithSalesAtOrAbove(200));
    }

    
    
}
