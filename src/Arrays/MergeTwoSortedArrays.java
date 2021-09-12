package Arrays;

import java.util.HashMap;
import java.util.Map;

public class MergeTwoSortedArrays {
    static void mergeArrays(int[] array1, int[] array2){
        int n = array1.length;
        int m = array2.length;
        Map<Integer, Boolean> map = new HashMap<>();
        // inserting values in map
        for (int j : array1) {
            map.put(j, true);
        }
        for (int j : array2) {
            map.put(j, true);
        }
        // printing keys
        for (Map.Entry<Integer, Boolean> entry : map.entrySet()){
            System.out.print(entry.getKey() + " ");
        }
    }
    public static void main(String[] args){
        int[] array1 = {1,3,5,7};
        int[] array2 = {2,4,6,8};
        mergeArrays(array1, array2);
    }
}
