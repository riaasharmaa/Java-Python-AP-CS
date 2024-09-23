// ******************************************************************
//   TestFib.java
//
//   A simple driver that uses the Fib class to compute the
//   nth element of the Fibonacci sequence.
// ******************************************************************

import java.util.Scanner;

public class TestFib
{
    public static void main(String[] args)
    {
        int n, fib;

        Scanner scan = new Scanner (System.in);

        System.out.print("Enter an integer: ");
        n = scan.nextInt();

        long begin = System.currentTimeMillis();
        fib = Fib.fib1(n);
        long end = System.currentTimeMillis();
        System.out.println("Fib1(" + n + ") is " + fib);
        System.out.println("time: " + (end - begin) +"ms");
        
        /** uncomment the code below for part 3 of the project **/
        //begin = System.currentTimeMillis();
        //fib = Fib.fib2(n);
        //end = System.currentTimeMillis();
        //System.out.println("Fib1(" + n + ") is " + fib);
        //System.out.println("time: " + (end - begin) +"ms");
    }
}


