// https://app.codility.com/demo/results/trainingZSE9PK-586/ 100%

import java.util.*;
class Dominator { 

    public static void main(String ... args){
    
        Dominator d = new Dominator();
//        int[] arr = {3,4,3,2,3,-1,3,3};
        int[] arr = {3, 2, 3, -1, 3, 3};
        
        int dominator = d.solution(arr);
        System.out.println(" for array : " + Arrays.toString(arr) + ", dominator last index is: " + dominator + ", value: " + (dominator==-1?-1:arr[dominator]));
    
    }

    public int solution(int[] A){
    
        int Alength = A.length;
        int numToReach = Alength / 2;
        
        System.out.println(" numToReach: " + numToReach + ", length: " + Alength);
        
        Map<Integer,IndexAndCount> countMap = new HashMap<Integer,IndexAndCount>();
        
        for (int i = 0; i < Alength; i++){
        
            if (countMap.get(A[i]) == null) countMap.put(A[i],new IndexAndCount(i,1));
            else countMap.put(A[i],new IndexAndCount(i,++countMap.get(A[i]).count));
            
            if (countMap.get(A[i]).count > numToReach) return countMap.get(A[i]).lastIndex;
        }
        
        
        System.out.println(" countMap: " + countMap );
        
        
        return -1;
    }
    

    class IndexAndCount{
        int lastIndex;
        int count;
        IndexAndCount( int lastIndex,int count){this.lastIndex = lastIndex; this.count = count; }
        public String toString(){ return "lastIndex="+lastIndex+",count="+count;}
    } 
    
}