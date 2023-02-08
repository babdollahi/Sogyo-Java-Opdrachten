import java.util.Scanner; 
import java.util.Date; 

public class coinFlipGame 
{
    public static void main(String[] args)
    {
        //Describe the game.
        System.out.println("Hi there! " +
        "\nPlease enter your guess to" + 
        "\nstart the coin flip game!");

        //Asking user to enter heads or tails 
        Scanner input = new Scanner(System.in);
        System.out.println("Heads or tails?");
        String inputUser = input.nextLine().toLowerCase();
        
        //Generate a random number between 0 and 1 
        int coinFlip = (int)Math.round(Math.random()); 

        System.out.println("Flipping the coin ... ");

        //Assumed 0 for heads and 1 for tails
        if (coinFlip == 0)
        {
            if (inputUser == "heads")
            {
                System.out.println("Correct");
            }
            else
            {
                System.out.println("Incorrect");
            }

        }        
        else
        {
            if (inputUser == "tails")
            {
                System.out.println("Correct");
            }
            else
            {
                System.out.println("Incorrect");
            }
        }
    }  
}
