import java.util.ArrayList;
import java.util.*;
/**
 * Write a description of class Hand here.
 * 
 * @author Mr. Gumminger
 * @version (2021)
 */
public class Hand
{
    private ArrayList<Card> myHand;
    public int[] totalNumber = new int[15];
    
    public Hand()
    {
        myHand = new ArrayList<Card>();
    }
    //return the top card
    public Card getCard ()
    {
        return myHand.remove(0);
    }
    //returns a copy of the card at position x, does not remove it
    public Card getCard(int x)
    {
        return myHand.get(x);
    }
    //returns the number of cards currently in the hand
    public int getHandSize()
    {
        return myHand.size();
    }
    //add a card to the hand
    public void addCard(Card c)
    {
        myHand.add(c);
        for (int i = 0; i < myHand.size(); i++)
        {
            Card min = myHand.get(i);
            int valueMin = myHand.get(i).getValue();
            int index = i;
            for (int x = i+1; x < myHand.size(); x++)
            {
                if (myHand.get(x).getValue() < valueMin)
                {
                    min = myHand.get(x);
                    valueMin = myHand.get(x).getValue();
                    index = x;
                }
            }
            Card position = myHand.get(i);
            myHand.set(i, min);
            myHand.set(index, position);
        }
        totalNumber[c.getValue()]+=1;
    }
    public Card discardCard(int index)
    {
        Card removedCard = myHand.get(index);
        myHand.remove(index);
        int removedValue = removedCard.getValue();
        totalNumber[removedValue]-=1;
        return removedCard;
    }
    public boolean checkRoyal()
    {
        int jack = 0;
        int queen = 0;
        int king = 0;
        int ace = 0;
        int ten = 0;
        for (int i = 0; i < 5; i++)
        {
          if (myHand.get(i).getRank() == "Jack") 
          {
              jack = jack + 1;
          }
          if (myHand.get(i).getRank() == "Queen") 
          {
              queen = queen + 1;
          }
          if (myHand.get(i).getRank() == "King") 
          {
              king= king + 1;
          }
          if (myHand.get(i).getRank() == "Ace") 
          {
              ace= ace + 1;
          }
          if (myHand.get(i).getRank() == "Ten") 
          {
              ten= ten + 1;
          }
        }  
        if ((jack == 1) && (queen == 1) && (king == 1) && (ace == 1)
        && (ten == 1))
        {
            return true;
        }
        return false;
    }
    public boolean checkFlush()
    {
        int count = 0;
        for (int i = 0; i < 4; i++) 
        {
            if (myHand.get(i).getSuit() == myHand.get(i+1).getSuit())
            {
                count++;
            }
        }
        if (count == 4)
        {
            return true;
        }
        return false;
    }
    public boolean checkStraight()
    {
        int count = 0;
        for (int i = 0; i < 4; i++)
        {
            if (myHand.get(i).getValue() + 1 == myHand.get(i+1).getValue())
            {
                count++;
            }
        }
        if (count == 4)
        {
            return true;
        }
        return false;
    }
    public void printHand()
    {
        int num = 1;
        for(int i = 0; i < myHand.size(); i++) 
        {   
            System.out.println(num + ". " + myHand.get(i).toString());
            num = num + 1;
        } 
    }
    public int numberOfAKind()
    {
        int max = totalNumber[0];
        for (int j = 0; j <= 14; j++)
        {
            if (totalNumber[j] > max)
            {
                max = totalNumber[j];
            }
        }
        return max;
    }
    public boolean checkFullHouse()
    {
        for (int j = 0; j <= 14; j++)
        {
            if (totalNumber[j] == 3)
            {
                for (int k = j+1; k<= 14; k++)
                {
                    if (totalNumber[k] == 2)
                    {
                        return true;
                    }
                }
           }
           if (totalNumber[j] == 2)
            {
                for (int k = j+1; k<= 14; k++)
                {
                    if (totalNumber[k] == 3)
                    {
                        return true;
                    }
                }
           }
        }
        return false;
    }
    public boolean checkTwoPair()
    {
        for (int j = 0; j <= 14; j++)
        {
            if (totalNumber[j] == 2)
            {
                for (int k = j+1; k<= 14; k++)
                {
                    if (totalNumber[k] == 2)
                    {
                        return true;
                    }
                }
           }
        }
        return false;
    }
    public int checkBestHand()
    {
        int bestHand = 0;
        if ((checkRoyal() == true) && (checkFlush() == true))
        {
            bestHand = 1;
            System.out.println("You have a Royal Flush!");
            return bestHand;
        }
        if ((checkStraight() == true) && (checkFlush() == true))
        {
            bestHand = 2;
            System.out.println("You have a Straight Flush!");
            return bestHand;
        }
        if (numberOfAKind() == 4)
        {
            bestHand = 3;
            System.out.println("You have 4 of a Kind!");
            return bestHand;
        }
        if (checkFullHouse() == true)
        {
            bestHand = 4;
            System.out.println("You have a Full House!");
            return bestHand;
        }
        if (checkFlush() == true)
        {
            bestHand = 5;
            System.out.println("You have a Flush!");
            return bestHand;
        }
        if (checkStraight() == true)
        {
            bestHand = 6;
            System.out.println("You have a Straight!");
            return bestHand;
        }
        if (numberOfAKind() == 3)
        {
            bestHand = 7;
            System.out.println("You have 3 of a Kind!");
            return bestHand;
        }
        if (checkTwoPair() == true)
        {
            bestHand = 8;
            System.out.println("You have 2 Pairs!");
            return bestHand;
        }
        if (numberOfAKind() == 2)
        {
            bestHand = 9;
            System.out.println("You have 1 Pair!");
            return bestHand;
        }
        else 
        {
            System.out.println("You have a High Card!");
            return 10;
        }
    }
    /*# The following method is for testing purposes. It should
     * not be changed. It will compile when the totalNumber
     * instance variable has been added.
     */
    public String totalNumber()
    {
        String s = "";
        for (int i: totalNumber)
            s += i;
        return s;
    }
}
