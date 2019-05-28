// Java Program to illustrate parallelPrefix() 
// and demonstrate different ways of 
// passing parameter to it 
import java.util.Arrays; 
import java.util.function.IntBinaryOperator; 
public class StreamPrefix { 
	
	// Performs addition 
	static int compute(int x, int y) 
	{ 
		return x + y; 
	} 

        static int increment(int x, int y)
        {
                return ++x;
        }	

	public static void main(String[] args) { 
		int[] arr = { 2, 1, 7, 8, 4, 5, 6, 9, 8, 7, 1, 2, 3, 6, 5, 4, 7, 5 }; 

		
		System.out.println("initial: " + Arrays.toString(arr));
		// Uncomment to see different methods working 
		
		//Method 1(Creating an instance for IntBinaryOperator) 
		IntBinaryOperator op = (x, y) -> x + y; 
		Arrays.parallelPrefix(arr, op); 
		System.out.print(" x + y: ");
		Arrays.stream(arr).forEach(e -> System.out.print(e + " ")); 
		System.out.println();

		int[] arr2 = { 2, 1, 7, 8, 4, 5, 6, 9, 8, 7, 1, 2, 3, 6, 5, 4, 7, 5 }; 
		// Method 2(Directly passing a lambda expression that evaluates to 
		// return IntBinaryOperator) 
		Arrays.parallelPrefix(arr2, (x, y) -> x + y); 
		System.out.print(" x + y: ");
		Arrays.stream(arr2).forEach(e -> System.out.print(e + " ")); 
		System.out.println();

		int [] arr3 = { 2, 1, 7, 8, 4, 5, 6, 9, 8, 7, 1, 2, 3, 6, 5, 4, 7, 5 }; 
		// Method 3(Declaring the operation in some extrenal Function) 
		Arrays.parallelPrefix(arr3, StreamPrefix::increment);
		//Arrays.parallelPrefix(arr3, (x,y) -> compute(x,y)); 
		
		// Printing the array elements 
		System.out.print(" x + y: ");
		Arrays.stream(arr3).forEach(e -> System.out.print(e + " ")); 
		System.out.println();
	} 
} 

