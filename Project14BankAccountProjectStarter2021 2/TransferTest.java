import java.util.Scanner;
/**
 * Write a description of class TransferTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TransferTest
{
    public static void main(String [] args)
    {
        Account acct1 = new Account(500, "Josh");
        Account acct2 = new Account(500, "josh");
        boolean go = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("Transfer from 1 to 2 (t12), transfer from 2 to 1(t21) or quit (q)?");
        while(go == true)
        {
            System.out.println("Transfer from 1 to 2 (t12), transfer from 2 to 1(t21) or quit (q)?");
            if(sc.nextLine().equals("t12"))
            {
                System.out.println("How much?");
                Account.transfer(acct1, acct2, sc.nextDouble());
            }
            else if (sc.nextLine().equals("t21"))
            {
                System.out.println("How much?");
                Account.transfer(acct2, acct1, sc.nextDouble());
            }
            else if(sc.nextLine().equals("q"))
            {
                go = false;
            }
        }
        System.out.println(acct1);
        System.out.println(acct2);
    }
}