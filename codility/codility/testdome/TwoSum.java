public class TwoSum {
    public static int[] findTwoSum(int[] list, int sum) {
 //       throw new UnsupportedOperationException("Waiting to be implemented.");
    
    	for (int x = 0; x < list.length; x++){
	
		for (int y = x+1; y < list.length; y++){
		
			if (list[x]+list[y]==sum) return new int[] {x,y};

		}
	
	}
    
	return null;
    }

    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] { 3, 1, 5, 7, 5, 9 }, 10);
        if(indices != null) {
            System.out.println(indices[0] + " " + indices[1]);
        }
    }
}
