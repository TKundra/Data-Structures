package Sorting;
import java.util.Arrays;

public class QuickSort {

    int partitioning(int[] array, int low, int high){
        int i = (low-1);
        /* last element as pivot */
        int pivot = array[high];
        /* put element smaller than pivot on the left
           put element greater than pivot on the right */
        for (int j=low; j<=high-1; j++){
            /* compare all elements with pivot
			    swap the element greater than pivot
			    with element smaller than pivot
                to sort. */
            if (array[j] < pivot){
                i++;
                int swap = array[j];
                array[j] = array[i];
                array[i] = swap;
            }
        }
        /* put pivot in position
			so element on left are smaller
			element on right are greater than pivot 
			and you found pivot at correct position
			and on left side of pivot everything is smaller than pivot
			on right side greater than pivot.
            then value pass to quikSort function.*/
        int swap = array[i+1];
        array[i+1] = array[high];
        array[high] = swap;
        return i+1;
    }

    /*  Quick sort also known as partition-exchange sort. Quick Sort is sorting
        algorithm, used in data structures for sorting arrays, queues, linked lists
        and other linear data structures. Quick sort works on principle of divide and
        Conquer */
    void sort(int[] array, int low, int high){
        if (low<high){
            int pivot = partitioning(array, low, high);
            sort(array, low, pivot-1);
            sort(array, pivot+1, high);
        }
    }

    public static void main(String[] args){
        int[] array = {5,7,9,1,3,2,9};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(array, 0, array.length-1);
        System.out.print(Arrays.toString(array));
    }
}
