package Stack_Queue;
import java.util.Stack;

public class StackApplications {

    /* reverse a string */
    private void reverseString(){
        String string = "leet code";
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<string.length(); i++){
            char ch = string.charAt(i);
            stack.push(ch);
        }
        System.out.println("reverse of string:");
        while (!stack.isEmpty())
            System.out.print(stack.pop());
    }

    /* arithmetic expression */
    /* evaluate postfix expression
        64+24+* = 60
        6+4 = 10, push in stack
            2+4 = 6 = 6, push in stack
                6*10 = 60, push in stack
                then pop 60 as result */
    private void evaluatePostfixExpression(){
        String string = "64+24+*";
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<string.length(); i++){
            char ch = string.charAt(i);
            if (Character.isDigit(ch))
                stack.push(ch-'0'); // to convert string num in integer num
            else {
                int a = stack.pop();
                int b = stack.pop();
                switch (ch){
                    case '+':
                        stack.push(a+b);
                        break;
                    case '-':
                        stack.push(b-a);
                        break;
                    case '*':
                        stack.push(b*a);
                        break;
                    case '/':
                        stack.push(b/a);
                        break;
                }
            }
        }
        System.out.println(stack.pop());
    }

    /* parenthesis matching */
    private boolean parenthesisMatching(){
        String string = "[]({})";
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<string.length(); i++){
            if (string.charAt(i) == '[' ||
                    string.charAt(i) == '{' ||
                        string.charAt(i) == '('){
                stack.push(string.charAt(i));
            }
            if (string.charAt(i) == ']' ||
                    string.charAt(i) == '}' ||
                    string.charAt(i) == ')'){
                if (stack.isEmpty())
                    return false;
                char ch = stack.pop();
                if ((ch == '[' && string.charAt(i)!=']') ||
                        (ch == '{' && string.charAt(i)!='}') ||
                            (ch == '(' && string.charAt(i)!=')'))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    /* infix to postfix */
    private static int precedence(char ch){
        switch (ch){
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
        }
        return -1;
    }
    private void infixToPostfix(){
        String expression = "a+b*(c^d-e)^(f+g*h)-i";
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<expression.length(); i++){
            char ch = expression.charAt(i);
            if (Character.isLetterOrDigit(ch))
                result.append(ch);
            else if (ch == '(')
                stack.push(ch);
            else if (ch == ')'){
                while (!stack.isEmpty() && stack.peek()!='(')
                    result.append(stack.pop());
                stack.pop(); // pop '('
            }
            else {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek()))
                    result.append(stack.pop());
                stack.push(ch);
            }
        }
        // empty the stack
        while (!stack.isEmpty()){
            if (stack.peek() == '(')
                break;
            result.append(stack.pop());
        }
        System.out.println(result.toString());
    }

    /* infix to prefix */
    private void infixToPrefix(){
        String expression = "a+b*(c^d-e)^(f+g*h)-i";
        StringBuilder result = new StringBuilder();
        StringBuilder reverse = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i=expression.length()-1; i>=0; i--){
            char ch = expression.charAt(i);
            if (ch == '(')
                ch = ')';
            else if (ch == ')')
                ch = '(';
            reverse.append(ch);
        }

        for (int i=0; i<reverse.length(); i++){
            char ch = reverse.charAt(i);
            if (Character.isLetterOrDigit(ch))
                result.append(ch);
            else if (ch == '(')
                stack.push(ch);
            else if (ch == ')'){
                while (!stack.isEmpty() && stack.peek()!='(')
                    result.append(stack.pop());
                stack.pop(); // pop '('
            }
            else {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek()))
                    result.append(stack.pop());
                stack.push(ch);
            }
        }
        // empty the stack
        while (!stack.isEmpty()){
            if (stack.peek() == '(')
                break;
            result.append(stack.pop());
        }
        System.out.println(result.reverse());
    }

    /* postfix to prefix */
    private boolean isOperator(char ch){
        switch (ch){
            case '+':
            case '-':
            case '*':
            case '/':
                return true;
        }
        return false;
    }
    private void postfixToPrefix(){
        String expression = "abc/-ak/l-*";
        Stack<String> stack = new Stack<>();
        for (int i=0; i<expression.length(); i++){
            char ch = expression.charAt(i);
            if (isOperator(ch)){
                String a = stack.pop();
                String b = stack.pop();
                String c = ch + b + a;
                stack.push(c);
            }else {
                stack.push(ch+"");
            }
        }StringBuilder result = new StringBuilder();
        for (String d : stack)
            result.append(d);
        System.out.print(result.toString());
    }

    /* next larger element */
    private void nle(){
        int[] array = {11,13,21,3};
        Stack<Integer> stack = new Stack<>();
        int[] nle = new int[array.length];
        for (int i=array.length-1; i>=0; i--){
            if (!stack.isEmpty()){
                while (!stack.isEmpty() && stack.peek() <= array[i])
                    stack.pop();
            }
            nle[i] = stack.empty() ? -1 : stack.peek();
            stack.push(array[i]);
        }
        for (int i=0; i<array.length; i++)
            System.out.println(array[i] + " --> " + nle[i]);
    }

    /* reverse stack using recursion */

    public static void main(String[] args){

    }
}
