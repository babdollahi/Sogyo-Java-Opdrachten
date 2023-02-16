import java.util.Scanner; 
public class exceptionalUser 
{
    //Function to check if a password has uppercase, lowercase and numbers in it.
    private static boolean validatePassword(String str) {
        char ch;
        boolean capitalFlag = false;
        boolean lowerCaseFlag = false;
        boolean numberFlag = false;
        for(int i=0;i < str.length();i++) {
            ch = str.charAt(i);
            if( Character.isDigit(ch)) {
                numberFlag = true;
            }
            else if (Character.isUpperCase(ch)) {
                capitalFlag = true;
            } else if (Character.isLowerCase(ch)) {
                lowerCaseFlag = true;
            }
            if(numberFlag && capitalFlag && lowerCaseFlag)
                return true;
        }
        // throw new Exception ("Validation failed!");
        return false;
    }

    public static void registerUser() 
    {

        Scanner input = new Scanner(System.in);
        
        String username;
        String password;

        System.out.println("Username: ");
        username = input.next();

        System.out.println("Password: ");
        password = input.next();
        validatePassword(password);

        if(username.equals(username) && password.equals(password))
        {
            // // Throw exception method commented
            // try{
            //         if (validatePassword(password))
            //         {
            //         System.out.println("New user registerd.");
            //         }
            //         else
            //         {
            //             throw new Exception ();
            //         }
            //     }
            //     catch(Exception e) 
            //     {
            //         System.out.println("Something has gone wrong.");
            //     } 

            //Without exception using the function
            if (validatePassword(password))
                {
                System.out.println("New user registerd.");
                }
                else
                {
                    System.out.println("This is not a valid password. Please enter a stronger password.");

                }
        }

            
    }

    public static void main(String[] args) 
    {
        registerUser();

    }
 }
    

