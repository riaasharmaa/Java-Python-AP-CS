
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * The test class TestCardDeck.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class HandTest
{
    
    
    /**
     * Default constructor for test class TestCardDeckShoe
     */
    public HandTest()
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

    //Card Test Methods

    @Test
    public void HandTest()
    {
        Hand h1 = new Hand();
        h1.addCard(new Card("Ace", "Hearts"));
        h1.addCard(new Card("Two", "Clubs"));
        h1.addCard(new Card("Three", "Spades"));
        assertEquals(3, h1.getHandSize());
        Card c = h1.getCard();
        assertEquals("Ace",c.getRank());
        c = h1.getCard();
        assertEquals("Two",c.getRank());
        assertEquals(1, h1.getHandSize());
        c = h1.getCard();
        assertEquals("Three",c.getRank());
        assertEquals(0, h1.getHandSize());
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

