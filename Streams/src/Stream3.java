import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * INPUT : {"Apple", "Banana", "Guava"}
 * OUTPUT : {
 *     a -> 6
 *     e -> 1
 *     o ->
 *     i ->
 *     u -> 1
 * }
 * */
public class Stream3 {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("Apple","Banana","Guava");

        Map<Character,Long> ans = list.stream().flatMap(ele-> ele.toLowerCase().chars().mapToObj(c ->(char) c) ).
                filter(ch -> ch=='a'|| ch=='e'|| ch =='i' || ch=='o' || ch=='u').collect(Collectors.groupingBy(ch->ch,Collectors.counting()));

        ans.forEach((k,v)->{
            System.out.println(k+" -> "+v);
        });

    }
}
