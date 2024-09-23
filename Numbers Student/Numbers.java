import java.util.ArrayList;
/**
 * @author (your name)
 * @version (a version number or a date)
 */
public class Numbers
{
    /*# 
     * 1. Create one instance variable. An array list of 
     * integers called nums. You should declare the variable
     * here, but do not instantiate it (no "= new...")
     */
    
    private ArrayList<Integer> nums;

    /*# 
     * 2. Write the parameterized constructor 
     */
    public Numbers (ArrayList<Integer> list)
    {
        nums=list;
    }

    /*# 
     * 3. Write an overloaded constructor that takes a single integer
     * parameter. This parameter indicates how big to make the 
     * ArrayList. Fill the ArrayList with multiples of 5 starting
     * at 5. Don't forget to instantiate the instance variable!
     */
    public Numbers(int size)
    {
        nums = new ArrayList<Integer>();
        for(int i = 0; i<size;i++)
        {
            nums.add(5*(i+1));
        }
    }

    /*# 
     * 4. Write method getNums - a getter for the instance variable.
     */
    public ArrayList<Integer> getNums()
    {
        return nums;
    }

    /*# 
     * 5. Write method removeEven that deletes every even number from the
     * ArrayList. This method takes no parameters and returns a count of 
     * how many items have been removed.
     */
    public int removeEven()
    {
        int removeAmt = 0;
        for(int i = 0; i<nums.size();i++)
        {
            if(nums.get(i)%2==0)
            {
                nums.remove(i);
                i = i -1;
                removeAmt++;
            }
        }
        return removeAmt;
    }

    /*# 
     * 6. Write method findMaxLocation which takes no parameters and 
     * returns the index of the largest value in nums. Use a regular
     * for-loop for this method.
     */
    public int findMaxLocation()
    {
        int max = nums.get(0);
        int maxL = 0;
        for(int i = 0; i < nums.size(); i++)
        {
            if(nums.get(i)>max)
            {
                max = nums.get(i);
                maxL = i;
            }
        }
        return maxL;
    }

    /*# 
     * 7. Write method getSum which takes no parameters and returns the
     * sum of the values in nums. Use a for-each loop for this method.
     */
    public int getSum()
    {
        int sum = 0;
        for(int i: nums)
        {
            sum+= i;
        }
        return sum;
    }

    /*# 
     * 8. Write method addNegatives.  This method takes no inputs and 
     * return nothing.  It inserts the number -1 at the start of the list and -100 
     * at the end of the list. Then it changes whatever is at index 3 to be -999.
     * For example, if the list started with [2, 4, 6, 7], the list would change
     * to be [-1, 2, 4, -999, 7, -100] after this method was called.
     * You can assume the list size will always be large enough not to cause
     * outOfBoundsExceptions on this part.
     */
    public void addNegatives()
    {
        nums.add(0,-1);
        nums.add(-100);
        nums.set(3, -999);
    }
    
    public String toString()
    {
        return nums.toString();
    }
}
