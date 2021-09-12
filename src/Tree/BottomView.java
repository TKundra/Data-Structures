package Tree;
import java.util.*;

/*
        7
      /  \
     6    5
   /  \
  4    3

    map: {(0,7),}
    map: {(0,7),(-1,6),}
    map: {(0,7),(-1,6),(1,7),}
    map: {(0,7),(-1,6),(1,7),(-2,4),}
        now (0,7) replaced by (0,3)
    map: {(0,3),(-1,6),(1,7),(-2,4)}

*/

public class BottomView {
    static class Node {
        int key;
        int hd; // horizontal distance of nodes
        Node left, right;
        Node(int key){
            this.key = key;
            left = right = null;
            hd = Integer.MAX_VALUE;
        }
    }
    Node root;
    private void bottomView(){
        Node node = root;
        if (node == null)
            return;
        int hd = 0;
        /* first time we add in map, next time it will replace the value (key- unique values only) */
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        /* assign initial hd value to root node and add it to queue */
        root.hd = hd;
        queue.add(root);
        while (!queue.isEmpty()){
            node = queue.remove();
            hd = node.hd;
            map.put(hd, node.key);
            if (node.left!=null){
                node.left.hd = hd-1;
                queue.add(node.left);
            }
            if (node.right!=null){
                node.right.hd = hd+1;
                queue.add(node.right);
            }
        }
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : set) {
            System.out.print(entry.getValue() + " ");
        }
    }

    public static void main(String[] args){
        BottomView tree = new BottomView();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.bottomView();
        System.out.println();
    }

}
