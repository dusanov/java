public class BinaryGap {

	public static void main (String[] args){
		
	  while (true){
	
	 	System.out.println("++ enter integer: ");
	
		try {
			int input = Integer.valueOf(System.console().readLine());
			String binary = Integer.toBinaryString(input);
			System.out.println(binary);
			BinaryGap bg = new BinaryGap();
			System.out.println(" === counting : " + bg.solution(input));
		}catch (Exception e){System.exit(-1);}
	
		System.out.println();
	  }
	}

	public int solution(int N) {
	
		String[] binary = Integer.toBinaryString(N).split("");
		int currMax = 0;
		int currCount = 0;
		for (String current : binary){
			if (current.equals("0"))currCount++;
			else if (current.equals("1"))
				if (currCount > 0){		
					//its the end of 0 stream
					if (currCount > currMax) {
						currMax = currCount;
						currCount = 0;
					}
					else {
						currCount = 0;
					}
				
				}
				else {}
		}
		return currMax;
	}

}
