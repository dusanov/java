import java.util.*;
class quadraticmaxsliceA{

    public static void main(String ... args){
        
        int[] arr = {-1,2,-2,1,4,-1,2,2};
        quadraticmaxsliceA q = new  quadraticmaxsliceA();
    
        System.out.println(" for array: " + Arrays.toString(arr));
        System.out.println(" max slice is: " + q.solution(arr));
    
    }
    
    int solution(int[] A){
        int n = A.length, result = 0;
        for (int p = 0; p < n; p++){            
            int sum = 0;
            for (int q = p; q < n; q++){                
                sum += A[q];
                if (sum > result) {
                    System.out.println(" p:" + p + ", q: " + q + ", result: " + result + ", sum: " + sum);                
                    result = sum;
                }
            }
        }
        return result;
    }
}