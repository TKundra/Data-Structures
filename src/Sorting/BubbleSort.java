package Sorting;
import java.util.Arrays;

public class BubbleSort {

    /* Bubble Sort, also known as Exchange Sort, It is elementary
    sorting algorithm for various data structure. It is a comparison
    based sorting algorithm in which each element is compared with
    the next element, and is swapped if those elements are not in
    correct order */

    void sort(int[] array){
        for (int i=0; i<array.length; i++){
            for (int j=i+1; j<array.length; j++){
                if (array[i] > array[j]) {
                    int swap = array[i];
                    array[i] = array[j];
                    array[j] = swap;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args){
        int[] array = {5,7,8,5,3,2,1};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(array);
    }
}
