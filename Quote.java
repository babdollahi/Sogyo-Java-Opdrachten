//package nl.sogyo.javaopdrachten.quote;
import java.time.LocalDate;    

public class Quote
{

    //Capitalize the first letter of the word
    public static String capitalizeWord(String str)
        {
            return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
        }

    //Capitalize the first letter of each word in a sentence
    public static String capitalizeSentence(String str)
    {  
        String words[]=str.split("\\s");  
        String capitalizeWord="";  
        for(String w:words)
        {  
            String first=w.substring(0,1);  
            String afterfirst=w.substring(1);  
            capitalizeWord+=first.toUpperCase()+afterfirst+" ";  
        }  
        return capitalizeWord.trim();  
    }  

    public static void main(String[] args) 
    { 
        String[][] quotes = 
        {
            {"galileo", "eppur si muove"},
            {"archimedes", "eureka!"},
            {"erasmus", "in regione caecorum rex est luscus"},
            {"socrates", "I know nothing except the fact of my ignorance"},
            {"rené descartes", "cogito, ergo sum"},
            {"sir isaac newton", "if I have seen further it is by standing on the shoulders of giants"}
        };

        //Getting the day of year using the current date
        int dayOfYear = LocalDate.now().getDayOfYear();
        System.out.println("Day of year "+ dayOfYear);

        //Determine quote number to print based on the day of the year
        int quotesNum;

        if (dayOfYear < 6 )
        {
            quotesNum = dayOfYear;
        }
        else if (dayOfYear == 6)
        {
            quotesNum = 0;
        }
        else 
        {
            quotesNum = (dayOfYear % 6);
        }

        //Peint the quote 
        switch (quotesNum)
        {
            case 1:  System.out.println(capitalizeWord(quotes[0][1]) + ". -- " + capitalizeWord(quotes[0][0]));
                     break;
            case 2:  System.out.println(capitalizeWord(quotes[1][1]) + " -- " + capitalizeWord(quotes[1][0]));
                     break;
            case 3:  System.out.println(capitalizeWord(quotes[2][1])+ ". -- " + capitalizeWord(quotes[2][0]));
                     break;
            case 4:  System.out.println(capitalizeWord(quotes[3][1])+ ". -- " + capitalizeWord(quotes[3][0]));
                     break;
            case 5:  System.out.println(capitalizeWord(quotes[4][1])+ ". -- " + capitalizeSentence(quotes[4][0]));
                     break;
            case 0:  System.out.println(capitalizeWord(quotes[5][1])+ ". -- " + capitalizeSentence(quotes[5][0]));
                    break;
        }
    }  
}
