package LinkedList;

public class DoublyLinkedList {
    static class Node {
        int key;
        Node prev, next;
        Node(int key){
            this.key = key;
            prev = next = null;
        }
    }

    Node head;

    private void addFirst(int key){
        Node node = new Node(key);
        node.next = head;
        node.prev = null;
        if (head!=null)
            head.prev = node;
        head = node;
    }
    private void addLast(int key){
        Node node = new Node(key);
        if (head == null){
            node.prev = null;
            head = node;
            return;
        }
        Node last = head;
        while (last.next!=null)
            last = last.next;
        last.next = node;
        node.prev = last;
    }
    private void addNode(Node prev, int key){
        Node node = new Node(key);
        if (prev == null)
            return;
        node.next = prev.next;
        prev.next = node;
        node.prev = prev;
        if (node.next!=null)
            node.next.prev = node;
    }
    private void deleteFirst(){
        if (head == null)
            return;
        Node node = head;
        node.next.prev = null;
        head = node.next;
    }
    private void deleteLast(){
        if (head == null)
            return;
        Node last = head;
        while (last.next!=null)
            last = last.next;
        last.prev.next = null;
    }
    private void deleteNode(Node node){
        if (head == null || node == null)
            return;
        /* when it is head node */
        if (node == head)
            head = node.next;
        /* change only when delete node is not last one */
        if (node.next != null)
            node.next.prev = node.prev;
        /* change when it is not the head node */
        if (node.prev!=null)
            node.prev.next = node.next;
    }
    private void reverse(){
        Node node = null;
        Node current = head;
        while (current!=null){
            node = current.prev;
            current.prev = current.next;
            current.next = node;
            current = current.prev;
        }
        if (node!=null)
            head = node.prev;
    }
    private void print(){
        Node node = head;
        while (node!=null){
            System.out.print(node.key+" ");
            node = node.next;
        }
    }

    public static void main(String[] args){
        DoublyLinkedList doubly = new DoublyLinkedList();
        doubly.addFirst(5);
        doubly.addFirst(8);
        doubly.addLast(9);
        doubly.addFirst(1);
        doubly.addLast(4);
        doubly.addNode(doubly.head.next.next, 6);
        doubly.print();
        System.out.println();
        doubly.reverse();
        doubly.print();
    }

}
