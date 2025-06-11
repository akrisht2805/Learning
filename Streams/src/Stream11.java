import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**How would you use Java Stream API to find the second-highest number in a list of integers?
 * */

public class Stream11 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 1, 3, 7, 9, 7, 9);

        System.out.println(
                numbers.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(null)
        );
    }
}
