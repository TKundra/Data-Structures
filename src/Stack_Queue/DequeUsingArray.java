package Stack_Queue;

public class DequeUsingArray {
    int[] array;
    int front, rear, capacity;
    DequeUsingArray(int capacity){
        this.capacity = capacity;
        front = -1;
        rear = 0;
        array = new int[capacity];
    }

    boolean isEmpty(){
        return front == -1;
    }
    boolean isFull(){
        return (front == 0 && rear == capacity-1 || front == rear+1);
    }
    private void addFront(int key){
        if (isFull()){
            return;
        }
        if (front == -1)
            front = rear = 0;
        if (front == 0)
            front = capacity-1;
        else
            front--;
        array[front] = key;
    }
    private void addEnd(int key){
        if (isFull()){
            return;
        }
        if (front == -1)
            front = rear = 0;
        if (rear == capacity-1)
            rear = 0;
        else
            rear++;
        array[rear] = key;
    }
    private void removeFront(){
        if (isEmpty())
            return;
        if (front == rear)
            front = rear = -1;
        if (front == capacity-1)
            front = 0;
        else
            ++front;
    }
    private void removeLast(){
        if (isEmpty())
            return;
        if (front == rear)
            front = rear = -1;
        if (rear == 0)
            rear = capacity-1;
        else
            --rear;
    }
    private int front(){
        return array[front];
    }
    private int rear(){
        return array[rear];
    }

    public static void main(String[] args){
        DequeUsingArray deque = new DequeUsingArray(6);
        deque.addFront(5);
        deque.addFront(8);
        deque.addEnd(6);
        deque.removeFront();
        System.out.println(deque.front());
    }

}
