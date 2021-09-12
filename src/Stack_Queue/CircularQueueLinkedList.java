package Stack_Queue;

public class CircularQueueLinkedList {
    static class Node {
        int key;
        Node next;
        Node(int key){
            this.key = key;
            next = null;
        }
    }

    Node front = null;
    Node rear = null;

    private void enqueue(int key){
        Node node = new Node(key);
        if (front == null)
            front = node;
        else
            rear.next = node;
        rear = node;
        rear.next = front;
    }
    private void dequeue(){
        if (front == null)
            return;
        Node node = front;
        front = node.next;
        rear.next = front;
        if (front == null)
            rear = null;
    }
    private void print(){
        if (front == null)
            return;
        Node node = front;
        do {
            System.out.print(node.key+" ");
            node = node.next;
        }while (node!=front);
    }

    public static void main(String[] args){
        CircularQueueLinkedList queue = new CircularQueueLinkedList();
        queue.enqueue(4);
        queue.enqueue(8);
        queue.enqueue(2);
        queue.enqueue(6);
        queue.dequeue();
        queue.print();
    }

}
