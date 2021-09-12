package Tree;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeImplementation {

    static class Node {
        int key;
        Node left, right;
        Node(int key){
            this.key = key;
            left = right = null;
        }
    }
    Node root;

    /* tree traversal */
    private void preOrder(Node node){
        if (node == null)
            return;
        System.out.print(node.key+" ");
        preOrder(node.left);
        preOrder(node.right);
    }
    private void preOrderWithoutRecursion(){
        if (root == null)
            return;
        Stack<Node> stack = new Stack<>();
        Node node = root;
        stack.push(node);
        while (!stack.isEmpty()){
            node = stack.pop();
            System.out.print(node.key+" ");
            if (node.right!=null)
                stack.push(node.right);
            if (node.left!=null)
                stack.push(node.left);
        }
    }

    private void inOrder(Node node){
        if (node == null)
            return;
        inOrder(node.left);
        System.out.print(node.key+" ");
        inOrder(node.right);
    }
    private void inOrderWithoutRecursion(){
        if (root == null)
            return;
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while (!stack.isEmpty() || node!=null){
            while (node!=null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            System.out.print(node.key+" ");
            node = node.right;
        }
    }

    private void postOrder(Node node){
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.key+" ");
    }
    private void postOrderWithoutRecursion(){
        if (root == null)
            return;
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        Node node = root;
        stack1.push(node);
        while (!stack1.isEmpty()){
            node = stack1.pop();
            stack2.push(node);
            if (node.left!=null)
                stack1.push(node.left);
            if (node.right!=null)
                stack1.push(node.right);
        }
        while (!stack2.isEmpty())
            System.out.print(stack2.pop() + " ");
    }

    /* is full binary tree, either 0 or 2 children */
    private boolean isFullBinaryTree(Node node){
        if (node == null)
            return true;
        if (node.left == null && node.right == null)
            return true;
        if (node.left!=null && node.right!=null)
            return (isFullBinaryTree(node.left) && isFullBinaryTree(node.right));
        return false;
    }

    /* is perfect binary tree, all leaf are at same level and internal node have 2 children */
    private int depth(Node node){
        if (node == null)
            return 0;
        int d = 0;
        while (node!=null){
            d++;
            node = node.left;
        }
        return d;
    }
    private boolean isPerfectBinaryTree(Node node, int depth, int level){
        if (node == null)
            return true;
        if (node.left==null && node.right==null)
            return (depth == level+1);
        if (node.left==null || node.right==null)
            return false;
        return (isPerfectBinaryTree(node.left, depth, level+1) &&
                isPerfectBinaryTree(node.right, depth, level+1));
    }
    private boolean isPerfectBinaryTree(Node node){
        int depth = depth(node);
        return isPerfectBinaryTree(node, depth, 0);
    }

    /*  is complete binary tree, all levels are completely filled except possibly the last
        and at last level all keys are as left as possible */
    private int numberOfNodes(Node node){
        if (node == null)
            return 0;
        return (1+numberOfNodes(node.left)+numberOfNodes(node.right));
    }
    private boolean isCompleteBinaryTree(Node node){
        int nodes = numberOfNodes(node);
        return isCompleteBinaryTree(node, nodes, 0);
    }
    private boolean isCompleteBinaryTree(Node node, int nodes, int index){
        if (node == null)
            return true;
        if (index >= nodes)
            return false;
        return (isCompleteBinaryTree(node.left, nodes, 2*index+1) &&
                isCompleteBinaryTree(node.right, nodes, 2*index+2));
    }

    /* level order traversal */
    private void levelOrderTraversal(){
        Queue<Node> queue = new LinkedList<>();
        Node node = root;
        queue.add(node);
        while (!queue.isEmpty()){
            node = queue.poll();
            System.out.print(node.key+" ");
            if (node.left!=null)
                queue.add(node.left);
            if (node.right!=null)
                queue.add(node.right);
        }
    }

    /* reverse level order traversal */
    private void reverseLevelOrderTraversal(){
        Stack<Node> stack = new Stack<>();
        Queue<Node> queue = new LinkedList<>();
        Node node = root;
        queue.add(node);
        while (!queue.isEmpty()){
            node = queue.poll();
            stack.push(node);
            if (node.left!=null)
                queue.add(node.left);
            if (node.right!=null)
                queue.add(node.right);
        }
        // print stack
        while (!stack.isEmpty())
            System.out.print(stack.pop().key+" ");
    }

    /* level order traversal in spiral form */
    private void levelOrderInSpiralForm(Node node){
        if (node == null)
            return;
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(node);
        while (!stack1.isEmpty()){
            while (!stack1.isEmpty()){
                /*  print nodes of current level from stack1
                and push nodes of next level to stack2 */
                node = stack1.pop();
                System.out.print(node.key+" ");
                if (node.right!=null)
                    stack2.push(node.right);
                if (node.left!=null)
                    stack2.push(node.left);
            }
            while (!stack2.isEmpty()){
                /*  print nodes of current level from stack2
                and push nodes of next level to stack1 */
                node = stack2.pop();
                System.out.print(node.key+" ");
                if (node.left!=null)
                    stack1.push(node.left);
                if (node.right!=null)
                    stack1.push(node.right);
            }
        }
    }

    /* mirror of itself */
    private boolean mirror(Node node1, Node node2){
        if (node1==null && node2==null)
            return true;
        if (node1!=null && node2!=null && node1.key == node2.key)
            return (mirror(node1.left, node2.right) && mirror(node1.right, node2.left));
        return false;
    }

    /* height of binary tree */
    private int height(Node node){
        int left, right;
        if (node == null)
            return 0;
        left = height(node.left);
        right = height(node.right);
        return Math.max(left, right)+1;
        //return Math.max(height(node.left), height(node.right))+1;
    }

    /* maximum path sum */
    int global_max;
    private int maxPathSum(Node node){
        if (node == null)
            return 0;
        int left = maxPathSum(node.left);
        int right = maxPathSum(node.right);
        int return_max = Math.max(Math.max(left, right)+node.key, node.key);
        int max = Math.max(return_max, node.key+left+right);
        if (max > global_max)
            global_max = max;
        return return_max;
    }
    private void maxPathSum(){
        maxPathSum(root);
        System.out.println(global_max);
    }

    /* tree diameter */
    private int diameter(Node node){
        if (node == null)
            return 0;
        int left_height = height(node.left);
        int right_height = height(node.right);
        int left_diameter = diameter(node.left);
        int right_diameter = diameter(node.right);
        return Math.max(left_height+right_height+1, Math.max(left_diameter, right_diameter));
    }

    /* number of leaf nodes */
    private int leaf(Node node){
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        return (leaf(node.left) + leaf(node.right));
    }

    /* tree is height balanced or not */
    private boolean heightBalanced(Node node){
        if (node == null)
            return false;
        int left_height = height(node.left);
        int right_height = height(node.right);
        return (Math.abs(left_height-right_height)<=1 &&
                heightBalanced(node.left) &&
                heightBalanced(node.right));
    }

    /* left, right, top, bottom view of binary tree */
    private void leftView(){
        /*
                1
              /   \
             2     3
           /  \
          4    5
                        1   2   4
        */
        Node node = root;
        if (node == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            int n = queue.size();
            for (int i=1; i<=n; i++){
                node = queue.poll();
                // print left most element at the level
                if (i == 1)
                    System.out.print(node.key+" ");
                if (node.left!=null)
                    queue.add(node.left);
                if (node.right!=null)
                    queue.add(node.right);
            }
        }
    }
    private void topView(){

    }

    public static void main(String[] args){
        TreeImplementation tree = new TreeImplementation();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        System.out.println(tree.height(tree.root));
    }

}
