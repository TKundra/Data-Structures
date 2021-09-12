package Stack_Queue;

public class StackArray {
    int[] array;
    int capacity;
    int top;
    StackArray(int capacity){
        this.capacity = capacity;
        top = -1;
        array = new int[capacity];
    }

    boolean isFull(){
        return top == capacity-1;
    }
    boolean isEmpty(){
        return top == -1;
    }

    private void push(int key){
        if (isFull()){
            System.out.println("stack overflow");
            return;
        }
        array[++top] = key;
    }
    private int pop(){
        int value;
        if (isEmpty())
            return -1;
        value = array[top];
        --top;
        return value;
    }
    private int peek(){
        return array[top];
    }
    private void print(){
        System.out.println();
        for (int i=0; i<top+1; i++)
            System.out.println(array[i]);
    }

    public static void main(String[] args){
        StackArray stack = new StackArray(5);
        stack.push(4);
        stack.push(8);
        stack.push(2);
        stack.push(3);
        System.out.println("peek: " + stack.peek());
        System.out.println("pop: " + stack.pop());
        stack.print();
    }

}
