// https://app.codility.com/demo/results/trainingYPSG53-B53/ 62% nucleotides enum
// https://app.codility.com/demo/results/trainingQ3PXCE-PUS 62% substr
// https://app.codility.com/demo/results/trainingWQJPHZ-MQ6/ 100 % pref sum
import java.util.Arrays;
import java.util.stream.IntStream;
class GenomicRangeQuery{

	public static void main (String ... args){
	
		String dna = "CAGCCTA";
		int[] P = {2,5,0},Q = {4,5,6}; 
		GenomicRangeQuery grq = new GenomicRangeQuery();

		System.out.println(" solution for\n DNA: "+dna+
				",\n P: " +Arrays.toString(P)+
				",\n Q: " +Arrays.toString(Q)+
				//",\n is: " + Arrays.toString( grq.solution(dna,P,Q)) );
				",\n is: " + Arrays.toString( grq.stackOsolution(dna,P,Q)) );
				//",\n is: " + Arrays.toString( grq.newSolution(dna,P,Q)) );
	}

    public int[] newSolution(String S, int[] P, int[] Q ){
    
        int N = P.length; 
        int[] result = new int[N];

        for (int i=0; i < N; i++){
        
            String subGenom = S.substring(P[i],++Q[i]);
            int factor = 4;

            if (subGenom.contains("A")) factor = 1;
            else if (subGenom.contains("C")) factor = 2;
            else if (subGenom.contains("G")) factor = 3;
            
            result[i] = factor;
        }
    
        return result;
    
    }

	enum NUCLEOTIDES {
		A(1),C(2),G(3),T(4);
		private int impactFactor;
		public int getImpactFactor(){return impactFactor;}
		private NUCLEOTIDES(int impactFactor){this.impactFactor=impactFactor;}
	}

	public int[] solution(String S, int[] P, int[] Q){
		int N = P.length;
		int[] result=new int[N];
		String[] dna = S.split("");
		for (int i=0;i<N;i++){
			result[i] = IntStream.range(P[i], ++Q[i])
                                        .map(x -> NUCLEOTIDES.valueOf(dna[x]).getImpactFactor())
					.min().getAsInt();
		}
		return result;
	}

    public static int[] stackOsolution(String S, int[] P, int[] Q) {
        int[][] genoms = new int[3][S.length()+1];
        short a, c, g;
        for (int i=0; i<S.length(); i++) {
            a = 0; c = 0; g = 0;
            if ('A' == (S.charAt(i))) a=1;
            else if ('C' == (S.charAt(i))) c=1;
            else if ('G' == (S.charAt(i))) g=1;
            
            genoms[0][i+1] = genoms[0][i] + a;
            genoms[1][i+1] = genoms[1][i] + c;
            genoms[2][i+1] = genoms[2][i] + g;
        }

        int[] result = new int[P.length];
        for (int i=0; i<P.length; i++) {
            int fromIndex = P[i];
            int toIndex = Q[i]+1;
            if (genoms[0][toIndex] - genoms[0][fromIndex] > 0) result[i] = 1;
            else if (genoms[1][toIndex] - genoms[1][fromIndex] > 0) result[i] = 2;
            else if (genoms[2][toIndex] - genoms[2][fromIndex] > 0) result[i] = 3;
            else result[i] = 4; 
        }
        return result;
    } 

}
