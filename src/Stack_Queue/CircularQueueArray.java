package Stack_Queue;

public class CircularQueueArray {
    int[] array;
    int front, rear;
    int capacity;
    CircularQueueArray(int capacity){
        this.capacity = capacity;
        front = rear = -1;
        array = new int[capacity];
    }

    boolean isFull(){
        return front == rear+1 || front == 0 && rear == capacity-1;
    }
    boolean isEmpty(){
        return front == -1;
    }
    private void enqueue(int key){
        if (isFull()){
            System.out.println("queue is full");
            return;
        }
        if (front == -1)
            front = 0;
        rear = (rear+1)%capacity;
        array[rear] = key;
    }
    private int dequeue(){
        if (isEmpty())
            return -1;
        if (front>=rear)
            front = rear = -1;
        front = (front+1)%capacity;
        return array[front];
    }
    private int front(){
        return array[front];
    }
    private int rear(){
        return array[rear];
    }
    private void print(){
        int i;
        for (i=front; i!=rear; i=(i+1)%capacity){
            System.out.print(array[i]+" ");
        }
        System.out.print(array[i]+" ");
    }

    public static void main(String[] args){
        CircularQueueArray queue = new CircularQueueArray(6);
        queue.enqueue(4);
        queue.enqueue(8);
        queue.enqueue(2);
        queue.enqueue(6);
        System.out.println("dequeue: " + queue.dequeue());
        queue.print();
    }

}
