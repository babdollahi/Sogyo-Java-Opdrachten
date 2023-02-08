
import java.io.*;
import java.util.Scanner;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class fractionalCalculation 
{
    private static final DecimalFormat toDecimalNotation = new DecimalFormat("0.00000");

    public static String Fraction( double numerator, double denominator )   
    {  
        String f;  
        String numeratorStr = String.valueOf(numerator).split("\\.")[0];
        String denominatorStr = String.valueOf(denominator).split("\\.")[0];

        f =  ('\u0022' + numeratorStr +"/" + denominatorStr + '\u0022');
        return f; 
    } 

//Fraction add(int number) where n is integer to be added 
    public static int addFraction(int toAdd, int numerator, int denominator )   
    {  
        int s;  
        s = (toAdd* denominator) + numerator;
        return s; 
    }  


    public static void main(String args[])
    {
        //Read numerator and a denominator in double
        double n2,n1,d1,res= 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the numerator : ");
        n1 = input.nextDouble();
        System.out.println("Enter the denominator : ");
        d1 = input.nextDouble();
        //Calculate the fraction
        res=n1/d1;
        System.out.println("The fraction in decimal notation is :"+ toDecimalNotation.format(res));
        System.out.println();

        //string toString(): 
        System.out.println("The fraction in string is :" + Fraction(n1,d1));

        Scanner inputAdd = new Scanner(System.in);
        System.out.println("Enter a number to addd to the fraction: ");
        n2 = inputAdd.nextDouble();

        //string toString(): 
        System.out.println("The new fraction is :" + Fraction(addFraction((int) n2, (int) n1 , (int) d1), d1));




    }

}
