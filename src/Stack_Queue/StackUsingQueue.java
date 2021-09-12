package Stack_Queue;
import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    Queue<Integer> queue = new LinkedList<>();

    private void push(int key){
        int size = queue.size();
        queue.add(key);
        for (int i=0; i<size; i++){
            int x = queue.remove();
            queue.add(x);
        }
    }

    private int pop(){
        if (queue.isEmpty())
            return -1;
        return queue.remove();
    }

    private int peek(){
        if (queue.isEmpty())
            return -1;
        return queue.peek();
    }

    public static void main(String[] args){
        StackUsingQueue stack = new StackUsingQueue();
        stack.push(5);
        stack.push(2);
        stack.push(8);
        stack.push(4);
        System.out.println(stack.peek());
    }

}
