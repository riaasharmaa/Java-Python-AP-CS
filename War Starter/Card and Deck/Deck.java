import java.util.ArrayList;
import java.util.Random;
/**
 * Deck class
 * @author 
 * @version 
 */
public class Deck
{
    /** Instance variables **/
    ArrayList<Card> deck = new ArrayList<Card>();
    String[] r = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
    String[] s = {"Spades", "Clubs", "Hearts", "Diamonds"};
    /**
     * Constructor  
     */
    public Deck()
    {
        for(int i = 0; i<s.length; i++)
        {
            for(int k = 0; k<r.length;k++){
                Card c = new Card(r[k], s[i]);
                deck.add(c);
            }
        }      
    }
    /**
     * Getters
     */
    public ArrayList getDeck()
    {
        return deck;
    }
    public Card getCard()
    {
        
        return deck.remove(0);
    }
    public int getCardsLeft()
    {
        return deck.size();
    }
    /**
     * Other methods (shuffle, toString, etc)
     */
    public void shuffleDeck()
    {
        Random ra = new Random();
        for(int i = 0; i<deck.size(); i++)
        {
            int random = ra.nextInt(52);
            Card n = deck.get(i);
            deck.remove(i);
            deck.add(random, n); 
        }
        for(int i = 0; i<deck.size(); i++)
        {
            int random = ra.nextInt(52);
            Card n = deck.get(i);
            deck.remove(i);
            deck.add(random, n); 
        }
    }
}
