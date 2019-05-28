/**
 *
 *https://app.codility.com/demo/results/trainingDJY8KE-29P/
 *
 * */


import java.util.Arrays;
public class MaxNonoverlappingSegments{

        public static void main (String ... args) {

                MaxNonoverlappingSegments eq = new MaxNonoverlappingSegments();

                int[] arr1 = {1,3,7,9,9};
                int[] arr2 = {5,6,8,9,10};
                System.out.println(" solution for: " + "\n" + Arrays.toString(arr1)
			       				+ "\n" + Arrays.toString(arr2)	
			      				 + "\n is : " + eq.solution2(arr1,arr2));


        }

     public int solution2(int A[], int B[]) {
        int N = A.length;
        if (N <= 1) {
            return N;
        }

        int cnt = 1;
        int prev_end = B[0];

        int curr;
        for (curr = 1; curr < N; curr++) {
            if (A[curr] > prev_end) {
                cnt++;
                prev_end = B[curr];
            }
        }

        return cnt;
    }
        public int solution(int[] A, int[] B){
		int N = A.length;
                if (N==0) return -1;
		if (N==1) return 1;

		int maxSize = 0, saveIndex=0;
		for (int i=0;i<N;i++){
			if ((i+1==N?true:(B[i]<A[i+1])) &&  (i==0?true : (B[i-1]<A[i]))){
			/*if (!(i+1==N?true: (A[i] <= A[i+1] && A[i+1] <= B[i])) &&
			   (!(i+1==N?true: (A[i+1] <= A[i] && A[i] <= B[i+1])))){
			*/	
		   	   int size = B[i] - A[i]+1;
				if (maxSize < size) {maxSize=size;saveIndex=i;}
			}
		}
	System.out.println(" found: " + maxSize + ", for indeX: " + saveIndex);	
		return maxSize;

        }
}
