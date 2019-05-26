import java.util.*;

class MayerMoore<T> {
    
    private List<T> arr;
    
    public MayerMoore (T[] arr) {
    
        this.arr = Arrays.asList(arr);
    }

    public static void main (String ... args){
    
        
        Integer[] arr1 = {4,3,4,4,4,2};//;
        //Character[] arr1 = {'a','C','a','b','b','C','b','b','C','b','b','C','C','C','b'};
        String[]    arr2 = {"qwe","1","22","33","22","qwe","qwe","qwe","qwe"};
        Integer[]   arr3 = {1,1,1,2,2,3,4,5,6,4,3,3,4,4332,3,3,3,3};
        Integer[]   arr4 = {1,3,1,1,2};//{1,2,3,4,5,6,7,8,9,9};
        
        MayerMoore<?> mm1 = new MayerMoore<Integer>(arr1);
        MayerMoore<?> mm2 = new MayerMoore<String>(arr2);
        MayerMoore<?> mm3 = new MayerMoore<Integer>(arr3);
        MayerMoore<?> mm4 = new MayerMoore<Integer>(arr4);
        
        Integer leader1 = (Integer)mm1.getLeader();
        Integer leader4 = (Integer)mm4.getLeader();
        
        System.out.println(" For array : " + Arrays.toString(arr1) + ", leader is: " + leader1);
        //System.out.println(" For array : " + Arrays.toString(arr2) + ", leader is: " + mm2.getLeader());
        //System.out.println(" For array : " + Arrays.toString(arr3) + ", leader is: " + mm3.getLeader());
        System.out.println(" For array : " + Arrays.toString(arr4) + ", leader is: " + leader4);
    
        System.out.println(" num of equi leaders for: " + Arrays.toString(arr1) + 
                           ", and leader: " + leader1 + 
                           ", is: " + mm1.getNumOfEquiLeaders(leader1));
        
        
        System.out.println(" num of equi leaders for: " + Arrays.toString(arr4) + 
                           ", and leader: " + leader4 + 
                           ", is: " + mm4.getNumOfEquiLeaders(leader4));
        
    }
    
    T getLeader(){
    
        T candidate = null;
        int counter = 0;
        for (T t : arr){
            if (counter == 0){ candidate = t; counter = 1; }
            else { if (candidate==t) { counter++; } else counter--; }
    //        System.out.println("====  counter: " + counter + ", currentC " + candidate + ", t: " + t);
        }
        
        int confirm = 0;
        int index = -1;
        int arrLength = arr.size();
        //for (T t : arr){
        for (int x = 0; x < arrLength; x++)
            if (arr.get(x)==candidate){confirm++;index=x;}
        
        return (confirm > arrLength / 2 ? candidate : null );
    }
    
    int getNumOfEquiLeaders(Object leader){
        
        int confirm = 0;
        int index = -1;
        int arrLength = arr.size();
        
        for (int x = 0; x < arrLength; x++)
            if (arr.get(x)==leader){confirm++;index=x;}
        
        int equi_leaders = 0;
        int ldrCount = 0;
        for(int i = 0; i < arrLength; i++){
            if(arr.get(i) == leader) ldrCount++;
            int leadersInRightPart = (confirm - ldrCount);
            if(ldrCount > (i+1)/2   &&   leadersInRightPart > (arrLength-i-1)/2){
                equi_leaders++;
            }
        }

        return equi_leaders;    
    
    }

}