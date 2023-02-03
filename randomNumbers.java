import java.util.Arrays;
public class randomNumbers{
public static void main(String[] args) 
{
	// Part one 
    int[] numbers = new int[10];       
    //Generates 10 Random Numbers in the range 0 and 100
    for(int i = 0; i < numbers.length; i++) {
      numbers[i] = (int)(Math.random()*100 + 1);
    }//end for loop
    System.out.println("Numbers Generated: " + Arrays.toString(numbers));
    
     //Part two
	 //Initialize max with first element of array.  
     int max = numbers[0];  
     //Loop through the array  
     for (int i = 0; i < numbers.length; i++) {  
     //Compare elements of array with max  
     if(numbers[i] > max)  
	 max = numbers[i];  }
     System.out.println("Highest Value in the generated array: " + max);  
}
}
