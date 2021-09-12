package Stack_Queue;

public class DequeUsingLinkedList {
    static class Node {
        int key;
        Node next, prev;
        Node(int key){
            this.key = key;
            prev = next = null;
        }
    }

    Node rear = null;
    Node front = null;

    boolean isEmpty(){
        return front == null;
    }
    private void addFront(int key){
        Node node = new Node(key);
        if (front == null)
            front = rear = node;
        node.next = front;
        front.prev = node;
        front = node;
    }
    private void addEnd(int key){
        Node node = new Node(key);
        if (front == null)
            front = rear = node;
        rear.next = node;
        node.prev = rear;
        rear = node;
    }
    private void removeFront(){
        if (isEmpty()){
            return;
        }
        Node node = front;
        front = node.next;
        if (front == null)
            rear = null;
        else
            front.prev = null;
    }
    private void removeLast(){
        if (isEmpty())
            return;
        Node node = rear;
        rear = node.prev;
        if (rear == null)
            front = null;
        else
            rear.next = null;
    }

}
