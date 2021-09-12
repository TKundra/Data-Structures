package LinkedList;
import java.util.HashSet;
import java.util.Set;

/* Floyd's cycle finding algorithm */
public class LoopInLinkedList {
    static class Node{
        int key;
        Node next;
        Node(int key){
            this.key = key;
            next = null;
        }
    }
    Node head;

    private void detectLoop(){
        Node p = head;
        Node q = head;
        int flag = 0;
        while (p!=null && q!=null && q.next!=null){
            p = p.next;
            q = q.next.next;
            if (p == q){
                flag = 1;
                break;
            }
        }
        if (flag == 1)
            System.out.println("loop present");
        else {
            System.out.println("no loop detected");
        }
    }

    private void removeLoop(){
        Set<Node> set = new HashSet<>();
        Node prev = null;
        Node current = head;
        while (current!=null){
            if (set.contains(current)){
                prev.next = null;
                return;
            }
            set.add(current);
            prev = current;
            current = current.next;
        }
    }

    public static void main(String[] args){
        LoopInLinkedList loop = new LoopInLinkedList();
        loop.head = new Node(1);
        loop.head.next = new Node(2);
        loop.head.next.next = new Node(3);
        loop.head.next.next.next = new Node(4);
        loop.head.next.next.next.next = new Node(5);
        // create loop
        loop.head.next.next.next.next = loop.head.next;
        loop.removeLoop();
        loop.detectLoop();
    }
}
