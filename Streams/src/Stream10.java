import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Input = "hello to world hello to Akrisht";
 *
 * OutPut >
 * world = 1
 * to = 2
 * hello = 2
 * Akrisht = 1
 * */

public class Stream10 {

    public static void main(String[] args) {
        String input = "hello to world hello to Akrisht";
        List<String> temp = Arrays.asList(input.split(" "));

        Map<String, Long> res = temp.stream().collect(Collectors.groupingBy(word->word,Collectors.counting()));
        res.forEach((key,val)->{
            System.out.println(key+" = "+val);
        });
    }

}
