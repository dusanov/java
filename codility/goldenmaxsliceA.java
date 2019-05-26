import java.util.*;
class goldenmaxsliceA{

    public static void main(String ... args){
        
        int[] arr = {-1,2,-2,1,4,-1,2,2};
        goldenmaxsliceA g = new  goldenmaxsliceA();
    
        System.out.println(" for array: " + Arrays.toString(arr));
        System.out.println(" max slice is: " + g.solution(arr));
    
    }
    
    int solution(int[] A){
        int max_ending = 0, max_slice = 0;
        for (int a : A){
            
            max_ending = Math.max(0, max_ending + a);
            max_slice = Math.max(max_slice, max_ending);
            System.out.println(" a: " + a + ", max_ending: " + max_ending + ", max_slice: " + max_slice);
            
        }
        return max_slice;
    }
}