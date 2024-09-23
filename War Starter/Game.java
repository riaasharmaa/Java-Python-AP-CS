import java.util.ArrayList;
import java.util.Scanner;
/**
 * The card game "War"
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game
{
    public static void main (String[] args)
    {
      int PlayerScore = 0;
      int ComputerScore = 0;
      Deck deck = new Deck();
      deck.shuffleDeck();
      System.out.println("Shuffling...");
      Hand playerHand = new Hand();
      Hand computerHand = new Hand();
      System.out.println("Dealing...");
      for(int i = 0; i < 52; i++)
        {
            if(i%2==0)
            {
                playerHand.addCard(deck.getCard());
            }
            else 
            {
                computerHand.addCard(deck.getCard());
            }
        }
      Scanner scanner = new Scanner(System.in);
      System.out.println("Ready! Hit ENTER to continue.");
      scanner.nextLine();
      ArrayList<Card> table = new ArrayList<Card>(); 
      while ((playerHand.getHandSize() >= 1) && (computerHand.getHandSize() >= 1))
      {
          Card playerTopCard = playerHand.getTop();
          System.out.println("Player's top card is " + playerTopCard.toString());
          Card computerTopCard = computerHand.getTop();
          System.out.println("Computer's top card is " + computerTopCard.toString());
          ArrayList <Card> Table = new ArrayList <Card>();
          Table.add(playerTopCard);
          Table.add(computerTopCard);
          int playerTopValue = playerTopCard.getValue();
          int computerTopValue = computerTopCard.getValue();
          if (playerTopValue == computerTopValue)
          {
              for (int y = 0; y < 3; y++)
              {
                Card newplayerCard = playerHand.getCard();
                Table.add(newplayerCard);
                Card newcomputerCard = computerHand.getCard();
                Table.add(newplayerCard);
              }
              Card playerCompCard = playerHand.getCard();
              Table.add(playerCompCard);
              Card computerCompCard = computerHand.getCard();
              Table.add(computerCompCard);
              int playerCompValue = playerCompCard.getValue();
              int computerCompValue = computerCompCard.getValue();
              for(int i = 0; i < Table.size(); i++) 
              {   
                  System.out.println(Table.get(i));
              }  
              if (playerCompValue > computerCompValue)
              {
                  System.out.println("Player wins this round!");
                  PlayerScore++;
                  for(int i = 0; i < Table.size(); i++) 
                  {   
                      Card tableCard = Table.get(i);
                      playerHand.addCard(tableCard);
          
                  }  
                  Table.clear();
              }
              if (computerCompValue > playerCompValue)
              {
                  System.out.println("Computer wins this round!");
                  ComputerScore++;
                  for(int i = 0; i < Table.size(); i++) 
                  {   
                     Card tableCard = Table.get(i);
                     computerHand.addCard(tableCard);
                  }  
                  Table.clear();
              }
            }
            else if (playerTopValue > computerTopValue)
            {
                System.out.println("Player wins this round!");
                PlayerScore++;
                for(int i = 0; i < Table.size(); i++) 
                {   
                    Card tableCard = Table.get(i);
                    playerHand.addCard(tableCard);
                }  
                Table.clear();
            }
            else if (computerTopValue > playerTopValue)
            {
                System.out.println("Computer wins this round!");
                ComputerScore++;
                for(int i = 0; i < Table.size(); i++) 
                {   
                    Card tableCard = Table.get(i);
                    computerHand.addCard(tableCard);
                }  
                Table.clear();
            }
            int endPlayerHand = playerHand.getHandSize();
            System.out.println("Player has " + endPlayerHand + " cards after this round.");
            int endComputerHand = computerHand.getHandSize();
            System.out.println("Computer has " + endComputerHand + " cards after this round.");
            System.out.println("Hit ENTER to go on to the next round.");
            scanner.nextLine();
        }
        if (PlayerScore > ComputerScore)
        {
            System.out.println("Player Wins!");
        }
        if (PlayerScore < ComputerScore)
        {
            System.out.println("Computer Wins!");
        }
        if (PlayerScore == ComputerScore)
        {
            System.out.println("Tie!");
        }
    }
  }

