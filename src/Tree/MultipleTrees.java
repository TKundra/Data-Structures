package Tree;

public class MultipleTrees {
    static class Node {
        int key;
        Node left, right;
        Node(int key){
            this.key = key;
            left = right = null;
        }
    }
    Node root = null;

    /* trees identical */
    private boolean identical(Node node1, Node node2){
        if (node1==null && node2==null)
            return true;
        if (node1!=null && node2!=null)
            return (node1.key==node2.key &&
                    identical(node1.left, node2.left) &&
                    identical(node1.right, node2.right));
        return false;
    }

    public static void main(String[] args){
        MultipleTrees tree = new MultipleTrees();

        Node head1 = null;
        Node head2 = null;
        head1 = new Node(4);
        head1.left = new Node(10);
        head1.right = new Node(8);

        head2 = new Node(4);
        head2.left = new Node(10);
        head2.right = new Node(8);
        System.out.println(tree.identical(head1, head2));
    }

}
