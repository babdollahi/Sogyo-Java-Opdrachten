//  Banafsheh Abdollahi created this program to create Collatz Sequence
import java.util.Scanner;

public class collatzSequence 
{
    public static void main(String[] args)
    {
        System.out.println("Enter a positive integer: ");
        //Defining varibale 
        int num;
        //Asking input from the user
        Scanner input = new Scanner(System.in);
        num = input.nextInt();

        System.out.println("The Collatz Sequence is: ");

        //Repeat the process untill the loop reach number 1
        while (num != 1)
        {    
            // If n is odd
            if ( (num & 1) == 1)
            {
                num = (3* num + 1);
            }
            else //If even
            {
                num = (num/2);
            }
            //Printing the results
            System.out.print(num + "  ");
     
        }
        System.out.println(" ");
    }
}


