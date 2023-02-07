//Banafsheh Abdollahi created this program to find the nth prime number.

import java.util.Scanner;

public class fibonacciSequence  
{
    public static void main(String[] arg)
    {
        //Part one
        //Use scanner to ask data from the user
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number to see the nth Fibonacci term:");
        int n = input.nextInt();
        //Define variables 
        int num1 = 0;
        int num2 = 1;
        int num3 = 0;
        int i;
        int counter = 0;
        
        //Continue the loop until it reaches the nth number
        for (i = 2; i<n;++i)
        {   
            //Calculate the Fibonacci
            num3 = num1 + num2;
            //Update the values
            num1 = num2;
            num2 = num3;
            
            if (num3%2 == 0)
            {
            counter = counter + num3;
            }

            
        }
    //Print the results
    System.out.println("The " + n + "th Fibonacci term is: " + num3); 
    System.out.println("The sum of all even values of the first" + n + "terms is " + counter + ".");

    System.out.println("");   
  
    }
}
    