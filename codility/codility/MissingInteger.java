
//https://app.codility.com/demo/results/trainingUWQG5D-RNN/

import java.util.Arrays;
public class MissingInteger{

	public static void main (String ... args){
	
		int[] arr1 = {1, 3, 6, 4, 1, 2};
		int[] arr2 = {0,-1,-3,1, 3, 6, 4, 1, 2};
		int[] arr3 = {0};
		int[] arr4 = {};
		int[] arr5 = {-9};
		MissingInteger mi = new MissingInteger();
		System.out.println(" solution for: " + Arrays.toString(arr1) + ", is: " + mi.solution(arr1));
		System.out.println(" solution for: " + Arrays.toString(arr2) + ", is: " + mi.solution(arr2));
		System.out.println(" solution for: " + Arrays.toString(arr3) + ", is: " + mi.solution(arr3));
		System.out.println(" solution for: " + Arrays.toString(arr4) + ", is: " + mi.solution(arr4));
		System.out.println(" solution for: " + Arrays.toString(arr5) + ", is: " + mi.solution(arr5));

	}

	public int solution(int[] A){
		int N = A.length;
		boolean[] B = new boolean[N];
		for (int curr : A){ if ( 0 <= curr-1 && curr-1 < N ) B[curr-1]=true; }
		if (B.length==0) return 1;
		for (int curr = 0; curr < N; curr++){if (!B[curr])return ++curr;}
		return N+1;
	}
}
