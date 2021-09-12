package Greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

// create a node
class HuffmanNode {
    int frequency;
    char ch;
    HuffmanNode left;
    HuffmanNode right;
}

// sort node in ascending order on the basis of frequency
class HCCompare implements Comparator<HuffmanNode>{
    @Override
    public int compare(HuffmanNode x, HuffmanNode y) {
        return x.frequency - y.frequency;
    }
}

public class HuffmanCodingBasic {

    /*  recursive function to print the
        huffman-code through the tree traversal.
        Here s is the huffman - code generated */
    static void printCode(HuffmanNode root, String s){
        if (root.left == null && root.right == null && Character.isLetter(root.ch)){
            System.out.println(root.ch + " : " + s);
            return;
        }
        /*  if we go to left then add "0" to the code.
            if we go to the right add"1" to the code.
            recursive calls for left and
            right sub-tree of the generated tree */
        printCode(root.left, s+"0");
        printCode(root.right, s+"1");
    }

    public static void main(String[] args){
        int n = 5;
        char[] data = {'a', 'b', 'c', 'd', 'e'};
        int[] dataFrequency = {4,7,3,2,4};

        /*  3.creating a priority queue q.
            makes a min-priority queue(min-heap) */
        PriorityQueue<HuffmanNode> q = new PriorityQueue<>(n, new HCCompare());

        // add data in node
        for (int i=0; i<n; i++){
            HuffmanNode node = new HuffmanNode();
            node.ch = data[i];
            node.frequency = dataFrequency[i];
            node.left = null;
            node.right = null;
            q.add(node);
        }

        /* create a root node */
        HuffmanNode root = null;

        /*  Here we will extract the two minimum value
            from the heap each time until
            its size reduces to 1,
            extract until all the nodes are extracted. */
        while (q.size()>1){
            HuffmanNode sum = new HuffmanNode();

            HuffmanNode x = q.poll();
            HuffmanNode y = q.poll();

            // storing sum
            sum.frequency = x.frequency + y.frequency;
            sum.ch = '-';
            /*  first extracted node as left child. */
            sum.left = x;
            /*  second extracted node as the right child. */
            sum.right = y;
            /*  marking the sum node as the root node. */
            root = sum;
            /* add this node to the priority-queue */
            q.add(sum);
        }

        if (root != null) {
            printCode(root, "");
        }

    }

}
