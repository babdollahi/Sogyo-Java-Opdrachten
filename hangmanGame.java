//Banafsheh Abdollahi created this java script to respond to assignment three.
import java.util.Scanner;

public class hangmanGame
{
    public static void main(String[] args)
    {

        //Scanner s = new Scanner(new File("filepath"));
/*ArrayList<String> list = new ArrayList<String>();
while (s.hasNext()){
    list.add(s.next());
}
s.close(); */
        System.out.println("Starting Game");
        //A string including the alphabet to later show the user which letter he/she has used
        String notUsed = "abcdefghijklmnopqrstuvwxyz";
        //defining a list of words
        String[] words =new String[] {"Hello", "World!", "How", "Are", "You"};

        //Select a random word from the list of words by random index
        String randomword = words[(int)(Math.random() * words.length)];

        //Printing the lenght of the random word
        System.out.println("The word has " + randomword.length() + " letters.");

        //Storing the letters that user is gussing which has the same lenghth of the randomword
        char[] letters = new char[randomword.length()];

        //Generate the letters array 
        for (int i = 0; i < letters.length; i++)
        {
            letters[i] = '-';
        }

        //Print an empty line
        System.out.println("");

        //A loop that runs until the user has lives
        //By default user has 10 lives
        int lives = 10;
        //Define scanner to ask for input from user
        Scanner stringScanner = new Scanner(System.in);

        while(lives > 0) 
        {
            System.out.print("Lives: ");
            //Print a heart to show the lives
            for (int i = 0; i < lives; i++)
            {
                System.out.print("\u2665");
            }

            System.out.println();
            System.out.println("Please enter a letter:");
            //Read user input
            String input = stringScanner.next();
            
            //Take the input of user as letter and convert to lower case
            char letter = input.toLowerCase().charAt(0);

            //Defineing a boolean to check if the guess was correct
            boolean isGuessCorrect = false;
            //Check if the letter is in the random word
            for (int i = 0; i < randomword.length() ; i++)
            {
                //Guessing the letter and convert to lower case
                char l = randomword.toLowerCase().charAt(i);
                if (l == letter)
                {
                    letters[i] = l;
                    isGuessCorrect = true;
                }
            }

            //If the guess was not correct reduce the lives
            if (!isGuessCorrect)
            {
                lives = lives - 1;
            }
            //Add boolean to check if game is finished
            boolean isGameFinished = true;

            System.out.print("Word: ");

            for (int i = 0; i < letters.length ; i++)
            {
                if (letters[i] == '-')
                {
                    isGameFinished = false;
                }
                //Prints - if the letter was not correct and prints the letter which guessed correct
                System.out.print(letters[i]);
            }

            System.out.println(); 
            
            //Replace the alphabet string with - if user has used this letter
            notUsed = notUsed.replace(letter, '-');
            System.out.println("Not used: " + notUsed);

            System.out.println("************************************");
            
            //If user has won the game break the loop
            if (isGameFinished)
            {
                System.out.println("You won!");
                break;        
            }
        }

        //If user has no lives print that he/she lost
        if (lives == 0)
        {
            System.out.println("You lost! The word was: " + randomword);
        }
        System.out.print("Exit the game! Try again.");

        }
    }

    /*File f = new File("/home/banafsheh/Learning/java-opdrachten/words.txt");
        try{
            ArrayList<String> lines = get_arraylist_from_file(f);
            for(int x = 0; x < lines.size(); x++){
                System.out.println(lines.get(x));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("done");

    }
    public static ArrayList<String> get_arraylist_from_file(File f) 
        throws FileNotFoundException {
        Scanner s;
        ArrayList<String> list = new ArrayList<String>();
        s = new Scanner(f);
        while (s.hasNext()) {
            list.add(s.next());
        }
        s.close();
        return list;
    }*/
    /*Scanner s = new Scanner(new File("/home/banafsheh/Learning/java-opdrachten/words.txt"));
    ArrayList<String> list = new ArrayList<String>();
    while (s.hasNext()){
        list.add(s.next());
    }
    s.close();*/

