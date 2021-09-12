package LinkedList;

/* insert data in sorted linked list */
public class SortedLinkedList {
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
        Node last = head;
        while (last.next!=null)
            last = last.next;
        last.next = node;
    }

    /* insert element in sorted linked list */
    private void insert(int key){
        Node node = new Node(key);
        Node current;
        if (head == null || head.key > node.key){
            node.next = head;
            head = node;
        }else {
            current = head;
            while (current.next!=null && current.next.key < node.key){
                current = current.next;
            }
            node.next = current.next;
            current.next = node;
        }
    }

    /* remove duplicates from sorted linked list */
    private void remove(){
        Node current = head;
        while (current!=null){
            Node temp = current;
            // compare current with next and go ahead if they are same
            while (temp!=null && temp.key == current.key)
                temp = temp.next;
            // just connect the non-same elements together
            current.next = temp;
            current = current.next;
        }
    }

    private void print(){
        Node node = head;
        while (node!=null){
            System.out.print(node.key+" ");
            node = node.next;
        }
    }

    public static void main(String[] args){
        SortedLinkedList insertion = new SortedLinkedList();
        insertion.add(1);
        insertion.add(2);
        insertion.add(4);
        insertion.insert(3);
        insertion.print();
    }

}
