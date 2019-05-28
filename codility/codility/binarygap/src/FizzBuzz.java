public class FizzBuzz {

	public static void main (String [] args){
/*
	  for (int x = 1; x <= 100; x++){
	    if ( x % 3 == 0 && x % 5 == 0 ) System.out.println("fizzbizz: " + x);
	    else if ( x % 5 == 0 ) System.out.println("bizz: " + x);
	    else if ( x % 3 == 0 ) System.out.println("fizz: " + x);
	    else System.out.println(x);
	  }
*/
	  for (int x = 1; x <= 100; x++){
	    String holder = "";
	    if (x % 3 == 0 ) holder +="Fizz";
	    if (x % 5 == 0 ) holder +="Bizz";
	    System.out.println( ( holder.length() == 0 ? x : holder)    );

	  }
        }	

}
