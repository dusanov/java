// 50% https://app.codility.com/demo/results/trainingKMBNGW-K7J/
// 50% https://app.codility.com/demo/results/trainingHKPZGX-NW7/
// 50% https://app.codility.com/demo/results/training47S4KS-CQJ/
// 50% https://app.codility.com/demo/results/trainingUJVQTT-URK/
// after adding sum > 1000000 return -1
// 60% https://app.codility.com/demo/results/trainingDJ2R6E-C8W/
// fixing bug
// https://app.codility.com/demo/results/training5GA39P-Y9G/
// fajke it
// 100% https://app.codility.com/demo/results/trainingBVFX5A-3DM/

import java.util.Arrays;
class PassingCars { 

	public static void main(String ... args){

                int[] arr1 = {0,1,0,1,1};
                int[] arr2 = {1,0,0,1,1,0,1,1};
                PassingCars s = new PassingCars();
                System.out.println(" solution for: " + Arrays.toString(arr1) + ", is: " + s.solution(arr1));
                System.out.println(" solution for: " + Arrays.toString(arr2) + ", is: " + s.solution(arr2));

        }

	public int solution(int[] A){
    		int right = 0;
    		int passing = 0;
    		for (int index = 0; index < A.length; index++)
		{
			if (A[index] == 1){
            			passing += right;
				if (passing > 1000000000) return -1;	
			}
        		else right += 1;

		}
    		return passing;
	}

	public int solution50of100(int[] A){
		int sum = 0;
		for (int i=0;i<A.length;i++) if (A[i]==0) {
			sum += count( A,i,A.length ,1 );
			if (sum > 1000000000) return -1;
		}		
		return sum;
	} 

	public int count (int[] A, int from, int to, int what){
		int count = 0;
		for (int x = from; x < to; x++)if(A[x]==what)count++;
		return count;
	}
}
