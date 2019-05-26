// https://app.codility.com/demo/results/training8QS2EY-WE8/ 33% :)
// https://app.codility.com/demo/results/trainingTNC8C6-V8N/ 55% O(N ** 2)
// https://app.codility.com/demo/results/trainingUJCXX5-6VT/ 66% O(N ** 2)
// https://app.codility.com/demo/results/trainingZCBY3D-BDX/ 66% O(N ** 2)

// https://app.codility.com/demo/results/trainingZEV2MM-Y52/ 33%
// https://app.codility.com/demo/results/trainingFG33S4-FJW/ 44% borba 
// https://app.codility.com/demo/results/trainingB62Q4E-ND7/ 44%

import java.util.*;
class EquiLeader { 

    public static void main(String ... args){
    
        EquiLeader d = new EquiLeader();
        //int[] arr = {3,4,3,2,3,-1,3,3};
        //int[] arr = {4,3,4,4,4,2};
        //int[] arr = {1,2,1,2,1,2,1,2,1,2,2,2,1,1,2,1,2,1,2,1,2,1,1,1,2,1,2};
        //int[] arr = { -1000000000};
        int[] arr = { -1000000000,-1000000000,-1000000000,-1000000000,-1000000000,-1000000000,-1000000000,-1000000000,-1000000000,-1000000000,-1000000000};
        System.out.println(" == for array : " + Arrays.toString(arr));        
        int equiLeaders = d.solution(arr);
        System.out.println(" == number of equi leaders is: " + equiLeaders);
    
    }

    public int solution(int[] A){
    
        int Alength = A.length;
        int numToReach = Alength / 2;
        
        System.out.println(" numToReach: " + numToReach + ", length: " + Alength);
        
        Map<Integer,IndexAndCount> countMap = new HashMap<Integer,IndexAndCount>();
        
        int leader = 0;
        int confirm = 0;
        int index = -1;
        
        for (int i = 0; i < Alength; i++){
        
            if (countMap.get(A[i]) == null) countMap.put(A[i],new IndexAndCount(i,1));
            else countMap.put(A[i],new IndexAndCount(i,++countMap.get(A[i]).count));
            
            if (countMap.get(A[i]).count > numToReach) {
                leader = A[i];
                confirm = countMap.get(A[i]).count;
                index = countMap.get(A[i]).lastIndex;
                break;
            }
        }
        
        
        System.out.println(" leader: " + leader + ", confirm: " + confirm + ", index: " + index );        
        System.out.println(" countMap: " + countMap );        
        
        int equiLeaders = 0;
        int ldrCount = 0;
        for(int i = 0; i < Alength; i++){
            if(A[i] == leader) ldrCount++;
            int leadersInRightPart = (confirm - ldrCount);
            if(ldrCount > (i+1)/2   &&   leadersInRightPart > (Alength-i-1)/2){
                equiLeaders++;
            }
        }

        return equiLeaders;
    }
    
    class IndexAndCount{
        int lastIndex;
        int count;
        IndexAndCount( int lastIndex,int count){this.lastIndex = lastIndex; this.count = count; }
        public String toString(){ return "lastIndex="+lastIndex+",count="+count;}
    }  
    
}