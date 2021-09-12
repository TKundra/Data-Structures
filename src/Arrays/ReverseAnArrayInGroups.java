package Arrays;
import java.util.Arrays;

public class ReverseAnArrayInGroups {

    // reverse in group
    static void reverseGroups(int[] array, int n, int k){
        for (int i=0; i<n; i+=k){
            int left = i;
            // to handle the case when k is not multiply of n
            int right = Math.min(i+k-1, n-1);
            int temp;
            // reverse sub-array [left,right]
            while (left<right){
                temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }
    }

    // reverse in alternate groups
    static void reverseAlternateGroups(int[] array, int n,int k){
        for (int i=0; i<n; i+=2*k){
            int left = i;
            // to handle the case when k is not multiply of n
            int right = Math.min(i+k-1, n-1);
            int temp;
            // reverse sub-array [left,right]
            while (left<right){
                temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }
    }

    // reverse at given distance
    static void reverseGivenDistance(int[] array, int n, int k, int m){
        for (int i=0; i<n; i+=k+m){
            int left = i;
            // to handle the case when k is not multiply of n
            int right = Math.min(i+k-1, n-1);
            int temp;
            // reverse sub-array [left,right]
            while (left<right){
                temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }
    }

    // reverse by doubling the group
    static void reverseDoubleGroup(int[] array, int k){
        int n = array.length;
        for (int i=0; i<n; i+=k/2){
            int left = i;
            // to handle the case when k is not multiply of n
            int right = Math.min(i+k-1, n-1);
            int temp;
            // reverse sub-array [left,right]
            while (left<right){
                temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
            // double value of k with each iteration
            k = k*2;
        }
    }

    public static void main(String[] args){
        int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        int k = 2;
        int m = 2;
        int n = array.length;
        reverseDoubleGroup(array,k);
        System.out.println(Arrays.toString(array));
    }
}
