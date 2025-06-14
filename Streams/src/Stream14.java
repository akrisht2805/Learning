import java.util.Arrays;
import java.util.List;

/**Convert a comma-separated string of numbers into a list of integers.*/
public class Stream14 {
    public static void main(String[] args) {
        String str = "1,232,232,43,43,4,5424325,334,3456,7,7";
        String[] strArr = str.split(",");
        List<Integer> ans = Arrays.stream(strArr).map(ele->Integer.parseInt(ele)).toList();
        System.out.println(ans);
    }
}
