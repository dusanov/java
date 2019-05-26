// https://app.codility.com/demo/results/trainingHKKZJB-RZQ/  35 %
//https://app.codility.com/demo/results/trainingZ7ED3U-2DD/ 100 %


import java.util.*;
class Brackets { 

    public static void main(String ... args){
    
        Brackets n = new Brackets();
        
        String s = "([]{}[{}]){}[]()";
    
        System.out.println(" result for "+ s +" is: " + n.solution(s));
    }
    
    public int solution(String S){
    
        Deque<String> stack = new ArrayDeque<String>();
        
        final int len = S.length();
        for (int i = 0; i < len; i++) {
        
            if ( S.charAt(i) == '(' || S.charAt(i) == '[' || S.charAt(i) == '{' )
                stack.push(Character.toString(S.charAt(i)));
            else if ( S.charAt(i) == ')' || S.charAt(i) == ']' || S.charAt(i) == '}' ){
                if (stack.size() == 0 ) return 0;
                if ( ! isValidPair( stack.peek().charAt(0) , S.charAt(i))) return 0;
                else stack.pop();
            }
        }
        
        if (stack.size() != 0 ) return 0;
        
        return 1;
    }

    public boolean isValidPair(char left, char right){
        if (left == '(' && right == ')')
            return true;
        if (left == '[' && right == ']')
            return true;
        if (left == '{' && right == '}')
            return true; 
        return false;                     
    }
                           
}