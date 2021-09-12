package Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueApplications {

    /* reverse queue using stack */
    private void reverse(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(5);
        queue.add(7);
        queue.add(2);
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()){
            stack.push(queue.remove());
        }
        while (!stack.isEmpty())
            System.out.print(stack.pop()+" ");
    }

    public static void main(String[] args){
        QueueApplications queue = new QueueApplications();
        queue.reverse();
    }

}
