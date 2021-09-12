package Stack_Queue;
import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueue {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    private void push(int key){
        while (!queue1.isEmpty())
            queue2.add(queue1.remove());
        queue1.add(key);
        while (!queue2.isEmpty())
            queue1.add(queue2.remove());
    }
    private int pop(){
        if (queue1.isEmpty())
            return -1;
        return queue1.remove();
    }

    public static void main(String[] args){
        StackUsingTwoQueue stack = new StackUsingTwoQueue();
        stack.push(5);
        stack.push(2);
        stack.push(8);
        stack.push(9);
        System.out.println("pop: " + stack.pop());
    }

}
