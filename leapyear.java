//  This is a program that has a year as input and then checks if the year is a leap year.

import java.util.Scanner; // Import the Scanner class to be able to read user input

// Read data from user 
public class leapyear {
	public static void main(String[] args) {
    Scanner s = new Scanner(System.in); // Create a Scanner object
    System.out.println("Please enter a year to check if it is a leap year:");
    int year = s.nextInt(); // Read user input from command line
    checkleapyear(year);
  }

// Check if it is a leap year
public static void checkleapyear(int year) {
    if (year % 4 == 0) {
      System.out.println(year + " is a leap year.");
    } else if (year % 100 == 0) {
      System.out.println(year + " is not a leap year.");
    } else if (year % 400 == 0) {
      System.out.println(year + " is a leap year.");
    } else {
      System.out.println(year + " is not a leap year.");
    }
  }

}