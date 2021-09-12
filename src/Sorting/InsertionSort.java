package Sorting;
import java.util.Arrays;

public class InsertionSort {

    /*  this is in-place comparison based sorting algorithm,
        which is idle for small data-sets. Insertion sort is
        a rebalanced of the way we sort playing cards in our
        hand. In this algorithm, we try to insert the elements of
        the array into an already sorted array. Value from
        unsorted part picked and placed at the correct position
        in the sorted part. So that sorted portion increases and
        unsorted portion decreases.
        It is not the best sorting algorithm in terms of performance,
        but it's slightly more efficient than selection sort and bubble
        sort in practical scenarios */
    void sort(int[] array){
        int n = array.length;
        for (int i=1; i<n; i++){
            int key = array[i];
            int j = i-1;
            while (j>=0 && array[j] > key){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
        }
    }

    public static void main(String[] args){
        int[] array = {5,7,9,1,3,2,9};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(array);
        System.out.print(Arrays.toString(array));
    }
}
