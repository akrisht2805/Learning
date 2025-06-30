import java.util.*;
import java.util.stream.Collectors;

public class Sample2 {

    /*
    Group words by their length using the Stream API.

    Input:
    List<String> words = Arrays<.>asList("apple", "bat", "car", "dog", "elephant"); 

    Expected Output:
    {3=[bat, car, dog], 5=[apple], 8=[elephant]}
     */
    public static void main(String[] args) {
//        List<String> words = Arrays.asList("apple", "bat", "car", "dog", "elephant");

//        System.out.println(
//                words.stream().collect(Collectors.groupingBy(ele->ele.length()))
//        );

//        HashMap<Integer, List<String> > ans = new HashMap<>();
//        for(int i=0; i<words.size(); i++){
//            int len =  words.get(i).length();
//            ans.putIfAbsent(len, new ArrayList<>());
//            ans.get(len).add(words.get(i));
//        }
//
//        System.out.println(ans);


//        Question:
//        Sort strings first by length, then alphabetically.

//                Input:
//        List<String> names = Arrays<.>asList("John", "Anna", "Alex", "Bob", "Zoe");
// 
//        Expected Output:
//[Bob, Zoe, Alex, Anna, John]


        List<String> names = Arrays.asList("John", "Anna", "Alex", "Bob", "Zoe");

        System.out.println(
                names.stream().sorted(Comparator.naturalOrder()).sorted(Comparator.comparingInt(ele->ele.length())).toList()
        );


    }
}
