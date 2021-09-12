package Stack_Queue;
import java.util.Stack;

public class SortStackUsingRecursion {

    void sortedStack(Stack<Integer> stack, int element){
        if (stack.isEmpty() || element > stack.peek()){
            stack.push(element);
            return;
        }
        // if stack top element is greater
        int topElement = stack.pop();
        sortedStack(stack, element);
        stack.push(topElement);
    }
    void sort(Stack<Integer> stack){
        if (stack.isEmpty()){
            return;
        }
        int topElement = stack.pop();
        sort(stack);
        sortedStack(stack, topElement);
    }

    public static void main(String[] args){
        SortStackUsingRecursion sort = new SortStackUsingRecursion();
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(2);
        stack.push(8);
        stack.push(7);
        sort.sort(stack);
        while (!stack.isEmpty())
            System.out.println(stack.pop());
    }
}
