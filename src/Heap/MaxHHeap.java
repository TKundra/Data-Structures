package Heap;
import java.util.Arrays;

public class MaxHHeap {

    static void heapIfy(int[] array, int size, int i){
        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;
        if (left<size && array[left] > array[largest])
            largest = left;
        if (right<size && array[right] > array[largest])
            largest = right;
        /*  if largest is not root
	        as before i and largest were same, after
	        if largest updated then we check first before
	        swapping.
			where recursive call, checks other condition for swap
			needed or not */
        if (largest!=i){
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            heapIfy(array, size, largest);
        }
    }

    static void maxHeap(int[] array){

        /* all leaf nodes already satisfied, no need
	          to heapify them.
	        * last leaf node present at (n-1)th index,
	          so parent of it will be (n-1)/2th location/
	        * iterate over non leaf nodes and heapify the elements.
	        * if we add array with 5 elements, then 3 (0,1,2) elements are
	          parent of node child. and we iterate in decreasing order bcz
	          it is property of heapify, as no need to look at lead nodes.
	                     0
	                  /    \
	                 1      2
	               /  \
	              3    40
		    * where recursive call, checks other condition for swap
				  needed or not */

        int size = array.length;
        for (int i=size/2-1; i>=0; i--) {
            heapIfy(array, size, i);
        }
    }

    // delete root
    static void delete(int[] array, int n){
        int swap = array[0];
        array[0] = array[n-1];
        array[n-1] = swap;
        n = n-1;
        heapIfy(array, n, 0);
        for (int i=0; i<n; i++)
            System.out.print(array[i]+" ");
    }

    public static void main(String[] args){
        int[] array = {15,5,20,1,17,10,30};
        /* max heap */
        maxHeap(array);
        System.out.println(Arrays.toString(array));
        delete(array, array.length);
    }
}
