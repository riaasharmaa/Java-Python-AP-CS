// ****************************************************************
// Square.java
//
// Define a Square class with methods to create and read in
// info for a square matrix and to compute the sum of a row,
// a col, either diagonal, and whether it is magic.
//          
// ****************************************************************
import java.io.*;
import java.util.Scanner;

public class Square
{
    int[][] square;
    //--------------------------------------
    //create new square from a data file
    //--------------------------------------
    public Square(String filename) throws IOException
    {
        square = readSquare(filename);
    }

    //-----------------------------------
    //return size of the square
    //-----------------------------------
    public int size()
    {
        return square.length;
    }
    //--------------------------------------
    //return the sum of the values in the given row
    //--------------------------------------
    public int sumRow(int row)
    {
        int RSum=0;
        for(int c = 0; c< square.length; c++)
        {
            RSum +=square[row][c];
        }  
        return RSum;
    }

    //--------------------------------------
    //return the sum of the values in the given column
    //--------------------------------------
    public int sumCol(int col)
    {
        int RCol=0;
        for(int r = 0; r< square[col].length; r++)
        {
            RCol+= square[r][col];
        }  
        return RCol;
    }

    //--------------------------------------
    //return the sum of the values in the main diagonal
    //--------------------------------------
    public int sumMainDiag()
    {
        int RDai=0;
        for(int d = 0; d< square.length; d++)
        {
            RDai+= square[d][d];
        }
        return RDai;
    }

    //--------------------------------------
    //return the sum of the values in the other ("reverse") diagonal
    //--------------------------------------
    public int sumOtherDiag()
    {
        int RDai=0;
        for(int d = 0; d< square[0].length; d++)
        {
            RDai+= square[d][square[0].length-1-d];
        }
        return RDai;
    }

    //--------------------------------------
    //return true if the square is magic (all rows, cols, and diags have
    //same sum), false otherwise
    //--------------------------------------
    /*# Algorithm for method magic() goes here
     *
     */
    public boolean magic()
    {
        int sumRow=0;
        int sumCol=0;
        for(int s=0; s<square.length; s++)
        {
           sumRow+=sumRow(s);
        }
        for(int sc=0; sc<square.length; sc++)
        {
           sumCol+=sumCol(sc);
        }
        if((sumCol+sumRow+sumMainDiag()+sumOtherDiag())/(square.length + square.length + 2)==sumCol(square.length-2)&&(sumCol+sumRow+sumMainDiag()+sumOtherDiag())/(square.length + square.length + 2)==sumOtherDiag())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //--------------------------------------
    //read info into the square from a file
    //--------------------------------------
    public int[][] readSquare(String fileName) throws IOException
    {
        Scanner scan = new Scanner (new File(fileName));
        int size = scan.nextInt();
        int [][] readSquare = new int[size][size];
        for (int row = 0; row < readSquare.length; row++)
            for (int col = 0; col < readSquare.length; col ++)
                readSquare[row][col] = scan.nextInt();
        return readSquare;
    }

    //--------------------------------------
    //print the contents of the square, neatly formatted
    // MUST BE DONE USING A FOR-EACH LOOP!
    //--------------------------------------
    public void printSquare()
    {
        for(int r=0; r<square.length; r++)
        {
            for(int p : square[r])
            {
                System.out.print(p + " ");
            }
            System.out.println();
        }
    }

}
