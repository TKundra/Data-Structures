package Stack_Queue;
import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueueUsingRecursion {

    static void reverse(Queue<Integer> queue){
        // base case
        if (queue.isEmpty())
            return;
        int data = queue.remove();
        // reverse remaining queue
        reverse(queue);
        // enqueue current item to rear
        queue.add(data);
    }

    static void print(Queue<Integer> queue){
        while (!queue.isEmpty())
            System.out.println(queue.remove());
    }

    public static void main(String[] args){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        reverse(queue);
        print(queue);
    }

}
