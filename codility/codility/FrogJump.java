public class FrogJump {

	public static void main (String ... args){
	
		FrogJump fg = new FrogJump();
		System.out.println(" this many for x10 y85 d30 = " + fg.solution( 10, 85, 30));
		System.out.println(" this many for x1 y5 d2 = " + fg.solution( 1, 5, 2));

	}

	public int solution(int X, int Y, int D){ return ( ((Y-X)%D==0) ? ((int)((Y-X)/D)) :  (int)((Y-X)/D)+1); }

}
