//Banafsheh Abdollahi created this program to find the nth prime number.

import java.util.Scanner;
public class primeNumbers 
{
    public static void main(String[] arg)
    {
        //Use scanner to ask data from the user
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number to see the nth prime number:");
        int n = input.nextInt();
        //Define variables 
        int num = 1;
        int counter = 0;
        int i;

        //Continue the loop until it reaches the nth number
        while (counter < n)
        {   
            //Check if a number is prime
            num += 1;
            for (i = 2; i<= num; i++)
            {
                if(num%i == 0)
                {
                    break;
                }
            }
            if (i==num)
            {
                counter += 1;
            }
        }
    //Print the results
    System.out.print("The nth prime number is: " + num); 
    System.out.println("");   
  
    }
}