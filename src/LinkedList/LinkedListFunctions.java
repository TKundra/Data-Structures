package LinkedList;
import java.util.Stack;

public class LinkedListFunctions {
    static class Node{
        int key;
        Node next;
        Node(int key){
            this.key = key;
            next = null;
        }
    }
    Node head;

    private void add(int key){
        Node node = new Node(key);
        if (head == null){
            head = node;
            return;
        }
        node.next = head;
        head = node;
    }

    /* remove alternative elements */
    private void removeAlternatives(){
        Node prev = head;
        Node current = head.next;
        while (prev!=null && current!=null){
            // skip one and connect prev with next of next
            prev.next = current.next;
            // make current null
            current = null;
            // increment prev
            prev = prev.next;
            // if it's not null, update current node
            if (prev!=null)
                current = prev.next;
        }
    }

    /* move last element to front */
    private void move(){
        Node secLast = null;
        Node last = head;
        while (last.next!=null){
            secLast = last;
            last = last.next;
        }
        if (secLast != null) {
            secLast.next = null;
        }
        last.next = head;
        head = last;
    }

    /* remove middle element */
    private void remove(){
        Node prev = null;
        Node current = head;
        Node next = head;
        while (next!=null && next.next!=null){
            prev = current;
            current = current.next;
            next = next.next.next;
        }
        if (prev!=null)
            prev.next = current.next;
    }

    /* find middle element */
    private void middle(){
        Node p = head;
        Node q = head;
        while (q!=null && q.next!=null){
            p = p.next;
            q = q.next.next;
        }
        System.out.println("middle element: " + p.key);
    }

    /* reverse linked list */
    private void reverse(){
        Node prev = null;
        Node next = null;
        Node current = head;
        while (current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    /* rotate linked list */
    private void rotate(int k){
        if (k==0)
            return;
        Node node = head;
        while (node.next!=null)
            node = node.next;
        node.next = head;
        node = head;
        for (int i=0; i<k-1; i++)
            node = node.next;
        head = node.next;
        node.next = null;
    }

    /* reverse a linked list in group of given sizes */
    private Node reverse(Node node, int size){
        if (node == null)
            return null;
        Node prev = null;
        Node next = null;
        Node current = node;
        int count = 0;
        while (current!=null && count<size){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        if (next!=null)
            node.next = reverse(next, size);
        return prev;
    }

    /* nth node from last */
    private void nthFromLast(int index){
        Node node = head;
        int length = 0;
        while (node!=null){
            node = node.next;
            length++;
        }
        node = head;
        for (int i=1; i<(length-index+1); i++)
            node = node.next;
        System.out.println("nth node from last: " + node.key);
    }

    /* pairwise swap */
    private void pairwiseSwap(){
        Node node = head;
        while (node!=null && node.next!=null){
            int swap = node.key;
            node.key = node.next.key;
            node.next.key = swap;
            // move
            node = node.next.next;
        }
    }

    /* delete without head pointer */
    private void deleteWithoutHeadPointer(Node node){
        if (node == null)
            return;
        else
            if (node.next == null)
                return;
        node.key = node.next.key;
        node.next = node.next.next;
    }

    /* is linked list is palindrome */
    private boolean palindrome(){
        Node node = head;
        boolean isPalindrome = true;
        Stack<Integer> stack = new Stack<>();
        while (node!=null){
            stack.push(node.key);
            node = node.next;
        }
        while (head!=null){
            int i = stack.pop();
            if (head.key == i) {
                isPalindrome = true;
            } else {
                isPalindrome =  false;
                break;
            }
            head = head.next;
        }
        return isPalindrome;
    }

    private void print(Node node){
        while (node!=null){
            System.out.print(node.key+" ");
            node = node.next;
        }
    }

    public static void main(String[] args){
        LinkedListFunctions functions = new LinkedListFunctions();
        functions.add(9);
        functions.add(8);
        functions.add(7);
        functions.add(6);
        functions.add(5);
        functions.add(4);
        functions.add(3);
        functions.add(2);
        functions.add(1);
        functions.print(functions.reverse(functions.head, 3));
        //functions.print(functions.head);
    }

}
