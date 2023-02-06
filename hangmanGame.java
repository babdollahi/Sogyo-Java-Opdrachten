import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class hangmanGame{
    //lives:
    //input:
    //word:
    //not used

    public static void main(String[] args) {
        System.out.println("Starting Game");
        //defining a list of word
        String[] words =new String[] {"Hello", "World!", "How", "Are", "You"};

        // (remove) String[] words = new String[] {'computer','car','book'};
        //select a random word from the list of words by random index
        String randomword = words[(int)(Math.random() * words.length)];
        int length = randomword.length();
        System.out.println("The word has " + length + " aletters.");

        //storing the letters that user is gussing (it has the same lenghth of the randomword)
        char[] letters = new char[randomword.length()];

        //Generate the letters array 
        for (int i = 0; i < letters.length; i++){
            System.out.print("-");

           // letters[i] = ".";
        }
        //Print an empty line
        System.out.println("");

        int lives = 3;
        while(lives > 0) {
            System.out.print("Lives: ");
            for (int i = 0; i < lives; i++) {
                System.out.print("\u2665");


            }
        
            System.out.println();
            System.out.println("Please enter a letter:");
            //read user input
            Scanner stringScanner = new Scanner(System.in);
            String input = stringScanner.next();
            
            //take the input of user as letter
            char letter = input.charAt(0);

            //Printing the letter
            //System.out.println("Remaining lives:");

            for (int i = 0; i < letters.length ; i++){
                System.out.print(letters[i]);
            }


            boolean isGuessCorrect = false;
            //check if the letter is in the random word
            for (int i = 0; i < length ; i++){
                // gussing the letter
                char l = randomword.charAt(i);
                if (l == letter){
                    letters[i] = l;
                    isGuessCorrect = true;
                
                }
                //System.out.print(letters[i]);
            }
            //if the guess was not correct reduce the lives
            if (!isGuessCorrect){
                lives = lives -1;
            }
    }
        System.out.print("Exit the game! Try again.");



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

}
