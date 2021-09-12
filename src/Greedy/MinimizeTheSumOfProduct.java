package Greedy;
import java.util.Arrays;

public class MinimizeTheSumOfProduct {
    static long findValue(int[] arrayA, int[] arrayB, int n){
        long result = 0;
        for (int i=0; i<n; i++){
            result += ((long) arrayA[i] *arrayB[n-i-1]);
        }
        return result;
    }
    public static void main(String[] args){
        int[] arrayA = {3,1,1};
        int[] arrayB = {6,5,4};
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        System.out.println(findValue(arrayA,arrayB,arrayA.length));
    }
}
