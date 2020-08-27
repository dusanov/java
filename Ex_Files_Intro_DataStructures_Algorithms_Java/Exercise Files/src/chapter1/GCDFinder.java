package chapter1;


public class GCDFinder {
	
	
	
	/**
	 * This method takes two positive integers and finds their gcd using 
	 * Euclid's algorithm
	 * @param a
	 * @param b
	 * @return
	 */
	public int gcd(int a, int b) {
    System.out.println("a: " + a + ", b: " + b);
		if (b == 0) return a;
		return gcd(b, a % b);
	}	
	
	public static void main(String[] args) {
		System.out.println(new GCDFinder().gcd(33, 7)); // should print 5
	}
}
