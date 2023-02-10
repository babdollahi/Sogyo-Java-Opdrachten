//https://www.tutorialspoint.com/java/java_object_classes.htm
import java.io.*;
public class Robot {

   String name;
   String head;
   int x;
   int y;
   //private static int mv;
   //int speed;

   /*public void setSpeed(int mv) 
   {  
      speed = mv;
   }
   public int getSpeed()
   {
      return speed;
   }*/
   public static int setSpeed(int speed) {
      //for (int i = 0; i < 4; i++) 
      //{
         speed = 10;
         return speed;
     // }
  }
  

   public Robot(String name, int x, int y, String head) 
   {
      this.name = name;
      this.x = x;
      this.y = y;
      this.head = head;
   }
   // Print the Robot details
   public void printRobot() 
   {
      System.out.println("Initial position and facing of " + name +
      " = x: " + x +
      " , y: " + y +
      " , " + head);
   }

   // Print the state of the Robot
   public void printState() 
   {
      System.out.println( "Now " + name + " is facing "+ head + " at " + "(" + x + "," + y + ")");
   }

   // Creating the left function
   public void turnLeft()
   {
      switch (head)
      {
        case "East":  head = "North";
        break;
        case "North":  head = "West";
        break;
        case "West": head = "South";
        break;
        case "South": head = "East";
        break;
      } 
      System.out.println( name + " turned Left.");
   }

   // Creating the right function
   public void turnRight()
   {
      switch (head)
      {
        case "East":  head = "Suoth";
        break;
        case "South":  head = "West";
        break;
        case "West": head = "North";
        break;
        case "North": head = "East";
        break;
      } 
      System.out.println(name + " turned Right.");
   }

   //Creating the forward function
   public void forward()
   {
      switch (head)
      {
        case "East":  x = x + setSpeed(2);
        break;
        case "South":  y = y - setSpeed(2);
        break;
        case "West": x = x - setSpeed(2);
        break;
        case "North": y = y + setSpeed(2);
        break;
      } 
      System.out.println( name + " moved Forward.");
   }
   //Creating the backward function
   public void backward()
   {
      switch (head)
      {
        case "East":  x = x - 1;
        break;
        case "South":  y = y + 1;
        break;
        case "West": x = x + 1;
        break;
        case "North": y = y - 1;
        break;
      }       
      System.out.println( name + " moved Backward.");
   }


   public static void main(String args[]) 
   {
      //Create two Robots using constructor
      Robot myFirstRobot = new Robot("myFirstRobot", 0, 1, "East");
      myFirstRobot.printRobot();
      Robot mySecondRobot = new Robot("mySecondRobot", 1, 0, "West");
      mySecondRobot.printRobot();

      myFirstRobot.turnLeft();
      myFirstRobot.forward();
      myFirstRobot.printState();
      mySecondRobot.backward();
      mySecondRobot.printState();

   }
}