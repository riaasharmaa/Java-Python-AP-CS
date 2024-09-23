import java.util.ArrayList;
import java.util.Scanner;
/**
 * Write a description of class Game here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Game
{
    public static void main (String[] args)
    {
        Deck d1 = new Deck();
        d1.shuffleDeck();
        System.out.println("Shuffling...");
        Hand h1 = new Hand();
        Hand h2 = new Hand();
        System.out.println("Dealing...");
        for (int i = 0; i < 5; i++)
        {
            h1.addCard(d1.getCard());
            h2.addCard(d1.getCard());
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Ready! Hit Enter to continue.");
        sc.nextLine();
        System.out.println("--------------------------------");
        System.out.println("Player 1's Hand");
        h1.printHand();
        System.out.println("--------------------------------");
        System.out.println("Player 1 - How many cards do you want to discard? ");
        int numDiscard1 = sc.nextInt();
        while (numDiscard1 > 0)
        {
            System.out.println("Which card do you want to discard? (1,2,3,4,5) ");
            int numCardDiscard1 = sc.nextInt();
            numCardDiscard1 = numCardDiscard1 - 1;
            h1.discardCard(numCardDiscard1);
            h1.printHand();
            numDiscard1 = numDiscard1 - 1;
        }
        System.out.println("--------------------------------");
        System.out.println("Player 2's Hand");
        h2.printHand();
        System.out.println("--------------------------------");
        System.out.println("Player 2 - How many cards do you want to discard? ");
        int numDiscard2 = sc.nextInt();
        while (numDiscard2 > 0)
        {
            System.out.println("Which card do you want to discard? (1,2,3,4,5) ");
            int numCardDiscard2 = sc.nextInt();
            numCardDiscard2 = numCardDiscard2 - 1;
            h2.discardCard(numCardDiscard2);
            h2.printHand();
            numDiscard2 = numDiscard2 - 1;
        }
        int p1 = h1.getHandSize();
        int p2 = h2.getHandSize();
        while(p1!=5)
        {
            h1.addCard(d1.getCard());
            p1 = h1.getHandSize();
        }
        while(p2!=5)
        {
            h2.addCard(d1.getCard());
            p2 = h2.getHandSize();
        }
        System.out.println("--------------------------------");
        System.out.println("Hit Enter to Continue:");
        sc.nextLine();
        System.out.println("--------------------------------");
        System.out.println("Player 1's Hand");
        h1.printHand();
        System.out.println("Player 2's Hand");
        h2.printHand();
        System.out.println("--------------------------------");
        System.out.println("Player 1's Results");
        int p1Score = h1.checkBestHand();
        System.out.println("--------------------------------");
        System.out.println("Player 2's Results");
        int p2Score = h2.checkBestHand();
        System.out.println("--------------------------------");
        System.out.println("And the winner is:");
        if(p1Score > p2Score)
        {
            System.out.println("Player 2 wins!");
        }
        else if(p1Score == p2Score)
        {
            System.out.println("Tie");
        }
        else
        {
            System.out.println("Player 1 wins!");
        }
    }
}
