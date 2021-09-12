package Arrays;
import java.awt.*;
import java.util.Arrays;
import java.util.Stack;

public class BeforeSmallerAfterGreater {

    static void findElement(int[] array){
        Stack<Integer> stack = new Stack<>();
        for (int value : array){
            // pop all that are less than current element
            while (!stack.isEmpty() && stack.peek()<value){
                stack.pop();
            }
            // push current element
            stack.push(value);
        }
        // print elements
        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }

    // better
    static int findElement(int[] array, int n){
        int[] maxLeft = new int[n];
        maxLeft[0] = Integer.MIN_VALUE;
        // fill left
        for (int i=1; i<n; i++)
            maxLeft[i] = Math.max(maxLeft[i-1], array[i-1]);
        System.out.println(Arrays.toString(maxLeft));
        // initialize minimum from right
        int minRight = Integer.MAX_VALUE;
        // traverse array from right
        for (int i=n-1; i>=0; i--){
            // check if we found right element
            System.out.println(minRight);
            if (maxLeft[i]<array[i] && minRight>array[i])
                return i;
            // update right minimum
            minRight = Math.min(minRight, array[i]);
        }
        // no such element found
        return -1;
    }

    public static void main(String[] args){
        int[] array = {5,1,4,3,6,8,10,7,9};
        System.out.println("element of index " + findElement(array, array.length));
    }
}
