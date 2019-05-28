import java.util.Arrays;
public class FrogRiverOne{

        public static void main (String ... args) {

                FrogRiverOne eq = new FrogRiverOne();
                int[] arr = {1,3,1,4,2,3,5,4};
                int[] arr2 = {5, 6, 2, 4, 1};
                System.out.println(" solution for: " + Arrays.toString(arr) +",5  is : " + eq.solution(arr,5));
                System.out.println(" solution for: " + Arrays.toString(arr2) +",4 is : " + eq.solution(arr2,4));
                System.out.println(" solution for: " + Arrays.toString(arr) +",4  is : " + eq.solution(arr,4));
        }

        public int solution(int[] A, int X){

		int N = A.length;
		int[] B = new int[X];
		int leafs = 0, index = 0;
		while (leafs < X && index < N){
			if (A[index]<=X)
				if (B[A[index]-1]==0){
					leafs++;
					B[A[index]-1]++;
				}
			System.out.println("index: "+index+", leafs: "+leafs+", A[index]: "+ A[index]);
			index++;
		}
                return (leafs < X ? -1 : index-1);

        }
}
