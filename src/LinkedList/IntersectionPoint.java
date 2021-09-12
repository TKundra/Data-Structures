package LinkedList;
import java.util.HashSet;
import java.util.Set;

public class IntersectionPoint {
    static class Node{
        int key;
        Node next;
        Node(int key){
            this.key = key;
            next = null;
        }
    }
    Node head;
    Node head1, head2;

    private Node yIntersection(Node node1, Node node2){
        Set<Node> set = new HashSet<>();
        while (node1!=null){
            set.add(node1);
            node1 = node1.next;
        }
        while (node2!=null){
            if (set.contains(node2))
                return node2;
            node2 = node2.next;
        }
        return null;
    }

    private void print(Node node){
        while (node!=null){
            System.out.print(node.key+" ");
            node = node.next;
        }
    }

    public static void main(String[] args){
        IntersectionPoint points = new IntersectionPoint();
        /*
                 3
                  \
                   6
                    \
                     9       10
                      \     /
                        15
                        |
                       30
        */
        points.head1 = new Node(3);
        points.head1.next = new Node(6);
        points.head1.next.next = new Node(9);

        points.head2 = new Node(10);
        points.head2.next = new Node(15);
        points.head2.next.next = new Node(30);

        // create intersection point
        points.head1.next.next.next = points.head2.next;

        Node intersection = points.yIntersection(points.head1, points.head2);
        if (intersection!=null)
            System.out.println(intersection.key);
        else
            System.out.println("no intersecting node");

    }

}
