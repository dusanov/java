import java.util.*;
public class CyclicRotation{

        public static void main (String[] args) {

                CyclicRotation cr = new CyclicRotation();
                System.out.println("{3, 8, 9, 7, 6},            3   " + Arrays.toString(cr.solution(new int[]{3, 8, 9, 7, 6},3)));
                System.out.println("{300, 800, 900, -700, 6},   8   " + Arrays.toString(cr.solution(new int[]{300, 800, 900, -700, 6},8)));
                System.out.println("{-700, 6},                          1   " + Arrays.toString(cr.solution(new int[]{-700, 6},1)));
                System.out.println("{-700, 6},                          3   " + Arrays.toString(cr.solution(new int[]{-700, 6},3)));
                System.out.println("{-700},                     9   " + Arrays.toString(cr.solution(new int[]{-700},9)));
                System.out.println("{},                                 9   " + Arrays.toString(cr.solution(new int[]{},9)));
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
    
    /*
    
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
    
    */
}