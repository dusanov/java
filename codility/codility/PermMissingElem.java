import java.util.stream.*;
public class PermMissingElem{

	public static void main (String ... args){
	
		PermMissingElem pme = new PermMissingElem();
		System.out.println(" missing elem is: " + pme.solution(new int[] {2,3,1,5}));
	}

	public int solution(int[] A){

		long sum = IntStream.of(A).sum();
		long realSum =  (A.length + 1) * (A.length+ 1 + 1) / 2;
	
		System.out.println(" sum: " + sum + ", realSum: " + realSum);
		
//		return (int)(realSum - sum);

		long N = A.length + 1;
		return (int)((N * (N + 1) / 2)) - (IntStream.of(A).sum());
	}

}
