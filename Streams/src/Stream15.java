import java.util.Arrays;
import java.util.List;

/**Flatten a list of lists using Stream API.*/

public class Stream15 {

    public static void main(String[] args) {
        List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8)
        );

        List<Integer> ans = nestedList.stream().flatMap(ele->ele.stream().map(e->e)).toList();
        System.out.println(ans);
    }
}
