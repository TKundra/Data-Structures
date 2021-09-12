package Arrays;
import java.util.Arrays;
import java.util.List;

public class LargestNumberFormedFromArray {
    public static void main(String[] args){
        List<String> numbers = Arrays.asList("1","6","9","3");
        // sort
        numbers.sort((a,b) -> (b+a).compareTo(a+b));
        // print
        numbers.forEach(System.out::println);
    }
}
