// https://app.codility.com/demo/results/trainingDWWK3Z-GBZ/ 100%


import java.util.*;
class EquiLeaderFinal { 

    public static void main(String ... args){
    
        EquiLeaderFinal d = new EquiLeaderFinal();
        //int[] arr = {3,4,3,2,3,-1,3,3};
        //int[] arr = {4,3,4,4,4,2};
        int[] arr = {0,-1000000000, -1000000000, 0, -1000000000};
        System.out.println(" == for array : " + Arrays.toString(arr));        
        int equiLeaders = d.solution(arr);
        System.out.println(" == number of equi leaders is: " + equiLeaders);
    
    }

    public int solution(int[] A){
    
        int candidate = 0;
        int counter = 0;
        for (int t : A){
            if (counter == 0){ candidate = t; counter = 1; }
            else { if (candidate==t) { counter++; } else counter--; }
    //        System.out.println("====  counter: " + counter + ", currentC " + candidate + ", t: " + t);
        }
        
        int confirm = 0;
        int index = -1;
        int arrLength = A.length;

        for (int x = 0; x < arrLength; x++)
            if (A[x]==candidate){confirm++;index=x;}    
    
        if (confirm <= arrLength / 2) return 0;
    
        int equi_leaders = 0;
        int ldrCount = 0;
        for(int i = 0; i < arrLength; i++){
            if(A[i] == candidate) ldrCount++;
            int leadersInRightPart = (confirm - ldrCount);
            if(ldrCount > (i+1)/2   &&   leadersInRightPart > (arrLength-i-1)/2){
                equi_leaders++;
            }
        }

        return equi_leaders;    
        
    }    
}