package Arrays;
import java.util.Arrays;

public class MinimizeTheMaximumDbHeights {

    // modifies array by sub/add k to every element such that
    // difference between max and min is minimized
    static int getMinDifference(int[] array, int n, int k){
        if (n==1)
            return 0;
        // sort all
        Arrays.sort(array);
        // initialize result
        int answer = array[n-1] - array[0];
        // handle corner elements
        int small = array[0] + k;
        int big = array[n-1] - k;
        int temp = 0;
        if (small>big){
            temp = small;
            small = big;
            big = temp;
        }
        // traverse middle element
        for (int i=1; i<n-1; i++){
            int subtract = array[i]-k;
            int add = array[i]+k;
            // if no change diff
            if (subtract >= small || add<=big)
                continue;
            /* either subtraction causes a smaller number or addition causes a
            greater number. Update small or big using greedy approach
            (if big - subtract causes smaller diff, update small else update big) */
            if (big-subtract<=add-small)
                small = subtract;
            else
                big = add;
        }
        return Math.min(answer, big-small);
    }

    public static void main(String[] args){
        int[] array = {1,10,14,14,14,15};
        int k = 6;
        System.out.println(getMinDifference(array, array.length,k));
    }
}
