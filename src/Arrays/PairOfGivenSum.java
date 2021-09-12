package Arrays;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PairOfGivenSum {

    // brute force
    static void pairs(int[] array, int sum){
        for (int i=0; i<array.length-1; i++){
            for (int j=i+1; j<array.length; j++){
                if (array[i]+array[j] == sum){
                    System.out.println("pair " + array[i] + " " + array[j]);
                    return;
                }
            }
        }
        System.out.println("not found");
    }

    // reduce search space
    static void findPairs(int[] array, int sum){
        Arrays.sort(array);
        int low = 0;
        int high = array.length-1;
        while (low<high){
            if (array[low] + array[high] == sum){
                System.out.println("pair " + array[low] + " " + array[high]);
                return;
            }
            if (array[low]+array[high]<sum){
                low++;
            }else {
                high--;
            }
        }
        System.out.println("not found");
    }

    // in linear time
    static void findPair(int[] array, int sum){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<array.length; i++){
            if (map.containsKey(sum-array[i])){
                System.out.println(array[map.get(sum-array[i])] + " " + array[i]);
                return;
            }
            map.put(array[i],i);
        }
        System.out.println("not found");
    }

    public static void main(String[] args){
        int[] array = {8,7,2,5,3,1};
        int sum = 10;
        pairs(array,sum);
    }
}
