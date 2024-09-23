//*******************************************************$***
// Account.java
//
// A bank account class with methods to deposit to, withdraw from,
// change the name on, charge a fee to, and print a summary of the account.
//*******************************************************
public class Account
{
    private double balance;
    private String name;
    private int acctNum;
    private static int numAccounts = 0;
    private static int numDeposits = 0;
    private static double amountDeposits = 0;
    private static int numWithdrawls = 0;
    private static double amountWithdrawls = 0;
    public Account(double initBal, String owner)
    {
        balance = initBal;
        name = owner;
        acctNum = (int) (Math.random() * Integer.MAX_VALUE);
        numAccounts += 1;
    }
    //----------------------------------------------
    //Constructor -- initializes balance, owner, and account number
    //----------------------------------------------
    public Account(double initBal, String owner, int number)
    {
        balance = initBal;
        name = owner;
        acctNum = number;
        numAccounts += 1;
    }
    public static int getNumAccounts()
    {
        return numAccounts;
    }
    public int getAcctNumber()
    {
        return acctNum;
    }
    public String getName()
    {
        return name;
    }
    public static int getNumWithdrawls()
    {
        return numWithdrawls;
    }
    public static int getNumDeposits()
    {
        return numDeposits;
    }
    public static double getAmountDeposits()
    {
        return amountDeposits;
    }
    public static double getAmountWithdrawls()
    {
        return amountWithdrawls;
    }
    //----------------------------------------------
    // Checks to see if balance is sufficient for withdrawal.
    // If so, decrements balance by amount; if not, prints message.
    //----------------------------------------------
    public void withdraw(double amount)
    {
        if (balance >= amount)
        {
            balance -= amount;
            numWithdrawls ++;
            amountWithdrawls += amount;
        }
        else
        {
            System.out.println("Insufficient funds");
        }
    }
    //----------------------------------------------
    // Adds deposit amount to balance.
    //----------------------------------------------
    public void deposit(double amount)
    {
        balance += amount;
        numDeposits ++;
        amountDeposits += amount;
    }
    //----------------------------------------------
    // Returns balance.
    //----------------------------------------------
    public double getBalance()
    {
        return balance;
    }
    //----------------------------------------------
    // Returns a string containing the name, account number, and balance.
    //----------------------------------------------
    public String toString()
    {
        return "Name: " + name + "\nAcct #: " + acctNum + "\nBalance: " + balance;
    }
    //----------------------------------------------
    // Deducts $10 service fee
    //----------------------------------------------
    public double chargeFee(double fee)
    {
        balance -= fee;
        return balance;
    }
    //----------------------------------------------
    // Changes the name on the account 
    //----------------------------------------------
    public void changeName(String newName)

    {
        name = newName;
    }
    //----------------------------------------------
    // Write method getAccountNumber 
    //----------------------------------------------
    public int getAccountNumber()
    {
        return acctNum;
    }
    public void close()
    {
        name = name + " CLOSED";
        numAccounts -= 1;
        balance = 0;
    }
    public static Account consolidate(Account acct1, Account acct2)
    {
        if(acct1.getName().equals(acct2.getName()) && acct1.getAccountNumber() != acct2.getAccountNumber())
        {
            Account acct3 = new Account(acct1.getBalance() + acct2.getBalance(), acct1.getName());
            acct2.close();
            acct1.close();
            return acct3;
        }
        else
        {
            System.out.println("INVALID INPUT");
            return null;
        }
    }
    public void transfer(Account acct, double amount)
    {
        if(amount < this.getBalance())
        {
            acct.deposit(amount);
            this.withdraw(amount);
        }
    }
    public static void transfer(Account acct1, Account acct2, double amount)
    {
        acct1.transfer(acct2, amount);
    }
}