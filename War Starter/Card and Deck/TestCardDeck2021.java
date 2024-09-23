
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
public class TestCardDeck2021
{
    ArrayList<Card> master = new ArrayList<Card>(); //for deck
    
    /**
     * Default constructor for test class TestCardDeckShoe
     */
    public TestCardDeck2021()
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
        String[] suits = {"Hearts","Clubs","Diamonds","Spades"};
        String[] ranks = {"Ace", "Two", "Three", "Four", "Five","Six", "Seven",
                "Eight","Nine","Ten","Jack","Queen","King"};
        //Deck Setup
        for (int s = 0; s < suits.length; s++)
            for (int r = 0; r < ranks.length; r++)     
            {
                master.add(new Card(ranks[r], suits[s]));
            }
        
    }

    //Card Test Methods

    @Test
    public void TestGetters()
    {
        Card card1 = new Card("Ace","Hearts");
        assertEquals("Ace", card1.getRank());
        assertEquals("Hearts", card1.getSuit());
        assertEquals(14, card1.getValue());
    }

    @Test
    public void TestCardValuesInConstructor()
    {
        Card card1 = new Card("Ace","Hearts");
        assertEquals(14,card1.getValue());
        card1 = new Card("Two","Clubs");
        assertEquals(2,card1.getValue());
        card1 = new Card("Three","Spades");
        assertEquals(3,card1.getValue());
        card1 = new Card("Four","Diamonds");
        assertEquals(4,card1.getValue());
        card1 = new Card("Five","Hearts");
        assertEquals(5,card1.getValue());
        card1 = new Card("Six","Clubs");
        assertEquals(6,card1.getValue());
        card1 = new Card("Seven","Spades");
        assertEquals(7,card1.getValue());
        card1 = new Card("Eight","Diamonds");
        assertEquals(8,card1.getValue());
        card1 = new Card("Nine","Hearts");
        assertEquals(9,card1.getValue());
        card1 = new Card("Ten","Clubs");
        assertEquals(10,card1.getValue());
        card1 = new Card("Jack","Spades");
        assertEquals(11,card1.getValue());
        card1 = new Card("Queen","Diamonds");
        assertEquals(12,card1.getValue());
        card1 = new Card("King","Diamonds");
        assertEquals(13,card1.getValue());
    }
    
    
    @Test
    public void TestCardToString()
    {
        Card card1 = new Card("Ace","Hearts");
        assertEquals("Ace of Hearts", card1.toString());
        card1 = new Card("Two","Clubs");
        assertEquals("Two of Clubs", card1.toString());
        card1 = new Card("Three","Spades");
        assertEquals("Three of Spades",card1.toString());
        card1 = new Card("Four","Diamonds");
        assertEquals("Four of Diamonds",card1.toString());
        card1 = new Card("Five","Hearts");
        assertEquals("Five of Hearts",card1.toString());
        card1 = new Card("Six","Clubs");
        assertEquals("Six of Clubs",card1.toString());
        card1 = new Card("Seven","Spades");
        assertEquals("Seven of Spades",card1.toString());
        card1 = new Card("Eight","Diamonds");
        assertEquals("Eight of Diamonds",card1.toString());
        card1 = new Card("Nine","Hearts");
        assertEquals("Nine of Hearts",card1.toString());
        card1 = new Card("Ten","Clubs");
        assertEquals("Ten of Clubs",card1.toString());
        card1 = new Card("Jack","Spades");
        assertEquals("Jack of Spades",card1.toString());
        card1 = new Card("Queen","Diamonds");
        assertEquals("Queen of Diamonds",card1.toString());
        card1 = new Card("King","Hearts");
        assertEquals("King of Hearts",card1.toString());

    }
    //Deck Test Methods
    @Test
    public void TestAllCardsInDeck()
    {
        Deck d = new Deck();
        ArrayList<Card> theDeck = d.getDeck();
        for (int i= 0; i < 52; i++)
        {
            Card c = theDeck.get(i);
            for (int j = 0; j< master.size(); j++)
            {
                if (master.get(j).getRank().equals(c.getRank()) &&
                master.get(j).getSuit().equals(c.getSuit()) &&
                master.get(j).getValue()==c.getValue())
                {
                    master.remove(j);
                    j=master.size();
                }
            }
        }
        assertEquals(0,master.size());
    }

    @Test
    public void testShuffleDeck()
    {
        //Two decks, should be identical to start with
        Deck d = new Deck();
        Deck orig = new Deck();
        d.shuffleDeck();
        ArrayList<Card> shufDeck = d.getDeck();
        ArrayList<Card> origDeck = orig.getDeck();
        int count = 0;
        for (int i= 0; i < 52; i++)
        {
            Card c = shufDeck.get(i);
            if (origDeck.get(i).getRank().equals(c.getRank()) &&
            origDeck.get(i).getSuit().equals(c.getSuit()) &&
            origDeck.get(i).getValue()==c.getValue())
            {
                count ++;
            }
        }
        assertTrue(count <= 3);
    }
    @Test
    public void TestGetCard()
    {
        Deck d = new Deck();
        ArrayList<Card> deck = d.getDeck();
        Card test = deck.get(0);
        Card dealt = d.getCard();
        assertEquals(test.toString(),dealt.toString());
        test = deck.get(0);
        dealt = d.getCard();
        assertEquals(test.toString(),dealt.toString());
        test = deck.get(0);
        dealt = d.getCard();
        assertEquals(test.toString(),dealt.toString());
    }
    @Test
    public void TestGetCardsLeft()
    {
        Deck d = new Deck();
        assertEquals(52,d.getCardsLeft());
        Card test = d.getCard();
        assertEquals(51,d.getCardsLeft());
        test = d.getCard();
        assertEquals(50,d.getCardsLeft());
        test = d.getCard();
        assertEquals(49,d.getCardsLeft());
        test = d.getCard();
        assertEquals(48,d.getCardsLeft());
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

