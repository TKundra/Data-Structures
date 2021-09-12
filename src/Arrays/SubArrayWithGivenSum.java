package Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SubArrayWithGivenSum {

    // brute force
    static void findSubArray(int[] array, int sum){
        for (int i=0; i<array.length; i++){
            int sum_of_element = 0;
            // consider all sub-array starting from i and ending at j
            for (int j=i; j<array.length; j++){
                sum_of_element += array[j];
                if (sum_of_element == sum){
                    System.out.println(
                            IntStream.range(i,j+1)
                                    .mapToObj(k -> array[k])
                                    .collect(Collectors.toList())
                    );
                }
            }
        }
    }

    // HashMap
    static void findSubArray(int[] array, int n, int sum){
        // curr_sum to keep track of cumulative sum till that point
        int curr_sum = 0, start = 0, end = -1;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i=0; i<n; i++){
            curr_sum += array[i];
            // check whether curr_sum-sum = 0, if 0 it means
            // the sub-array is starting from index 0 - so stop
            if (curr_sum - sum == 0){
                start = 0;
                end = i;
                break;
            }
            // if hashMap already has value, means we already
            // have sub-array with the sum - so stop
            if (hashMap.containsKey(curr_sum-sum)){
                start = hashMap.get(curr_sum-sum)+1;
                end = i;
                break;
            }
            // if end is -1 : means we have reached end without the sum
            if (end == -1){
                System.out.println("no sub-array exists");
            }else {
                System.out.println(start + " to " + end);
            }
        }
    }

    public static void main(String[] args){
        int[] array_p = {3,4,-7,1,3,3,1,-4};
        int sum = 7;
        findSubArray(array_p, array_p.length, sum);
    }
}
