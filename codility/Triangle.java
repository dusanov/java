// 63% bez overflow bez casta u long O(N**3)
//https://app.codility.com/demo/results/trainingNGDFSA-6Q3/ 75% O(N**3)
//https://app.codility.com/demo/results/trainingN54VWM-C3R/ 100% sa sortom O(N*log(N))

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class Triangle { 

    public static void main (String ... args){
    
        Triangle t = new Triangle();
        
        //int[] arr = new int[]{10,2,5,1,8,20};
        //int[] arr = new int[]{2147483647,2147483647,2147483647};
        //int[] arr = new int[]{2,2,2};
        int[] arr = new int[]{-2,-2,2,2,2,-2,-2};
        System.out.println(" result for "+ Arrays.toString(arr) +" is: " + t.solution(arr));
        System.out.println(" result for "+ Arrays.toString(arr) +" is: " + t.solution2(arr));
    }

    public int solution(int[] A){
    
        if (A.length < 3) return 0;
        
        //int P=0,Q=1,R=2;
        
        for (int P = 0; P < A.length-2; P++)
            for (int Q = P+1; Q < A.length-1; Q++)
                for (int R = Q+1; R < A.length; R++)
                    if (    (long)A[P] + (long)A[Q] > A[R] && 
                            (long)A[Q] + (long)A[R] > A[P] && 
                            (long)A[R] + (long)A[P] > A[Q] ) {
            
                                System.out.println("" + P + ", " + Q + ", " + R);
                                return 1;
                    }
        
        return 0;
    } 
    
    public int solution2(int[] A){
    
        if (A.length < 3) return 0;
        
        Arrays.sort(A);
        //triplet is {P,Q,R}
        for (int P = 0; P < A.length-2; P++)
            if ( (long)A[P] + (long)A[P+1] > A[P+2] ) {
                System.out.println("" + A[P] + ", " + A[P+1] + ", " + A[P+2]);
                return 1;
            }
        
        return 0;
    }     
    
}