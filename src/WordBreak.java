import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

// Dynamic Programing
public class    WordBreak {

    static void wordBreak(List<String> dictionary, String string, String output){
        // if end of string is reached print output string
        if (string.length() == 0){
            System.out.println(output);
            return;
        }
        for (int i=1; i<=string.length(); i++){
            // consider all prefix of the current string
            String prefix = string.substring(0,i);
            // if prefix is present in dictionary, add it in output string
            // and recur for remaining string
            if (dictionary.contains(prefix)) {
                wordBreak(dictionary, string.substring(i), output + " " + prefix);
            }
        }
    }

    public static void main(String[] args){
        List<String> dictionary = Arrays.asList(
                "i","like","sam","sung","samsung","mobile",
                "ice","cream","icecream","man","go","mango"
        );
        String string = "ilike";
        wordBreak(dictionary, string, "");
    }
}
