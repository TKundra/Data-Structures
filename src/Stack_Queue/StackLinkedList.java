package Stack_Queue;

public class StackLinkedList {
    static class Node{
        int key;
        Node next;
        Node(int key){
            this.key = key;
            next = null;
        }
    }
    Node top = null;

    boolean isEmpty(){
        return top == null;
    }
    private void push(int key){
        Node node = new Node(key);
        if (isEmpty()){
            top = node;
            return;
        }
        node.next = top;
        top = node;
    }
    private int pop(){
        if (isEmpty())
            return -1;
        Node node = top;
        int key;
        key = node.key;
        top = node.next;
        return key;
    }
    private int peek(){
        if (isEmpty())
            return -1;
        return top.key;
    }
    private void print(){
        Node node = top;
        System.out.println();
        while (node!=null){
            System.out.println(node.key);
            node = node.next;
        }
    }

    public static void main(String[] args){
        StackLinkedList stack = new StackLinkedList();
        stack.push(5);
        stack.push(1);
        stack.push(7);
        stack.push(9);
        stack.push(8);
        stack.print();
        System.out.println("pop: " + stack.pop());
        stack.print();
    }
}
