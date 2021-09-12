package Tree;

public class LargestBSTinBT {

    static class Node {
        int key;
        Node left, right;
        Node(int key){
            this.key = key;
            left = right = null;
        }
    }
    Node root;

    static class NodeInfo{
        int min, max, size, ans;
        boolean isBST; // i.e present node along with its left and right forming BST
        NodeInfo(){}
        NodeInfo(int min, int max, int size, int ans, boolean isBST){
            this.min = min;
            this.max = max;
            this.size = size;
            this.ans = ans;
            this.isBST = isBST;
        }
    }

    static int MIN = Integer.MIN_VALUE;
    static int MAX = Integer.MAX_VALUE;

    private static NodeInfo largestBST(Node node){
        // base case when it empty or has one child
        if (node == null)
            return new NodeInfo(MIN, MAX, 0, 0, true);
        if (node.left == null && node.right == null)
            return new NodeInfo(node.key, node.key, 1, 1, true);
        // recursively for left and right
        NodeInfo left = largestBST(node.left);
        NodeInfo right = largestBST(node.right);
        // create a return variable and initialized
        NodeInfo returnInfo = new NodeInfo();
        returnInfo.size = 1 + left.size + right.size;
        // if whole tree rooted under current root is BST
        if (left.isBST && right.isBST && left.max<node.key && right.min>node.key){
            returnInfo.min = Math.min(Math.min(left.min, right.min), node.key);
            returnInfo.max = Math.max(Math.max(left.max, right.max), node.key);
            // update answer
            returnInfo.ans = returnInfo.size;
            returnInfo.isBST = true;
            return returnInfo;
        }
        // if whole tree is not BST
        returnInfo.ans = Math.max(left.ans, right.ans);
        returnInfo.isBST = false;
        return returnInfo;
    }

    private int largestBSTinBT(Node node){
        return largestBST(node).ans;
    }

    public static void main(String[] args){
        LargestBSTinBT bt = new LargestBSTinBT();
        bt.root = new Node(5);
        bt.root.left = new Node(3);
        bt.root.right = new Node(6);
        bt.root.left.left = new Node(2);
        bt.root.left.right = new Node(4);
        System.out.println(bt.largestBSTinBT(bt.root));
    }

}
