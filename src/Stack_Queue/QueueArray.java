package Stack_Queue;

public class QueueArray {
    int[] array;
    int front, rear;
    int capacity;
    QueueArray(int capacity){
        this.capacity = capacity;
        front = rear = -1;
        array = new int[capacity];
    }

    boolean isFull(){
        return rear == capacity-1 && front == 0;
    }
    boolean isEmpty(){
        return front == rear;
    }
    private void enqueue(int key){
        if (isFull()){
            System.out.println("queue is full");
            return;
        }
        if (front == -1)
            front = 0;
        ++rear;
        array[rear] = key;
    }
    private int dequeue(){
        if (isEmpty())
            return -1;
        if (front>=rear)
            front = rear = -1;
        return array[front++];
    }
    private int front(){
        return array[front];
    }
    private int rear(){
        return array[rear];
    }
    private void print(){
        for (int i=front; i<=rear; i++){
            System.out.print(array[i]+" ");
        }
    }

    public static void main(String[] args){
        QueueArray queue = new QueueArray(6);
        queue.enqueue(4);
        queue.enqueue(8);
        queue.enqueue(2);
        queue.enqueue(6);
        System.out.println("dequeue: " + queue.dequeue());
        queue.print();
    }

}
