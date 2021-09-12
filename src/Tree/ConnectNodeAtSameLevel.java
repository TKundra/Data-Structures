package Tree;

public class ConnectNodeAtSameLevel {

    static class Node {
        int key;
        Node left, right, nextRight;
        Node(int key){
            this.key = key;
            left = right = nextRight = null;
        }
    }
    Node root;

        /*      1 --> null
              /  \
            2 -> 3 --> null
          / \   / \
         4-> 5->6->7 --> null   */
    private void connectUtil(Node node){
        if (node == null)
            return;
        if (node.left!=null)
            node.left.nextRight = node.right;
        if (node.right!=null)
            node.right.nextRight = (node.nextRight!=null) ? node.nextRight.left : null;
        connectUtil(node.left);
        connectUtil(node.right);
    }
    private void connect(Node node){
        if (node == null)
            return;
        node.nextRight = null;
        connectUtil(node);
    }

    public static void main(String[] args){
        ConnectNodeAtSameLevel tree = new ConnectNodeAtSameLevel();
        tree.root = new Node(1);
        tree.root.left = new Node(3);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.connect(tree.root);

        int a = tree.root.nextRight!=null ? tree.root.nextRight.key : -1;
		System.out.println("next right of " + tree.root.key + " is " + a);
        int b = tree.root.left.nextRight!=null ? tree.root.left.nextRight.key : -1;
        System.out.println("next right of " + tree.root.left.key + " is " + b);
        int c = tree.root.right.nextRight!=null ? tree.root.right.nextRight.key : -1;
        System.out.println("next right of " + tree.root.right.key + " is " + c);
        int d = tree.root.left.left.nextRight!=null ? tree.root.left.left.nextRight.key : -1;
        System.out.println("next right of " + tree.root.left.left.key + " is " + d);
        int e = tree.root.left.right.nextRight!=null ? tree.root.left.right.nextRight.key : -1;
        System.out.println("next right of " + tree.root.left.right.key + " is " + e);

    }

}
