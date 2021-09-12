package Arrays;
import java.util.Arrays;

public class MissingNumberInArray {

    static int missingNumber(int[] array){
        // array length
        int n = array.length;
        // actual length, as one element is missing
        int m = n+1;
        // get sum of integers b/w 1 and n+1
        int total = m*(m+1)/2;
        // get actual sum of integers
        int sum = Arrays.stream(array).sum();
        // missing number
        return (total-sum);
    }

    public static void main(String[] args){
        int[] array = {1,2,3,4,5,7,8,9,10};
    }
}
