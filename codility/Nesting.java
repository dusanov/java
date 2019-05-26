//https://app.codility.com/demo/results/trainingZFBW7S-BJR/ O(N) 100%

class Nesting { 

    public static void main(String ... args){
    
        Nesting n = new Nesting();
        
        String s = "(()())(())()";
    
        System.out.println(" result for "+ s +" is: " + n.solution(s));
    }
    
    public int solution(String S){
    
        int counter = 0;
    
        final int len = S.length();
        for (int i = 0; i < len; i++) {
            if (S.charAt(i) == '(') counter ++;
            else if (S.charAt(i) == ')') counter --;
            if (counter < 0) return 0;
        }
        return (counter == 0 ? 1 : 0);
    }

}