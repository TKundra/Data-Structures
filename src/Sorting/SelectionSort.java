package Sorting;
import java.util.Arrays;

public class SelectionSort {
    /* It is a technique where a array is sequentially sorted by placing the
    smallest or the largest element from the array one after the other in
    multiple iterations. */

    void sort(int[] array){
        int n = array.length;
        for (int i=0; i<n; i++){
            int min = i;
            for (int j=i+1; j<n; j++){
                if (array[j] < array[min])
                    min = j;
            }
            int swap = array[min];
            array[min] = array[i];
            array[i] = swap;
        }
    }

    public static void main(String[] args){
        int[] array = {5,7,9,1,3,2};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
