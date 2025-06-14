import java.util.Arrays;
import java.util.List;

/**Find the common elements between two lists using Stream.*/
public class Stream13 {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,2,3,5,5,3,4,7,8,9);
        List<Integer> list2 = Arrays.asList(2,4,6,8);

        List<Integer> ans = list1.stream().filter(num->list2.contains(num)).toList();

        System.out.println(ans);
    }
}
