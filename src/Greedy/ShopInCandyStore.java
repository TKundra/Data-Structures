package Greedy;
import java.util.Arrays;

public class ShopInCandyStore {
    static int findMinimum(int[] array, int n, int k){
        int result = 0;
        for (int i=0; i<n; i++){
            // buy current candy
            result += array[i];
            // take k candies for free from last
            n -= k;
        }
        return result;
    }
    static int findMaximum(int[] array, int n, int k){
        int result = 0, index = 0;
        for (int i=n-1; i>=index; i--){
            // buy current candy with max price
            result += array[i];
            // k candies for free from starting
            index += k;
        }
        return result;
    }
    public static void main(String[] args){
        int[] array = {3,2,1,4};
        int k = 2;
        Arrays.sort(array); // send sorted array
        System.out.println("min price " + findMinimum(array, array.length, k));
        System.out.println("max price " + findMaximum(array, array.length, k));
    }
}
