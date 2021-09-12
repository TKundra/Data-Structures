package LinkedList;

public class CircularLinkedList {
    static class Node {
        int key;
        Node next;
        Node(int key){
            this.key = key;
            next = null;
        }
    }

    Node head, tail;

    private void addFirst(int key){
        Node node = new Node(key);
        if (head == null){
            head = tail = node;
            node.next = head;
        }else {
            node.next = head;
            head = node;
            tail.next = head;
        }
    }
    private void addLast(int key){
        Node node = new Node(key);
        if (head == null){
            head = tail = node;
            node.next = head;
        }else {
            tail.next = node;
            tail = node;
            tail.next = head;
        }
    }
    private void deleteFirst(){
        if (head == null)
            System.out.println("empty");
        else {
            if (head!=tail){
                head = head.next;
                tail.next = head;
            }else {
                head = tail = null;
            }
        }
    }
    private void deleteLast(){
        if (head == null)
            System.out.println("empty");
        else {
            if (head!=tail){
                Node node = head;
                while (node.next!=tail)
                    node = node.next;
                tail = node;
                tail.next = head;
            }
            else {
                head = tail = null;
            }
        }
    }
    private void print(){
        if (head == null)
            System.out.println("empty");
        else {
            Node node = head;
            do {
                System.out.print(node.key+" ");
                node = node.next;
            }while (node!=head);
        }
    }

    public static void main(String[] args){
        CircularLinkedList list = new CircularLinkedList();
        list.addFirst(3);
        list.addFirst(6);
        list.addLast(4);
        list.addLast(8);
        list.addFirst(7);
        list.deleteFirst();
        list.deleteLast();
        list.print();
    }

}
