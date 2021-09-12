package Stack_Queue;
import java.util.Stack;

public class QueueUsingTwoStack {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    private void enqueue(int key){
        while (!stack1.isEmpty())
            stack2.push(stack1.pop());
        stack1.push(key);
        while (!stack2.isEmpty())
            stack1.push(stack2.pop());
    }
    private int dequeue(){
        if (stack1.isEmpty())
            return -1;
        return stack1.pop();
    }

    private void print(){
        while (!stack1.isEmpty()){
            System.out.print(stack1.pop()+" ");
        }
    }

    public static void main(String[] args){
        QueueUsingTwoStack queue = new QueueUsingTwoStack();
        queue.enqueue(4);
        queue.enqueue(2);
        queue.enqueue(8);
        queue.enqueue(6);
        System.out.println(queue.dequeue());
        queue.print();
    }

}
