// ******************************************************************
//   BaseConversion.java
//
//   Recursively converts an integer from base 10 to another base
// ******************************************************************

import java.util.Scanner;

public class BaseConversion
{
    public static void main (String[] args)
    {
        int base10Num;
        int base;

        Scanner scan = new Scanner(System.in);

        System.out.println ();
        System.out.println ("Base Conversion Program");
        System.out.print ("Enter an integer: ");
        base10Num = scan.nextInt();
        System.out.print ("Enter the base: ");
        base = scan.nextInt();

        // Call convert and print the answer
        System.out.println(convert(base10Num, base));
    }
    // --------------------------------------------------
    //   Converts a base 10 number to another base.
    // -------------------------------------------------- 
    public static String convert (int num, int b)
    {

        int quotient;  // the quotient when num is divided by base b
        int remainder; // the remainder when num is divided by base b

        quotient = num/b;

        remainder = num%b;

        if (quotient == 0)  //base case check goes here
        {
          if (remainder == 10)
            {
                return "A"; 
            }
            else if (remainder == 11)
            {
                return "B";
            }
            else if (remainder == 12)
            {
                return "C";
            }
            else if (remainder == 13)
            {
                return "D";
            }
            else if (remainder == 14)
            {
                return "E";
            }
            else if (remainder == 15)
            {
                return "F";
            }
            return ("" + remainder);    
        }
        else
        {
            // Recursive step: call convert again using the quotient
            // from above. Add the result to the remainder above
            // before returning
            if (remainder == 10)
            {
                return (convert(quotient, b) + "A");
            }
            if (remainder == 11)
            {
                return (convert(quotient, b) + "B");
            }
            if (remainder == 12)
            {
                return (convert(quotient, b) + "C");
            }
            if (remainder == 13)
            {
                return (convert(quotient, b) + "D");
            }
            if (remainder == 14)
            {
                return (convert(quotient, b) + "E");
            }
            if (remainder == 15)
            {
                return (convert(quotient, b) + "F");
            }
            return (convert(quotient, b) + remainder);
        }

    }
}