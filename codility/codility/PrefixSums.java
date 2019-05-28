// https://codility.com/media/train/3-PrefixSums.pdf

import java.util.stream.IntStream;
import java.util.Arrays;
class PrefixSums{
	public static void main (String ... args){
		int[] arr = {-2,3,1,0,-4,8};

		System.out.println(" mushrooms for 3,4 : " + Arrays.toString(arr) + ", is : " + mushrooms(arr,3,4));
/*

		System.out.println(" prefix sum for: " + Arrays.toString(arr) + ", is : " + prefixSum(arr));
		Arrays.parallelPrefix(arr, (x,y)->x +y);
		System.out.println(" prefix sum for: " + Arrays.toString(arr) + ", is : " + arr[arr.length-1] );
		System.out.println(" countTotal 2,3: " + countTotal(arr, 2,3) );
		System.out.println(" countTotal 1,4: " + countTotal(arr, 1,4) );
		System.out.println(" countTotal 0,4: " + countTotal(arr, 0,4) );
*/
	}

	private static int prefixSum(int[] arr){
                int N = arr.length;
                int[] P = new int[N+1];

		int sum = 0;
		for (int x = 0; x < N;x++){
			P[x+1] = P[x] + arr[x];
			sum += /*P[x] +*/ arr[x];
		}
		System.out.println(Arrays.toString(arr) + " // " + Arrays.toString(P));
		return sum;	
	}

	public static int  countTotal(int[] P, int x, int y){ 
		System.out.println((y+1)+":"+P[y+1] + " - " + x +":"+ P[x] + " = " + (P[y + 1] - P[x]) );
		return P[y + 1] - P[x];
	}


	private static int mushrooms(int[] A, int k, int m)
	{
		int n = A.length;
		int result = 0;
		int[] pref = new int[n+1];
		System.arraycopy(A, 0, pref, 1, n);
		Arrays.parallelPrefix(pref, (x,y)->x +y);

		System.out.println (" Mushroom arrays:\n" + Arrays.toString(A) +"\n"+ Arrays.toString(pref));
		System.out.println (" k: " + k + ", m: " + m);
		
		for (int p = 0; p < Math.min(m, k) + 1;p++){
			System.out.println(" p1: " + p);
			int left_pos = k - p;
			int right_pos = Math.min(n - 1, Math.max(k, k + m - 2 * p));
			result = Math.max(result, countTotal(pref, left_pos, right_pos));
		}

		System.out.println(" -==-=-  ");
		for (int p =0; p < Math.min(m + 1, n - k);p++){
			System.out.println(" p2 : " + p);
 			int right_pos = k + p;
 			int left_pos = Math.max(0, Math.min(k, k - (m - 2 * p)));
 			result = Math.max(result, countTotal(pref, left_pos, right_pos));
		}
		return result;
	}
}
