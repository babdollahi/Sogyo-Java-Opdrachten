//Banafsheh Abdollahi created this program to calculate BMI.
import java.util.Scanner;
import java.text.DecimalFormat;

class BMI {

    public static void main(String[] args) 
    {
        //Defined format to show only two numbers after the decimal point for the final result
        DecimalFormat df = new DecimalFormat("0.00");
        
        //Defining variable
        double weight;
        //Scanner class to ask input from user
        System.out.println("Please enter your weight in kg: ");
        Scanner inputWeight = new Scanner(System.in);
        weight= inputWeight.nextDouble();

        //Scanner class to ask input from user
        System.out.println("Please enter your height in cm: ");
        Scanner inputHeight = new Scanner(System.in);
        double height = inputHeight.nextDouble();

        //Calculating BMI
        double BMI =(weight / Math.pow((height/100),2));
        //Printing the BMI
        System.out.println("Your BMI is: " + df.format(BMI));

        //Printing the BMI categorie
        if(BMI < 16){System.out.print("Underweight (Severe thinness)");}
        else if((16 < BMI) && (BMI < 16.9)){System.out.print("You are considerd : Underweight (Moderate thinness)");}
        else if((17 < BMI) && (BMI < 18.4)){System.out.print("You are considerd : Underweight (Mild thinness)");}
        else if((18.5 < BMI) && (BMI < 24.9)){System.out.print("You are considerd : Normal range");}
        else if((25 < BMI) && (BMI < 29.9)){System.out.print("You are considerd : Overweight (Pre-obese)");}
        else if((30 < BMI) && (BMI < 34.9)){System.out.print("You are considerd : Obese (Class I)");}
        else if((35 < BMI) && (BMI < 39.9)){System.out.print("You are considerd : Obese (Class II))");}
        else{System.out.print("You are considerd : Obese (Class III)");}
        System.out.println(" ");
   
    }
}
