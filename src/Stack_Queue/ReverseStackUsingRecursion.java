package Stack_Queue;
import java.util.Stack;

public class ReverseStackUsingRecursion {
    // insert element at bottom of stack
    void insertAtBottom(Stack<Integer> stack, int element){
        if (stack.isEmpty()) {
            stack.push(element);
            return;
        }
        // store top and add it ad bottom
        int topElement = stack.pop();
        insertAtBottom(stack, element);
        stack.push(topElement);
    }
    void reverse(Stack<Integer> stack){
        // base case
        if (stack.isEmpty())
            return;
        // pop and store 1st element, call reverse for rest
        int topElement = stack.pop();
        reverse(stack);
        insertAtBottom(stack, topElement);
    }

    public static void main(String[] args){
        ReverseStackUsingRecursion recursion = new ReverseStackUsingRecursion();
        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(3);
        integerStack.push(2);
        integerStack.push(1);
        recursion.reverse(integerStack);
        while (!integerStack.isEmpty())
            System.out.print(integerStack.pop()+" ");
    }

}
