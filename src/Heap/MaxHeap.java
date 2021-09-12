package Heap;

public class MaxHeap {
    private int[] heap;
    private int size;

    /*  Constructor to initialize an
        empty max heap with given maximum
        capacity. */
    public MaxHeap(int maxsize) {
        this.size = 0;
        heap = new int[maxsize+1];
        heap[0] = Integer.MAX_VALUE;
    }

    /*  Returns position of parent */
    private int parent(int pos) { return pos / 2; }

    /*  Below two functions return left and
        right children */
    private int leftChild(int pos) { return (2 * pos); }
    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    /*  Returns true of given node is leaf */
    private boolean isLeaf(int pos) {
        return pos > (size / 2) && pos <= size;
    }

    private void swap(int a, int b){
        int swap = heap[a];
        heap[a] = heap[b];
        heap[b] = swap;
    }

    /*  Inserts a new element to max heap */
    public void insert(int element) {
        heap[++size] = element;
        /*  if child is > parent, swap */
        int current = size;
        while (heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            /* to further check with parent till root */
            current = parent(current);
        }
    }

    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(
                    "PARENT : " + heap[i]
                            + "\n\tLEFT CHILD : " + heap[2 * i]
                            + "\n\tRIGHT CHILD :" + heap[2 * i + 1]);
            System.out.println();
        }
    }

    public static void main(String[] arg) {
        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);

        maxHeap.print();
    }
}