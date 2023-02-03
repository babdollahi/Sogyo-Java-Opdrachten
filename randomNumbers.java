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
	 
	 //Part three
	 int min; 
	 	 for (int i = 0; i < numbers.length; i++)   
        {  
            for (int j = i + 1; j < numbers.length; j++)   
            {  
                if (numbers[i] > numbers[j])   
                {  
                    min = numbers[i];  
                    numbers[i] = numbers[j];  
                    numbers[j] = min;  
                }  
            }  
        }  
	System.out.println("The two lowest values in the generated array: " + numbers[0] + " and " + numbers[1]  );  
	
	//Part four
	System.out.println("Odd Numbers in the generated array:");  
    for(int i=0;i<numbers.length;i++){  
    if(numbers[i]%2!=0){  
    System.out.println(numbers[i]); 
	}
	}

}
}
