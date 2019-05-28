import java.util.stream.*;
import java.util.Arrays;
public class PermCheck{

        public static void main (String ... args) {

                PermCheck eq = new PermCheck();
                int[] arr = {4,1,3,2};
                int[] arr2 = {5,1,3,2};
                int[] arr3 = {1, 4, 1};
                System.out.println(" solution for: " + Arrays.toString(arr) +" is : " + eq.solution(arr));
                System.out.println(" solution for: " + Arrays.toString(arr2) +" is : " + eq.solution(arr2));
                System.out.println(" solution for: " + Arrays.toString(arr3) +" is : " + eq.solution(arr3));

        }

        public int solution(int[] A){

		int N = A.length;
		int[] B = new int[N];          
		long sum = 0;
		for (int i : A){
			System.out.println(i);
                        if (i>N)return 0;
                        if (B[i-1]>0)return 0;
                        B[i-1]++;	
			sum += i;
		}
		long realSum =  N * (N + 1) / 2;

		System.out.println(" sum: " + sum  + ", realSum: " + realSum);

                return ((sum==realSum?1:0));

        }
}
