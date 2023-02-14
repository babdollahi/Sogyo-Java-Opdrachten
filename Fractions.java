//Banafsheh Abdollahi wrote this program for the Fractional Calculation assuming having always positive and valid fractions.
import java.util.*;
import java.lang.*;
import java.text.DecimalFormat;


class Fractions {
    int numerator;
    int denominator;
    int gcd;
    static double dNumerator;
    static double dDenominator;
    static double result;

    public Fractions(int numerator, int denominator) 
    {   //Finding the greatest common divisor
        for(int i = 1; i <= numerator && i <= denominator; i++)  
        {  
        //returns true if both conditions are satisfied   
        if(numerator%i==0 && denominator%i==0)  
        //storing the variable i in the variable gcd  
        gcd = i;  
        }
        //Simplify the fractions using gcd
        this.numerator = numerator/gcd;
        this.denominator = denominator/gcd;
    }
 
    //Calculate fraction
    static double calculateFraction(double dNumerator,  double dDenominator) 
    {
        result = dNumerator / dDenominator;
        return result;
    }

    // Fraction to decimal notation
    static void toDecimalNotation(double calculateFraction)
    {
        DecimalFormat df = new DecimalFormat("0.00000");
        System.out.println(df.format(calculateFraction));
    }

    //Fraction to string
    public String toString()   
    {  
        String stringResult;  
        String numeratorStr = String.valueOf(this.numerator);
        String denominatorStr = String.valueOf(this.denominator);
        stringResult =  ('\u0022' + numeratorStr +"/" + denominatorStr + '\u0022');
        System.out.println(stringResult);
        return stringResult;
    } 

    // Get numerator and denominator
    int getNumerator() {
        return numerator;
    }

    int getDenominator() {
        return denominator;
    }

    //Fraction add an int number
    Fractions addNumber(int toAdd)   
    {  
        int newNumerator;  
        newNumerator = (toAdd* this.denominator) + this.numerator;
        return new Fractions(newNumerator, this.denominator);
    }  

    //Add two fractions 
    Fractions add(Fractions f) {
        int numerator = this.numerator * f.getDenominator() + f.getNumerator() * this.denominator;
        int denominator = this.denominator * f.getDenominator();
        return new Fractions(numerator, denominator);
    }

    //Fraction subtract an int number
    Fractions subtractNumber(int toSubstract)   
    {  
        int newNumerator;  
        newNumerator = this.numerator - ( toSubstract * this.denominator);
        return new Fractions(newNumerator, this.denominator);
    } 

    //Subtract two fractions
    Fractions subtract(Fractions f) {
        int numerator = this.numerator * f.getDenominator() - f.getNumerator() * this.denominator;
        int denominator = this.denominator * f.getDenominator();
        return new Fractions(numerator, denominator);
    }

    //Fraction multiply by an int number
    Fractions multiplyNumber(int toMultiply) {
        int newNumerator;  
        newNumerator = this.numerator * toMultiply;
        return new Fractions(newNumerator, this.denominator);
    }

    //Fraction multiply by another fraction
    Fractions multiply(Fractions f) {
        int numerator = this.numerator * f.getNumerator();
        int denominator = this.denominator * f.getDenominator();
        return new Fractions(numerator, denominator);
    }
    
    //Fraction divide by an int number
    Fractions divideNumber(int toDivide) {
        int newDenominator;  
        newDenominator = this.denominator * toDivide;
        return new Fractions(this.numerator, newDenominator);
    }

    //Fraction divide by another fraction
    Fractions divide(Fractions f) {
        int numerator = this.numerator * f.getDenominator();
        int denominator = this.denominator * f.getNumerator();
        return new Fractions(numerator, denominator);
    }

    //Print fraction
    void print() {
        if(denominator!=1)
        {
            System.out.println(numerator + "/" + denominator);
        }
        else
        {
            System.out.println(numerator);
        }
    }


    public static void main(String[] args) 
    {
        System.out.print(" 1/3 should return 0.33333 : ");
        toDecimalNotation(calculateFraction(1,3));

        System.out.print(" 1/3 should return “1/3” : ");
        Fractions f1 = new Fractions(1, 3);
        f1.toString(); 

        System.out.print(" 1/3 + 1 should become 4/3 : ");
        Fractions f3 = f1.addNumber(1);
        f3.print();

        System.out.print(" 1/3 + 1/6 should become 1/2 : ");
        Fractions f2 = new Fractions(1, 6);
        Fractions f4 = f1.add(f2);
        f4.print();

        System.out.print(" 4/3 - 1 should become 1/3 : ");
        Fractions f5 = new Fractions(4, 3);
        Fractions f6 = f5.subtractNumber(1);
        f6.print();

        System.out.print(" 1/2 - 1/6 should become 1/3 : ");
        Fractions f7= new Fractions(1, 2);
        Fractions f8 = f7.subtract(f2);
        f8.print();

        System.out.print(" 3/4 * 2 should become 3/2 : ");
        Fractions f9= new Fractions(3, 4);
        Fractions f10 = f9.multiplyNumber(2);
        f10.print();

        System.out.print(" 3/4 * 2/5 should become 3/10 : ");
        Fractions f11= new Fractions(2, 5);
        Fractions f12 = f11.multiply(f9);
        f12.print();

        System.out.print(" 3/2 / 2 should become 3/4 : ");
        Fractions f13= new Fractions(3, 2);
        Fractions f14 = f13.divideNumber(2);
        f14.print();

        System.out.print(" 3/10 / 2/5 should become 3/4 : ");
        Fractions f15= new Fractions(3, 10);
        Fractions f16 = f15.divide(f11);
        f16.print();
    }
}

