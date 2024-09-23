
/**
 * This class can be used to analyze the sales of a group of sales people.
 * You will be completing the methods to find the total sales, average sale, 
 * min and max sale and a generating a report that returns a table with each salesperson's 
 * name and amount of sales.  The more challenging part of this project is 
 * to write the methods that return an array of names that meet certain criteria.
 * These methods include people with sales greater than or equal to a given 
 * amount as well as people that have the maximum sales amounts.
 * 
 * @author Robert Gammelgaard/David Gumminger 
 * @version 20171025
 */
public class SalesAnalyzer
{

    private int[] sales;      //array of the sales amounts for each salesperson
    private String[] names;   // names of the salespeople

    /*# Note that the arrays above will be the same size and have corresponding index values.
     * In other words, the amount of sales for person n will be in sales[n] and the name of that
     * salesperson will be in names[n]. 
     */
    /**
     * Constructor for objects of class SalesForce.
     * @param names is the names of the salespeople.
     * @param sales is the amount of sales for each sales person.
     * Precondition: names and sales must have same length and not null.
     */
    public SalesAnalyzer(String[] names,int[]sales)
    {
        this.names = names;
        this.sales = sales;
    }

    /*#
     * 1. Write the method totalSales
     */
    /**
     * Determines the total amount of sales for salespeople in the object's array
     * 
     * @return  the total sales of all sales people
     */
    public int totalSales()
    {
        int total = 0;
        for (int s : sales)
        {
            total += s;
        }
        return total;
    }
    
    /*#
     * 2. Write the method averageSale
     */
    /**
     * Determines the average sales amount from the salespeople in the object's array
     * 
     * @return  the average of the sales from all sales people
     */
    public double averageSale()
    {
        double total2 = 0.0;
        for (double a : sales)
        {
            total2 += a;
        }
        return total2/sales.length;
    }    

    /*#
     * 3. Write the method maxSale 
     */
    /**
     * Determines the highest sales amount from the salespeople in the object's array
     * 
     * @return  the maximum sales amount from all sales people
     */
    public int maxSale()
    {        
        int largest = sales[0];
        for (int b : sales)
        {
            if (b > largest)
            {
                largest = b;
            }
        }
        return largest;
    }
    /*#
     * 4. Write the method minSale 
     */
    /**
     * Determines the lowest sales amount from the salespeople in the object's array
     * 
     * @return  the minimum sales amount of all sales people
     */
    public int minSale()
    {           
        int smallest = sales[0];
        for (int c : sales)
        {
            if (c < smallest)
            {
                smallest = c;
            }
        }
        return smallest;
    }
    
    /*#
     * 5. Write the method numSalesAtOrAbove
     */
    /**
     * Finds the number of salespeople whose sales were at or above an input value
     * 
     * @param n is the minimum sales amount to be counted   
     * @return  the number of sales amounts that are greater or equal to n.
     */
    public int numSalesAtOrAbove(int n)
    {
        int counter = 0;
        for (int s : sales)
        {
            if (s >= n)
            {
                counter ++;
            }
        }
        return counter; 
    }
    
    /*#
     * 6. Write the method maxSalesPeople
     */
    /** 
     * Finds all salespeople who have the most sales of those in ojbect's array
     * 
     * @return  an array of the names of the salespeople who have the highest sales.
     */
    public String[] maxSalesPeople()
    {   
        int j = 0;
        int maxSales = maxSale();
        int numSales = numSalesAtOrAbove(maxSales);
        String[] salespeople = new String[numSales];
        for (int i = 0; i < names.length; i++)
        {
            if(sales[i] == maxSales)
            {
                salespeople[j] = names[i];
                j++;
            }
        }
        return salespeople;
    }
    /*#
     * 7. Write the method peopleWithSalesAtOrAbove
     */
    /**
     * Finds all salespeople whose sales amount was at or above an input amount
     * 
     * @param n is the minimum sales amount for sales person to be included   
     * @return an array of strings of the names of salespeople that have sales
     *  that are greater than or equal to n.
     */
    public String[] peopleWithSalesAtOrAbove(int n)
    {       
        int k = 0;
        int numSales2 = numSalesAtOrAbove(n);
        String[] salespeople2 = new String[numSales2];
        for (int i = 0; i < names.length; i ++)
        {
            if (sales[i] >= n)
            {
                salespeople2[k] = names[i];
                k++;
            }
        }
        return salespeople2; 
    }
    /*#
     * 8. Complete the report method
     */
    /**
     * Prints a table with all salepeople and their total sales
     * 
     * @return a string that, when printed, creates a table of salespeople and sales amounts.
     */
    public String report()
    {

        String s= "Salesperson   Sales\n"+
            "--------------------\n";
        /*add a loop here to add in the names and sales. Use 2 tabs between the name and
         * the amount of sales */
         for (int i = 0; i < sales.length; i++)
        {
            s += names[i] + "\t\t" + sales[i] + "\n";
        }
        return s;
    }
}
