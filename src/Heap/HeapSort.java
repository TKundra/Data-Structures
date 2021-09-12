package Heap;
import java.util.Arrays;

public class HeapSort {

    void swap(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    void heapIfy(int[] array, int size, int i){
        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;
        if (left<size && array[left]>array[largest])
            largest = left;
        if (right<size && array[right]>array[largest])
            largest = right;
        if (largest!=i){
            swap(array, i, largest);
            heapIfy(array, size, largest);
        }
    }

    void heapSort(int[] array){
        int size = array.length;
        for (int i=size/2-1; i>=0; i--)
            heapIfy(array, size, i);
        /*one by one extract element form heap */
        for (int i=size-1; i>0; i--){
            swap(array, 0, i);
            heapIfy(array, i, 0);
        }
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args){
        int[] array = {15,5,20,1,17,10,30};
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(array);
    }
}
