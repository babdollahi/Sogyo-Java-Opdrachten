//Banafsheh Abdollahi created this java script to respond to assignment two.
import java.util.Arrays;
import java.util.Random; 
import java.util.ArrayList;
import java.util.List;

public class lists{

//Defining the bubbleSort function for the assignment's part 6
static void bubbleSort(int[] arr)
{  
        int n = arr.length;  
        int temp = 0;  
         for(int i=0; i < n; i++)
            {  
                 for(int j=1; j < (n-i); j++)
                    {  
                          if(arr[j-1] > arr[j])
                            {  
                                 //swap elements  
                                 temp = arr[j-1];  
                                 arr[j-1] = arr[j];  
                                 arr[j] = temp;  
                            }  
                            
                    }  
            }  
  
}  
public static void main(String[] args)
{
    // Part one of the assignments

    //Define list of numbers
    int[] numbers = new int[10];   
    //Generating 10 Random Numbers in the range 0 and 100
    for(int i = 0; i < numbers.length; i++) 
        {
            numbers[i] = (int)(Math.random()*100 + 1);
        }
    //Printing the generated numbers
    System.out.println("Numbers Generated: " + Arrays.toString(numbers));
    

     // Part two of the assignments

	 //Initialize max with first element of array  
     int max = numbers[0];  
     //Loop through the array  
    for (int i = 0; i < numbers.length; i++) 
        {  
        //Compare elements of array with max  
        if(numbers[i] > max)  
            max = numbers[i];  
        }
    //Printing the highest value in the generated numbers
    System.out.println("Highest Value in the generated array: " + max);  
	
    
    //Part three of the assignments
    // Finding the lowest two values of the generated numbers
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
    //Printing the two lowest values in the generated numbers
	System.out.println("The two lowest values in the generated array: " + numbers[0] + " and " + numbers[1]  );  
	

	//Part four of the assignments
    System.out.println("Even numbers in the generated array:"); 
    //Defining an empty list
    List<Integer> even = new ArrayList<Integer>(); 
    //Finding even numbers and adding to the list 
    for(int i=0;i<numbers.length;i++)
    {  
        if(numbers[i]%2==0)
        {  
            even.add(numbers[i]);
        }  
    }
    //Printing the list of even numbers 
    System.out.println(Arrays.toString(even.toArray()));

	System.out.println("Odd numbers in the generated array:");
    //Defining an empty list
    List<Integer> odd = new ArrayList<Integer>(); 
    //Finding odd numbers and adding to the list 
    for(int i=0;i<numbers.length;i++)
    {  
        if(numbers[i]%2!=0)
        {
            odd.add(numbers[i]);
        }
	}
    //Printing the list of odd numbers 
    System.out.println(Arrays.toString(odd.toArray()));


    //Part five of the assignments
    System.out.println("Dividable numbers by 2 in the generated array:");
    //Defining an empty list
    List<Integer> diviby2 = new ArrayList<Integer>();
    //Finding deviable numbers by 2 and adding to the list 
    for(int i=0;i<numbers.length;i++)
    {  
        if(numbers[i]%2==0)
        {  
            diviby2.add(numbers[i]);
        }
	}
    //Printing the list numbers dividable by 2
    System.out.println(Arrays.toString(diviby2.toArray()));
       
    System.out.println("Dividable numbers by 3 in the generated array:");
    //Defining an empty list
    List<Integer> diviby3 = new ArrayList<Integer>();
    //Finding deviable numbers by 3 and adding to the list 
    for(int i=0;i<numbers.length;i++)
    {  
        if(numbers[i]%3==0)
        {  
            diviby3.add(numbers[i]);
        }
	} 
    //Printing the list numbers dividable by 3
    System.out.println(Arrays.toString(diviby3.toArray()));
 
    System.out.println("Dividable numbers by 5 in the generated array:");
    //Defining an empty list  
    List<Integer> diviby5 = new ArrayList<Integer>();
    //Finding deviable numbers by 5 and adding to the list 
    for(int i=0;i<numbers.length;i++)
    {  
        if(numbers[i]%5==0)
        {
            diviby5.add(numbers[i]);
        }
	}
    //Printing the list numbers dividable by 3
    System.out.println(Arrays.toString(diviby5.toArray()));

    System.out.println("The rest of numbers in the generated array:");
    //Defining an empty list  
    List<Integer> rest = new ArrayList<Integer>();
    //Finding rest of numbers and adding to the list 
    for(int i=0;i<numbers.length;i++)
    {  
        if(numbers[i]%2!=0 && numbers[i]%3!=0 && numbers[i]%5!=0)
            {
                rest.add(numbers[i]);
            }
	}
    //Printing the rest of numbers
    System.out.println(Arrays.toString(rest.toArray()));

    //Part six of the assignments
    
    //sorting array elements using bubble sort
    bubbleSort(numbers);
    System.out.println("Array After Bubble Sort:");  
    //Defining an empty list  
    List<Integer> sorted = new ArrayList<Integer>();
    //Finding rest of numbers and adding to the list 
    for(int i=0; i < numbers.length; i++)
    {
        sorted.add(numbers[i]);
    } 
    //Printing the sorted list
    System.out.println(Arrays.toString(sorted.toArray()));
}  
}  
//END