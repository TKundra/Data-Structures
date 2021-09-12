package Tree;

public class LowestCommonAncestor {
    static class Node {
        int key;
        Node left, right;
        Node(int key){
            this.key = key;
            left = right = null;
        }
    }
    Node root = null;

    private Node find(Node node, int a, int b){
        if (node == null)
            return null;
        if (a<node.key && b<node.key)
            return find(node.left, a, b);
        if (a>node.key && b>node.key)
            return find(node.right, a, b);
        return node;
    }

    public static void main(String[] args){
        LowestCommonAncestor tree = new LowestCommonAncestor();
        tree.root = new Node(5);
        tree.root.left = new Node(3);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(4);
        Node node = tree.find(tree.root, 1,4);
        if (node == null)
            System.out.println("nothing");
        else
            System.out.println(node.key);
    }

}
