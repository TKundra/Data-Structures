package Stack_Queue;
import java.util.ArrayList;

class Heap {
    /* heapify */
    void heapIfy(ArrayList<Integer> arrayList, int i){
        int size = arrayList.size();
        /* Find the largest among root, left child and right child */
        int largest = i;
        int left = (2*i+1);
        int right = (2*i+2);
        if (left < size && arrayList.get(left) > arrayList.get(largest))
            largest = left;
        if (right < size && arrayList.get(right) >  arrayList.get(largest))
            largest = right;
        /* Swap and continue heapifying if root is not largest */
        if (largest != i){
            int temp = arrayList.get(largest);
            arrayList.set(largest, arrayList.get(i));
            arrayList.set(i, temp);
            heapIfy(arrayList, largest);
        }
    }
    /* insert node */
    void insert(ArrayList<Integer> arrayList, int key){
        int size = arrayList.size();
        if (size == 0){
            arrayList.add(key);
        }else {
            arrayList.add(key);
            for (int i=size/2-1; i>=0; i--)
                heapIfy(arrayList, i);
        }
    }
    void delete(ArrayList<Integer> arrayList, int n){
        int size = arrayList.size();
        int i;
        for (i=0; i<size; i++){
            if (n == arrayList.get(i))
                break;
        }
        /* i=index of that value and swap them to delete leaf */
        int temp = arrayList.get(i);
        arrayList.set(i, arrayList.get(size-1));
        arrayList.set(size-1, temp);
        arrayList.remove(size-1);
        /* after deleting leaf element, heapify them */
        for (int j=size/2-1; j>=0; j--){
            heapIfy(arrayList, j);
        }
    }
    /* print the tree */
    void print(ArrayList<Integer> arrayList){
        for (Integer array : arrayList)
            System.out.print(array+" ");
        System.out.println();
    }
}

public class PriorityQueue {
    public static void main(String[] args){
        ArrayList<Integer> array = new ArrayList<>();
        Heap heap = new Heap();
        heap.insert(array, 3);
        heap.insert(array, 4);
        heap.insert(array, 9);
        heap.insert(array, 5);
        heap.insert(array, 2);
        System.out.println("Max-Heap array");
        heap.print(array);
        System.out.println("after deleting");
        heap.delete(array, 4);
        heap.print(array);
    }
}