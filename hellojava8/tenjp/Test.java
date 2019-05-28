import java.util.*;
import java.util.stream.*;
public class Test {

	public static void main(String ... list){

		Stream.of(list)
			.filter(arg -> arg.endsWith("1"))
			.forEach(System.out::println);
	
		IntSummaryStatistics stats = Stream.generate(() -> (int) (Math.random()*100))
			.mapToInt(rand -> rand)
			.limit(40)
			//.sorted()
			.peek(System.out::println)
			.summaryStatistics();
	
		System.out.println(stats);	
	}
}
