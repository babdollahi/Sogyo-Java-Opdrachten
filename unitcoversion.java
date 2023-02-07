import java.util.Scanner;
import java.text.DecimalFormat;

class unitcoversion {

    public static void main(String[] args) 
    {
        //Defined format to show only two numbers after the decimal point for the final result
        DecimalFormat df = new DecimalFormat("0.00");

        //Distance
        // Defineing the variables for distance
        double km, miles;
        // Conversion coefficient
        double conversionCoefficient = 1.609344;
        // Scanner class to ask input from user
        System.out.println("Enter distance value in Kilometers: ");
        Scanner inputDistance = new Scanner(System.in);
        km = inputDistance.nextDouble();
        // Converting kilometers to miles
        miles = km / conversionCoefficient;
        //printing the output
        System.out.println("The distance in Miles : " + df.format(miles));

        //Temperature
        // Defineing the variables for temperature
        Scanner inputTemperature = new Scanner(System.in);
        // Scanner class to ask input from user
        System.out.print("Enter temperature in Fahrenheit: ");

        // Defineing the variables for temperature
        double fahrenheit = inputTemperature.nextDouble();
        // Defineing the variables for celsius and converting fahrenheit to celsius
        double  celsius =(( 5 *(fahrenheit - 32.0)) / 9.0);
        //printing the output
        System.out.println("The temperature in Celsius : " + df.format(celsius));

    }
}


