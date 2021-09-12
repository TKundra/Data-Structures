package Greedy;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Node {
    Character character;
    int frequency;
    Node left;
    Node right;
    Node(Character ch, Integer freq) {
        this.character = ch;
        this.frequency = freq;
    }
    public Node(Character ch, Integer freq, Node left, Node right) {
        this.character = ch;
        this.frequency = freq;
        this.left = left;
        this.right = right;
    }
}
class HNodeC implements Comparator<Node> {
    @Override
    public int compare(Node x, Node y) {
        return x.frequency-y.frequency;
    }
}

public class HuffmanCodingDecoding {

    // encode
    static void encode(Node root, String string, Map<Character,String> huffmanCode){
        // if node is leaf node
        if (root.left == null && root.right == null){
            huffmanCode.put(root.character,string.length()>0 ? string : "1");
            return;
        }
        encode(root.left, string+"0", huffmanCode);
        encode(root.right, string+"1", huffmanCode);
    }

    // decode
    static int decode(Node root, int index, StringBuilder builder){
        if (root == null)
            return index;
        if (root.left == null && root.right == null){
            System.out.print(root.character);
            return index;
        }
        index++;
        root = builder.charAt(index)=='0' ? root.left : root.right;
        index = decode(root,index,builder);
        return index;
    }

    static void buildHuffmanTree(String text){
        // Base case: empty string
        if (text == null || text.length() == 0) {
            return;
        }

        // count frequency of character
        Map<Character, Integer> map = new HashMap<>();
        for (char c : text.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        // create a priority queue to store live nodes of the Huffman tree.
        // Notice that the highest priority item has the lowest frequency
        PriorityQueue<Node> pq = new PriorityQueue<>(new HNodeC());

        // create a leaf node for each character and add it
        // to the priority queue.
        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }

        // do till there is more than one node in the queue
        while (pq.size()>1){
            // Remove the two nodes of the highest priority
            // (the lowest frequency) from the queue
            Node left = pq.poll();
            Node right = pq.poll();
            // create a new internal node with these two nodes as children
            // and with a frequency equal to the sum of both nodes'
            // frequencies. Add the new node to the priority queue.
            int sum = left.frequency + right.frequency;
            pq.add(new Node(null, sum, left, right));
        }

        // `root` stores pointer to the root of Huffman Tree
        Node root = pq.peek();

        // Traverse the Huffman tree and store the Huffman codes in a map
        Map<Character, String> huffmanCode = new HashMap<>();
        if (root != null) {
            encode(root, "", huffmanCode);
        }

        // printing
        System.out.println("The original string is: " + text);

        // Print encoded string
        StringBuilder builder = new StringBuilder();
        for (char c: text.toCharArray()) {
            builder.append(huffmanCode.get(c));
        }
        System.out.println("\nencoded string is\n"+builder);

        // print decoded string
        System.out.print("\ndecoded string is\n");

        // decoding
        if (root.left == null && root.right == null) {
            // Special case: For input like a, aa, aaa, etc.
            while (root.frequency-- > 0) {
                System.out.print(root.character);
            }
        }
        else {
            // Traverse the Huffman Tree again and this time,
            // decode the encoded string
            int index = -1;
            while (index < builder.length() - 1) {
                index = decode(root, index, builder);
            }
        }

    }

    public static void main(String[] args) {
        String text = "Huffman coding is a data compression algorithm.";
        buildHuffmanTree(text);
    }
}
