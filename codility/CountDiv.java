// https://app.codility.com/demo/results/trainingSFXGWC-XG6/ 50%
/*

1,2,3,4,5 / 3 => ( 5 / 3 ) - ( 1 / 3 ) + (1 % 3 == 0 ? 1 : 0) = 1 - 0 + 0 = 1

21,22,23,24,25 / 3 => ( 25 / 3 ) - ( 21 / 3 ) + (21 % 3 == 0 ? 1 : 0) = 8 - 7 + 1 = 2


*/
class CountDiv { 
    
    public static void main (String ... args){
    
        CountDiv cd = new CountDiv();
        /*
        System.out.println(" result for 3,33,5 is: " + cd.solution(3,33,5));
        System.out.println(" result for 3,33,5 is: " + cd.solution2(3,33,5));
        System.out.println(" result for 3,33,5 is: " + cd.solution3(3,33,5));
        System.out.println(" result for 3,33,5 is: " + cd.solution4(3,33,5));
        System.out.println(" result for 10,10,5 is: " + cd.solution(10,10,5));
        System.out.println(" result for 10,10,5 is: " + cd.solution2(10,10,5));
        System.out.println(" result for 10,10,5 is: " + cd.solution3(10,10,5));
        System.out.println(" result for 10,10,5 is: " + cd.solution4(10,10,5));
        */
        System.out.println(" result for 21,25,3 is: " + cd.solution(21,25,3));
        System.out.println(" result for 21,25,3 is: " + cd.solution2(21,25,3));
        System.out.println(" result for 21,25,3 is: " + cd.solution3(21,25,3));
        System.out.println(" result for 21,25,3 is: " + cd.solution4(21,25,3));
    
    }
    
	public int solution4(int A, int B, int K) {
		// write your code in Java SE 8
		int count = 0;
		int div1 = 0;
		int div2 = 0;

		div1 = A / K;
		div2 = B / K;
		count = div2 - div1;
		if (A % K == 0) count++;

        System.out.println(" div1: " + div1 + ", div2: " + div2 + ", count: " + count);
        
		return count;
	}    
    

    public int solution(int A, int B, int K){   return  (B/K) - (A /K) + ( A % K == 0 ? 1 : 0);     } 

    public int solution2(int A, int B, int K){
        
        int count = 0;
        for (int x = A; x <= B; x++)
        {
            if (x % K == 0){
                System.out.println(" got this one: " + x);
                count++;
            }
        }
        return count;
        
    }
    

    public int solution3(int A, int B, int K) {
        int count = 0;
        int counter=A;
        while(counter<=B){
            if(counter % K==0){
                count = Math.abs(((B - counter) /K)+1);
                break;
            }
            else if(counter/K == 0){
                counter = K;
            }
            else{
                counter = counter + (counter %K);
            }
            System.out.println(" ++ counter: " + counter + ", count: " + count);
        }
        
        System.out.println(" ++ counter: " + counter + ", count: " + count);
        return count;
    }    
    
    

}
