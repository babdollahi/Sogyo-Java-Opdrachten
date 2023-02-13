//Banafsheh Abdollahi wrote this programm for Roborally assignment.
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Robot implements Runnable 
{
   //Defining variables
   String name;
   String head;
   int x;
   int y;

   //Defining robots with the name, positon (x ,y) and facing (head)
   public Robot(String name, int x, int y, String head) 
   {
      this.name = name;
      this.x = x;
      this.y = y;
      this.head = head;
   }

   // Printing the Robot details
   public void printRobot() 
   {
      System.out.println("Initial position and facing of " + name +
      " = x: " + x +
      " , y: " + y +
      " , " + head);
   }

   // Printing the state of the Robot
   public void printState() 
   {
      System.out.println( "Now " + name + " is facing "+ head + " at " + "(" + x + "," + y + ")");
   }

   // Defineing a list to store all the commands and execute later
   List<Runnable> commands = new ArrayList<>();

   //Exacute command 
   public void run()
   {
      execute();
   }
   public void execute()
   {
      for (Runnable command: commands)
      {
         command.run();
      }
   }


   // Creating the turn left function
   public void turnLeft()
   {  //Adding the command to the list of commands
      commands.add( () -> {
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
      System.out.println( name + " turned Left.");});
   }

   // Creating the turn right function
   public void turnRight()
   {  //Adding the command to the list of commands
       commands.add( () -> {
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
      System.out.println(name + " turned Right.");});
   }

   //Creating the forward function and set parameters
   //The defualt parameter is 1 but can be changed
   public void forward(){this.forward(1);}

   public void forward(int speed)
   {  //Adding the command to the list of commands
      commands.add( () -> {
      switch (head)
      {
        case "East":  x = x + speed;
        break;
        case "South":  y = y - speed;
        break;
        case "West": x = x - speed;
        break;
        case "North": y = y + speed;
        break;
      } 
      System.out.println( name + " moved Forward.");});

   }

   //Creating the backward function
   public void backward()
   {  //Adding the command to the list of commands
      commands.add( () -> {
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
      System.out.println( name + " moved Backward.");});
   }

//Main 
   public static void main(String args[])
   {
      //Create two Robots using constructor
      Robot myFirstRobot = new Robot("myFirstRobot", 0, 1, "East");
      myFirstRobot.printRobot();
      Robot mySecondRobot = new Robot("mySecondRobot", 1, 0, "West");
      mySecondRobot.printRobot();

      //giving the commands from the list of commands 
      //Before execute the commands are not applied
      myFirstRobot.turnLeft();
      myFirstRobot.forward();
      myFirstRobot.printState();

      mySecondRobot.backward();
      mySecondRobot.printState();

      //After execute the commands are applied
      myFirstRobot.execute();
      myFirstRobot.turnLeft();
      myFirstRobot.forward();
      myFirstRobot.printState();

      mySecondRobot.execute();
      mySecondRobot.backward();
      mySecondRobot.printState();

   }
}
//End