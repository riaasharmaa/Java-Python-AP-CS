import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class AccountTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class AccountTest
{
    /**
     * Default constructor for test class AccountTest
     */
    public AccountTest()
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

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testChargeFee()
    {
        Account account1 = new Account(102.30, "Katherine");
        assertEquals(92.30, account1.chargeFee(10), 0.001);
    }

    @Test
    public void testConstructorAndGetters()
    {
        Account account1 = new Account(102.30, "Katherine",12345678);
        assertEquals(102.30, account1.getBalance(), 0.001);
        assertEquals(12345678, account1.getAcctNumber());
    }
    
    @Test
    public void testChangeName()
    {
        Account account1 = new Account(102.30, "Katherine",12345678);
        account1.changeName("Srikanth");
        assertTrue(account1.toString().indexOf("Srikanth") > 0);
        assertTrue(account1.toString().indexOf("Katherine") < 0);
    }
    
    @Test
    public void testDeposit()
    {
        Account account1 = new Account(102.30, "Katherine");
        int nd = Account.getNumDeposits();
        double ad = Account.getAmountDeposits();
        account1.deposit(18.03);
        assertEquals(120.33, account1.getBalance(), 0.001);
        assertEquals(nd+1,Account.getNumDeposits());
        assertEquals(ad+18.03, Account.getAmountDeposits(), 0.001);
    }
    
    @Test
    public void testWithdraw()
    {
        Account account1 = new Account(102.30, "Katherine");
        double aw = Account.getAmountWithdrawls();
        int nw =Account.getNumWithdrawls();
        account1.withdraw(12.03);
        assertEquals(90.27, account1.getBalance(), 0.001);
        assertEquals(nw+1,Account.getNumWithdrawls());
        assertEquals(aw+12.03, Account.getAmountWithdrawls(), 0.001);
    }
    
    @Test
    public void testWithdrawFail()
    {
        Account account1 = new Account(102.30, "Katherine");
        double aw = Account.getAmountWithdrawls();
        int nw =Account.getNumWithdrawls();
        account1.withdraw(120.03);
        assertEquals(102.30, account1.getBalance(), 0.001);
        assertEquals(nw,Account.getNumWithdrawls());
        assertEquals(aw, Account.getAmountWithdrawls(), 0.001);
    }
    
    @Test
    public void testGetNumAccounts()
    {
        int num = Account.getNumAccounts();
        Account account1 = new Account(110.33, "Casey");
        assertEquals(num+1, Account.getNumAccounts());
        Account account2 = new Account (250.87, "Jones", 1234567);
        assertEquals(num+2, Account.getNumAccounts());
    }

    @Test
    public void testClose()
    {
        int num = Account.getNumAccounts();
        Account account1 = new Account(23.45, "Matt");
        account1.close();
        assertEquals(0.0, account1.getBalance(), 0.001);
        assertTrue(account1.toString().indexOf("CLOSED") > 0);
        assertTrue(account1.toString().indexOf("Matt") > 0);
        assertEquals(num, Account.getNumAccounts());
    }

    @Test
    public void testConsolidate()
    {
        Account account1 = new Account(112.34, "Justin");
        Account account2 = new Account(20001.12, "Justin");
        Account account3 = new Account(20113.46, "Justin");
        assertEquals(account3.getBalance(), (Account.consolidate(account1, account2)).getBalance(),0.001);
        assertTrue(account1.toString().indexOf("CLOSED") > 0);
        assertTrue(account2.toString().indexOf("CLOSED") > 0);
    }

    @Test
    public void testConsolidate2()
    {
        Account account1 = new Account(35.00, "Carter");
        Account account2 = new Account(123.00, "Ryan");
        assertEquals(null, Account.consolidate(account1, account2));
    }

    @Test
    public void testConsolidate3()
    {
        Account account1 = new Account(11.90, "Alvin");
        assertEquals(null, Account.consolidate(account1, account1));
    }


    @Test
    public void testGetNumDeposits()
    {
        int d = Account.getNumDeposits();
        Account account1 = new Account(12.01, "Caleb");
        account1.deposit(0.01);
        account1.deposit(12.02);
        assertEquals(d+2, Account.getNumDeposits());
    }
    
    @Test
    public void testGetAmtDeposits()
    {
        double a = Account.getAmountDeposits();
        Account account1 = new Account(12.01, "Caleb");
        account1.deposit(0.01);
        account1.deposit(12.02);
        assertEquals(a+12.03, Account.getAmountDeposits(), 0.001);
    }

    @Test
    public void testGetNumwithdrawals()
    {
        int w =Account.getNumWithdrawls();
        Account account1 = new Account(12.01, "Riley");
        account1.withdraw(0.01);
        account1.withdraw(10.00);
        assertEquals(w+2, Account.getNumWithdrawls());
        account1.withdraw(100000.00);
        assertEquals(w+2, Account.getNumWithdrawls());
    }
    
    @Test
    public void testGetAmtwithdrawals()
    {
        double w = Account.getAmountWithdrawls();
        Account account1 = new Account(12.01, "Riley");
        account1.withdraw(0.01);
        account1.withdraw(10.00);
        assertEquals(w+10.01, Account.getAmountWithdrawls(), 0.001);
        account1.withdraw(100000.00);
        assertEquals(w+10.01, Account.getAmountWithdrawls(), 0.001);
    }

    @Test
    public void testTransfer()
    {
        Account account1 = new Account(123.45, "Lena");
        Account account2 = new Account(200.00, "Michael");
        double aw = Account.getAmountWithdrawls();
        int nw =Account.getNumWithdrawls();
        int nd = Account.getNumDeposits();
        double ad = Account.getAmountDeposits();
        account1.transfer(account2, 10.00);
        assertEquals(210.0, account2.getBalance(), 0.001);
        assertEquals(113.45, account1.getBalance(), 0.001);
        assertEquals(nw+1,Account.getNumWithdrawls());
        assertEquals(nd+1,Account.getNumDeposits());
        assertEquals(aw+10, Account.getAmountWithdrawls(), 0.001);
        assertEquals(ad+10, Account.getAmountDeposits(), 0.001);
    }
    
    @Test
    public void testTransferFail()
    {
        Account account1 = new Account(123.45, "Lena");
        Account account2 = new Account(200.00, "Michael");
        double aw = Account.getAmountWithdrawls();
        int nw =Account.getNumWithdrawls();
        int nd = Account.getNumDeposits();
        double ad = Account.getAmountDeposits();
        account1.transfer(account2, 1000.00);
        assertEquals(200.0, account2.getBalance(), 0.001);
        assertEquals(123.45, account1.getBalance(), 0.001);
        assertEquals(nw,Account.getNumWithdrawls());
        assertEquals(nd,Account.getNumDeposits());
        assertEquals(aw, Account.getAmountWithdrawls(), 0.001);
        assertEquals(ad, Account.getAmountDeposits(), 0.001);
    }
    
    @Test
    public void testStaticTransfer()
    {
        Account account1 = new Account(123.45, "Lena");
        Account account2 = new Account(200.00, "Michael");
        double aw = Account.getAmountWithdrawls();
        int nw =Account.getNumWithdrawls();
        int nd = Account.getNumDeposits();
        double ad = Account.getAmountDeposits();
        Account.transfer(account1,account2, 10.00);
        assertEquals(210.0, account2.getBalance(), 0.001);
        assertEquals(113.45, account1.getBalance(), 0.001);
        assertEquals(nw+1,Account.getNumWithdrawls());
        assertEquals(nd+1,Account.getNumDeposits());
        assertEquals(aw+10, Account.getAmountWithdrawls(), 0.001);
        assertEquals(ad+10, Account.getAmountDeposits(), 0.001);
    } 
    
    @Test
    public void testStaticTransferFail()
    {
        Account account1 = new Account(123.45, "Lena");
        Account account2 = new Account(200.00, "Michael");
        double aw = Account.getAmountWithdrawls();
        int nw =Account.getNumWithdrawls();
        int nd = Account.getNumDeposits();
        double ad = Account.getAmountDeposits();
        Account.transfer(account1,account2, 1000.00);
        assertEquals(200.0, account2.getBalance(), 0.001);
        assertEquals(123.45, account1.getBalance(), 0.001);
        assertEquals(nw,Account.getNumWithdrawls());
        assertEquals(nd,Account.getNumDeposits());
        assertEquals(aw, Account.getAmountWithdrawls(), 0.001);
        assertEquals(ad, Account.getAmountDeposits(), 0.001);
    } 
}










