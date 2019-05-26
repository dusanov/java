import java.util.*;
class MaxProfit{

    public static void main(String ... args){
        
        //int[] arr = {-1,2,-2,1,4,-1,2,2};
        int[] arr = {23171,21011,21123,21366,21013,21367};
        MaxProfit g = new  MaxProfit();
    
        System.out.println(" for array: " + Arrays.toString(arr));
        System.out.println(" max profit is: " + g.solution(arr));
    
    }
    
    int solution(int[] A){
        int max_profit = 0;
        int min_day = 200000; // max A[n]

        for (int day : A){
            
            System.out.println(" current : " + max_profit + ", day: " + day + ", min_day:" + min_day);
            
            min_day = Math.min(min_day, day);
            
                
            if (max_profit < day-min_day){
               
                max_profit = day-min_day;
                System.out.println(" got new max: " + max_profit + ", day: " + day + ", min_day:" + min_day);
            }
        }
        return max_profit;
    }
}