//https://app.codility.com/demo/results/training5JHQRC-DXZ/ 100%

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
class Distinct { 

    public static void main (String ... args){
    
        Distinct d = new Distinct();
        
        int[] arr = new int[]{1,1,5,5,5};
        System.out.println(" result for "+ Arrays.toString(arr) +" is: " + d.solution(arr));
    
    }

    public int solution(int[] A){
    
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        for (int i : A) map.put(i,i);
        
        return map.size();
    } 
    
}