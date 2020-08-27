import static java.util.stream.Collectors.*;
import java.util.Arrays;

public class D {

    public static void main(String...ags) {
        double[] dd = {10.0,20.0,300.0};

        System.out.println(
            Arrays.stream(dd).max().getAsDouble()
        );
        System.out.println(
            Arrays.stream(dd).average().getAsDouble()
        );
    }
}
