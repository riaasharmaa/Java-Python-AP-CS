import java.util.Scanner;
/**
 * Write a description of class TestAccounts2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestAccounts2
{
    public static void main(String [] args)
    {
        Account acct1 = new Account(100, "josh");
        Account acct2 = new Account(100, "Josh");
        Account acct3 = new Account(100, "Josh");
        Account.consolidate(acct1, acct1);
        Account.consolidate(acct1, acct2);
        Account acct4 = Account.consolidate(acct2, acct3);
        acct1.close();
        System.out.println(acct1 + "\n" + acct2 + "\n" + acct3 + "\n" + acct4);
    }
}