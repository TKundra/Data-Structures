package Stack_Queue;
import java.util.Stack;

/*
Push(x) : Inserts x at the top of stack. 
    If stack is empty, insert x into the stack and make minEle equal to x.
    If stack is not empty, compare x with minEle. Two cases arise:
        If x is greater than or equal to minEle, simply insert x.
        If x is less than minEle, insert (2*x – minEle) into the stack 
            and make minEle equal to x. For example, let previous minEle 
            was 3. Now we want to insert 2. We update minEle as 2 and 
            insert 2*2 – 3 = 1 into the stack.

Pop() : Removes an element from top of stack. 
    Remove element from top. Let the removed element be y. Two cases arise:
        If y is greater than or equal to minEle, the minimum element in the 
            stack is still minEle.
        If y is less than minEle, the minimum element now becomes (2*minEle – y), 
            so update (minEle = 2*minEle – y). This is where we retrieve previous 
            minimum from current minimum and its value in stack. For example, let 
            the element to be removed be 1 and minEle be 2. We remove 1 and update 
            minEle as 2*2 – 1 = 3.

Important Points: 
    Stack doesn’t hold actual value of an element if it is minimum so far.
    Actual minimum element is always stored in minEle

*/
public class GetMinFromStack {
    Integer minElement;
    Stack<Integer> stack = new Stack<>();

    private void push(int key){
        if (stack.isEmpty()){
            minElement = key;
            stack.push(key);
        }else if (key < minElement){
            stack.push(2*key - minElement);
            minElement = key;
        }else {
            stack.push(key);
        }
    }

    private void pop(){
        if (stack.isEmpty())
            return;
        Integer element = stack.pop();
        if (element < minElement){
            System.out.println(minElement);
            minElement = 2*minElement - element;
        }else {
            System.out.println(element);
        }
    }

    private void peek(){
        if (stack.isEmpty())
            return;
        Integer element = stack.peek();
        if (element < minElement)
            System.out.println(minElement);
        else
            System.out.println(element);
    }

    private void getMin(){
        if (stack.isEmpty()){
            System.out.println("empty");
        }else{
            System.out.println(minElement);
        }
    }

    public static void main(String[] args){
        GetMinFromStack stack = new GetMinFromStack();
        stack.push(1);
        stack.push(3);
        stack.push(4);
        stack.getMin();
    }

}