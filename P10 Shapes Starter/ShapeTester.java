
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Scanner;
import java.io.*;

/**
 * The test class ShapeTester.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ShapeTester
{
    /**
     * Default constructor for test class ShapeTester
     */
    public ShapeTester()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() throws IOException
    {
        Scanner scan = new Scanner (new File("Circle.java"));
        String instVar = "";
        while(scan.hasNext())
        {
            String temp = scan.nextLine();
            if (temp.contains("private"))
                instVar += temp + "\n";
        }
        System.out.println(instVar);
    }

    @Test
    public void testShape()
    {
        Shape s1 = new Shape("Bob", "Blue");
        Shape s2 = new Shape();
        assertEquals(s1.toString(), "This shape is named : Bob and is the color Blue");
        assertEquals(s2.getLabel(), "Undefined Shape");
        assertEquals(s2.getColor(), "No Color Assigned");
        s2.setLabel("Biff");
        s2.setColor("Yellow");
        assertEquals(s2.getLabel(), "Biff");
        assertEquals(s2.getColor(), "Yellow");
    }

    @Test
    public void testCircle() throws IOException
    {
        Scanner scan = new Scanner (new File("Circle.java"));
        String instVar = "";
        String ext = "";
        while(scan.hasNext())
        {
            String temp = scan.nextLine();
            if (temp.contains("private"))
                instVar += temp + "\n";
            if (temp.contains("public class"))
                assertTrue("Class is not using inheritance.",temp.contains("extends"));
            assertTrue("Parent method duplicated in child",!temp.contains("public String getLabel"));
            assertTrue("Parent method duplicated in child",!temp.contains("public String getColor"));
            assertTrue("Parent method duplicated in child",!temp.contains("public void setLabel"));
            assertTrue("Parent method duplicated in child",!temp.contains("public void setColor"));
        }
        assertTrue("Parent variables should not be duplicated in child class",!instVar.contains("label"));
        assertTrue("Parent variables should not be duplicated in child class",!instVar.contains("color"));
        Circle c1 = new Circle(3,"Bob", "Blue");
        assertEquals(c1.toString(), "This shape is named : Bob and is the color Blue\nIt is a circle with area 28.274333882308138 and perimeter 18.84955592153876" );
        assertEquals(c1.getArea(),28.274333882308138, 0.001);
        assertEquals(c1.getPerimeter(),18.84955592153876, 0.001);
        assertEquals(c1.getRadius(),3);
        c1.setLabel("Biff");
        c1.setColor("Yellow");
        assertEquals(c1.getLabel(), "Biff");
        assertEquals(c1.getColor(), "Yellow");
    }

    @Test
    public void testRectangle() throws IOException
    {
        Scanner scan = new Scanner (new File("Rectangle.java"));
        String instVar = "";
        while(scan.hasNext())
        {
            String temp = scan.nextLine();
            if (temp.contains("private"))
                instVar += temp + "\n";
            if (temp.contains("public class"))
                assertTrue("Class is not using inheritance.",temp.contains("extends Shape"));
            assertTrue("Parent method duplicated in child",!temp.contains("public String getLabel"));
            assertTrue("Parent method duplicated in child",!temp.contains("public String getColor"));
            assertTrue("Parent method duplicated in child",!temp.contains("public void setLabel"));
            assertTrue("Parent method duplicated in child",!temp.contains("public void setColor"));

        }
        assertTrue("Parent variables should not be duplicated in child class",!instVar.contains("label"));
        assertTrue("Parent variables should not be duplicated in child class",!instVar.contains("color"));

        Rectangle r1 = new Rectangle(3,5,"Bob", "Blue");
        assertEquals(r1.toString(), "This shape is named : Bob and is the color Blue\nIt is a rectangle with area 15 and perimeter 16" );
        assertEquals(r1.getArea(),15);
        assertEquals(r1.getPerimeter(),16);
        assertEquals(r1.getWidth(),3);
        assertEquals(r1.getHeight(),5);
        r1.setLabel("Biff");
        r1.setColor("Yellow");
        assertEquals(r1.getLabel(), "Biff");
        assertEquals(r1.getColor(), "Yellow");
    }

    @Test
    public void testSquare() throws IOException
    {
        Scanner scan = new Scanner (new File("Square.java"));
        String instVar = "";
        while(scan.hasNext())
        {
            String temp = scan.nextLine();
            if (temp.contains("private"))
                instVar += temp + "\n";
            if (temp.contains("public class"))
                assertTrue("Class is not using inheritance correctly. Should extend Rectangle",temp.contains("extends Rectangle"));
            assertTrue("Parent method duplicated in child",!temp.contains("public String getLabel"));
            assertTrue("Parent method duplicated in child",!temp.contains("public String getColor"));
            assertTrue("Parent method duplicated in child",!temp.contains("public void setLabel"));
            assertTrue("Parent method duplicated in child",!temp.contains("public void setColor"));
            assertTrue("Parent method duplicated in child",!temp.contains("public int getArea"));
            assertTrue("Parent method duplicated in child",!temp.contains("public int getPerimeter"));
            assertTrue("Parent method duplicated in child",!temp.contains("public int getWidth"));
            assertTrue("Parent method duplicated in child",!temp.contains("public int getHeight"));

        }
        assertTrue("Parent variables should not be duplicated in child class",!instVar.contains("label"));
        assertTrue("Parent variables should not be duplicated in child class",!instVar.contains("color"));

        Square r1 = new Square(3,"Bob", "Blue");
        assertEquals(r1.toString(), "This shape is named : Bob and is the color Blue\nIt is a square with area 9 and perimeter 12" );
        assertEquals(r1.getArea(),9);
        assertEquals(r1.getPerimeter(),12);
        assertEquals(r1.getWidth(),3);
        assertEquals(r1.getHeight(),3);
        r1.setLabel("Biff");
        r1.setColor("Yellow");
        assertEquals(r1.getLabel(), "Biff");
        assertEquals(r1.getColor(), "Yellow");
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
