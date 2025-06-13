import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/*
Find the first non-repeating character in a string using Stream API.
 */
public class Stream12 {
    public static void main(String[] args) {
        String input = "leanleetcodewithakrisht";

        System.out.println(
                input
                        .chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.groupingBy(ch -> ch, LinkedHashMap::new, Collectors.counting()))
                        .entrySet()
                        .stream().filter(value -> value.getValue() == 1).
                        map(Map.Entry::getKey).findFirst().orElse(' ')
        );


    }
}
