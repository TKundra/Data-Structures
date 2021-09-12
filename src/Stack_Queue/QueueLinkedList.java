package Stack_Queue;

public class QueueLinkedList {
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
        if (rear == null){
            front = rear = node;
            return;
        }
        rear.next = node;
        rear = node;
    }
    private void dequeue(){
        if (front == null)
            return;
        Node node = front;
        front = node.next;
        if (front == null)
            rear = null;
    }
    private void print(){
        Node node = front;
        while (node!=null){
            System.out.print(node.key+" ");
            node = node.next;
        }
    }

    public static void main(String[] args){
        QueueLinkedList queue = new QueueLinkedList();
        queue.enqueue(5);
        queue.enqueue(8);
        queue.enqueue(2);
        queue.enqueue(4);
        queue.dequeue();
        queue.print();
    }

}
