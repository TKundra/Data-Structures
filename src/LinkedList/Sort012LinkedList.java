package LinkedList;

public class Sort012LinkedList {
    static class Node{
        int key;
        Node next;
        Node(int key){
            this.key = key;
            next = null;
        }
    }
    Node head;

    private void sort(){
        Node node = head;
        int[] count = {0,0,0};
        // store frequency of elements
        while (node!=null){
            count[node.key]++;
            node = node.next;
        }
        int i=0;
        node = head;
        while (node != null) {
            // increment i, when frequency becomes 0
            if (count[i] == 0){
                i++;
            }else {
                // else update values in node.key directly
                node.key = i;
                --count[i];
                node = node.next;
            }
        }
    }

    private void print(Node node){
        while (node!=null){
            System.out.print(node.key+" ");
            node = node.next;
        }
    }

    public static void main(String[] args){
        Sort012LinkedList sort = new Sort012LinkedList();
        sort.head = new Node(0);
        sort.head.next = new Node(2);
        sort.head.next.next = new Node(1);
        sort.head.next.next.next = new Node(2);
        sort.head.next.next.next.next = new Node(2);
        sort.head.next.next.next.next.next = new Node(0);
        sort.head.next.next.next.next.next.next = new Node(1);
        sort.head.next.next.next.next.next.next.next = new Node(1);
        sort.sort();
        sort.print(sort.head);
    }

}
