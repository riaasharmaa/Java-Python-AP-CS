import java.util.ArrayList;
/**
 * Write a description of class Hand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hand
{
    /*# WARNING - Be sure to pull your Card and Deck classes in from the prior
     * part of this project. Failure to do so will mean nothing is going to 
     * compile or work!
     */
    //Constructor
    private ArrayList<Card> hand;
    public Hand()
    {
        hand = new ArrayList<Card>();
    }
    //addCard method, adds a card to the end (bottom) of the Hand
    public void addCard(Card newCard)
    {
        hand.add(hand.size(), newCard);
    }
    //getHandSize , returns the number of cards in the Hand
    public int getHandSize()
    {
        return hand.size();
    }
    //getCard, removes and returns the top (first) Card in the Hand
    public Card getCard()
    {
       Card topCard = hand.get(0);
       hand.remove(0);
       return topCard;
    }
    //Optional printHand - prints all the cards in the Hand for testing
    public void printHand()
    {
        for (Card i : hand)
        {
            System.out.println(i);
        }
    }
    //return the top card
    public Card getTop()
    {
       Card topCard1 = hand.get(0);
       return topCard1;
    }
}
