import java.util.*;
import java.util.stream.*;
public class CyclicRotation{

        public static void main (String[] args) {

                CyclicRotation cr = new CyclicRotation();
                System.out.println("{3, 8, 9, 7, 6},		3   " + Arrays.toString(cr.solution(new int[]{3, 8, 9, 7, 6},3)));
                System.out.println("{300, 800, 900, -700, 6},	8   " + Arrays.toString(cr.solution(new int[]{300, 800, 900, -700, 6},8)));
                System.out.println("{-700, 6},   			1   " + Arrays.toString(cr.solution(new int[]{-700, 6},1)));
                System.out.println("{-700, 6},   			3   " + Arrays.toString(cr.solution(new int[]{-700, 6},3)));
                System.out.println("{-700},   			9   " + Arrays.toString(cr.solution(new int[]{-700},9)));
                System.out.println("{},   				9   " + Arrays.toString(cr.solution(new int[]{},9)));
        }

        public int[] solution(int[] A, int K){

		if (A.length == 0) return A;
		int mod = K % A.length;	
		if (mod == 0) return A;
                int[] a = Arrays.copyOfRange(A,0,A.length-mod);
                int[] b = Arrays.copyOfRange(A,A.length-mod,A.length);
                int[] B = new int[A.length];
                System.arraycopy(b,0,B,0,b.length);
                System.arraycopy(a,0,B,b.length,a.length);

                return B;

	}
}
