/**
 *
 *https://app.codility.com/demo/results/trainingRMKQVR-C3E/
 *
 * */

import java.util.Arrays;
public class TieRopes{

        public static void main (String ... args) {

                TieRopes eq = new TieRopes();

                int[] arr = {1,2,3,4,1,1,3};
                int[] arr2 = {5, 6, 2, 4,4,2, 1};
                System.out.println(" solution for: " + Arrays.toString(arr) +", 4, is : " + eq.solution(4, arr));
                System.out.println(" solution for: " + Arrays.toString(arr2) +", 5, is : " + eq.solution(5,arr2));


        }

        public int solution(int X, int[] A){

		int count = 0;
		int currSum = 0;
		for (int curr : A){
			if (curr >= X) { 
				count++;
				currSum=0;
			}else{
				currSum+=curr;
				if (currSum>=X){
					count++;
					currSum=0;
				}
			}
		}
                return count;

        }
}
