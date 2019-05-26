// https://app.codility.com/demo/results/training6Y9TGF-25C/ 55% bug
// https://app.codility.com/demo/results/trainingYDF6S8-WN7/

import java.util.*;
class MaxSliceSum{

    public static void main(String ... args){
        
        //int[] arr = {-1,2,-2,1,4,-1,2,2};
        int[] arr = {-10};
        MaxSliceSum g = new  MaxSliceSum();
    
        System.out.println(" for array: " + Arrays.toString(arr));
        System.out.println(" max slice is: " + g.solution(arr));
    
    }
    
    int solution(int[] A){
        int max_ending = -1000000, max_slice = -1000000;
        for (int a : A){
            
            max_ending = Math.max(a, max_ending + a);
            max_slice = Math.max(max_slice, max_ending);
            System.out.println(" a: " + a + ", max_ending: " + max_ending + ", max_slice: " + max_slice);
            
        }
        return max_slice;
    }
}