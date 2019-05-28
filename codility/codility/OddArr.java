public class OddArr{

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 9, 3, 9, 3, 9, 7, 9 }));

	}

	public static int solution(int[] A) {
		int elem = 0;
		for (int curr : A) elem ^= curr;
		return elem;
	}

}
