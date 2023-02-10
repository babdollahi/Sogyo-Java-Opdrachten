import java.io.*;
public class Robot {

   String name;
   String head;
   int x;
   int y;

   public Robot(String name, int x, int y, String head) 
   {
      this.name = name;
      this.x = x;
      this.y = y;
      this.head = head;
   }
   /* Print the Employee details */
   public void printRobot() 
   {
      System.out.println("Initial position and facing of " + name +
      " = x: " + x +
      " , y: " + y +
      " , " + head);
   }

   public void printState() 
   {
      System.out.println( "Now " + name + " is facing "+ head + " at " + "(" + x + "," + y + ")");
   }// Now facing "North"

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

   public void forward()
   {
      y += 1;
      System.out.println( name + " moved Forward.");
   }

   public void backward()
   {
      x += 1;
      System.out.println( name + " moved Backward.");
   }



   public static void main(String args[]) 
   {
      /* Create two objects using constructor */
      //Robot defaultRobot = new Robot("defaultRobot", 0, 0, "North");
      //defaultRobot.printRobot();
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