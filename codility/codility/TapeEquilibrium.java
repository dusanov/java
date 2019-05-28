import java.util.stream.IntStream;
import java.util.Arrays;
public class TapeEquilibrium{

	public static void main (String ... args) {
	
		TapeEquilibrium eq = new TapeEquilibrium();
		int[] arr = {3,1,2,4,3};
		int[] arr2 = {5, 6, 2, 4, 1};
		System.out.println(" solution for: " + Arrays.toString(arr) +" is : " + eq.solution(arr));
		System.out.println(" solution for: " + Arrays.toString(arr2) +" is : " + eq.solution(arr2));
	
	}

	public int solution(int[] A){

		int length = A.length,
			sumL=A[0],
			sumR=IntStream.of(A).sum() - A[0],
			min=Math.abs(sumL-sumR);
		
		System.out.println(" sumL: " + sumL + ", sumR: " + sumR + ", min: " + min);
		
		for (int i = 1; i < length-1; i++){
			sumL = sumL + A[i];
			sumR = sumR - A[i];
			final int diff = Math.abs( sumL - sumR );
			System.out.println(" sumL: " + sumL + ", sumR: " + sumR + ", min: " + diff);
			if (diff < min)
				min = diff; 
		}
		return min;
	
/*
 *
 public int solution(int[] A) {
 if (A.length == 2)
        return Math.abs(A[0]-A[1]);

    int [] s1 = new int[A.length-1];
    s1[0] = A[0];
    for (int i=1;i<A.length-1;i++) {
        s1[i] = s1[i-1] + A[i];
    }

    int [] s2 = new int[A.length-1];
    s2[A.length-2] = A[A.length-1];
    for (int i=A.length-3;i>=0;i--) {
        s2[i] = s2[i+1] + A[i+1];
    }

    int finalSum = Integer.MAX_VALUE;
    for (int j=0;j<s1.length;j++) {
        int sum = Math.abs(s1[j]-s2[j]);
        if (sum < finalSum)
            finalSum = sum;
    }
    return finalSum;
    }
 *
 * */

	}
}
