// Java program to find maximum 
// subarray size, such that all 
// subarrays of that size have 
// sum less than K. 
import java.util.Arrays; 

class MaxSubArrSizeWithSumLessThanK { 
	
	// Search for the maximum length 
	// of required subarray. 
	static int bsearch(int prefixsum[], 
					int n, int k) 
	{ 
		// Initialize result 
		int ans = -1; 

		// Do Binary Search for largest 
		// subarray size 
		int left = 1, right = n; 
		
		while (left <= right) 
		{ 
			int mid = (left + right) / 2; 

        System.out.println(" left: "+left+", mid: "+mid+", right: " + right); 
		
            // Check for all subarrays after mid 
			int i; 
			for (i = mid; i <= n; i++) 
			{ 
				
        System.out.println(" I: " + i + ", prefixsum[i]: " + prefixsum[i] + 
                                        ", prefixsum[i-mid]:" + prefixsum[i-mid] +
                                        ", subtr: " + (prefixsum[i]-prefixsum[i-mid])); 
				// Checking if all the subarrays 
				// of a size is less than k. 
				if (prefixsum[i] - prefixsum[i - mid] > k){ 
            System.out.println(" breaking !"); 
					break; }
			} 

			// All subarrays of size mid have 
			// sum less than or equal to k 
			if (i == n + 1) 
			{ 
            System.out.println(" i reached n +1 "); 
				left = mid + 1; 
				ans = mid; 
			} 

			// We found a subrray of size mid 
			// with sum greater than k 
			else{
            System.out.println(" updating right to: "+ (mid-1)); 
				right = mid - 1; 
		    } 
        }

		return ans; 
	} 

	// Return the maximum subarray size, such 
	// that all subarray of that size have 
	// sum less than K. 
	static int maxSize(int arr[], int n, int k) 
	{ 
		
		// Initialize prefix sum array as 0. 
		int prefixsum[] = new int[n + 1]; 
		Arrays.fill(prefixsum, 0); 

		// Finding prefix sum of the array. 
		for (int i = 0; i < n; i++) 
			prefixsum[i + 1] = prefixsum[i] + arr[i]; 

        System.out.println(" prefixsum: " + Arrays.toString(prefixsum)); 
		return bsearch(prefixsum, n, k); 
	} 
	
	// Driver code 
	public static void main(String arg[]) 
	{ 
		int arr[] = { 1, 2, 10, 4 }; 
		int n = arr.length; 
		int k = 14; 

        System.out.println(" For K: " + k + ", arr: " + Arrays.toString(arr)); 
        System.out.println(" result is : " + maxSize(arr, n, k)); 
	} 
} 

// This code is contributed by Anant Agarwal. 

