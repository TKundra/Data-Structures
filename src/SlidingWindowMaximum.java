import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    static void printArray(int[] array, int k){
        int n = array.length;
        int j, max;
        // take all sub-array of size k
        for (int i=0; i<=n-k; i++){
            max = array[i];
            // get maximum of current sub-array
            for (j=1; j<k; j++){
                if (array[i+j] > max)
                    max = array[i+j];
            }
            System.out.print(max+" ");
        }
    }

    // only useful elements of current window.
    static void printDeque(int[] array, int k){
        Deque<Integer> deque = new LinkedList<>();
        int i, n=array.length;
        for (i=0; i<k; ++i){
            // for every element the previous smaller element s are useless, remove them
            while (!deque.isEmpty() && array[i] >= array[deque.peekLast()])
                deque.removeLast(); // remove from rear
            deque.addLast(i); // add from rear
        }
        // process rest of elements
        for (; i<n; ++i){
            // element at front of queue is the largest element of previous window
            System.out.print(array[deque.peek()] + " ");
            // remove element which are out of this window
            while ((!deque.isEmpty()) && deque.peek() <= i-k)
                deque.removeFirst();
            // remove all element smaller than the currently being added element
            while ((!deque.isEmpty()) && array[i] >= array[deque.peekLast()])
                deque.removeLast();
            deque.addLast(i);
        }
        // print maximum element of last window
        System.out.print(array[deque.peek()] + " ");
    }
    /*  insert index in deque
        if array[i] >= d.back()
            remove
        whenever shifts to new window, perform following operations
            output arr[d.front()]
            remove index not of current window
                index <= i-k
    */

    public static void main(String[] args){
        int[] array = {12, 1, 78, 90, 57, 89, 56};
        int k = 3;
        printDeque(array, k);
    }
}
