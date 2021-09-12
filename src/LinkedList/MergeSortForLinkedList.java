package LinkedList;

public class MergeSortForLinkedList {
    static class Node {
        int key;
        Node next;
        Node(int key){
            this.key = key;
            next = null;
        }
    }

    static Node head = null;
    private void add(int key){
        Node node = new Node(key);
        if (head == null){
            head = node;
            return;
        }
        Node last = head;
        while (last.next!=null)
            last = last.next;
        last.next = node;
    }
    private void print(Node node) {
        while (node != null) {
            System.out.print(node.key + " ");
            node = node.next;
        }
    }

    // get middle of linked list
    static private Node middle(Node node){
        Node slow = node;
        Node fast = node.next;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // merge sort
    static private Node mergeSort(Node node){
        if (node.next == null)
            return node;
        Node middle = middle(node);
        Node nextOfMiddle = middle.next;
        // set next of middle to null
        middle.next = null;
        // apply merge on left
        Node left = mergeSort(node);
        // apply merge on right
        Node right = mergeSort(nextOfMiddle);
        // merge left and right list
        return merge(left, right);
    }

    // merge
    static private Node merge(Node first, Node second){
        Node dummy = new Node(-1);
        Node tail = dummy;

        while (first!=null && second!=null){
            if (first.key <= second.key){
                tail.next = first;
                first = first.next;
            }else {
                tail.next = second;
                second = second.next;
            }
            tail = tail.next;
        }
        // make them empty
        while (first!=null){
            tail.next = first;
            first = first.next;
            tail = tail.next;
        }
        // make them empty
        while (second!=null){
            tail.next = second;
            second = second.next;
            tail = tail.next;
        }

        return dummy.next;
    }

    public static void main(String[] args){
        MergeSortForLinkedList mergeSort = new MergeSortForLinkedList();
        mergeSort.add(15);
        mergeSort.add(10);
        mergeSort.add(5);
        mergeSort.add(20);
        mergeSort.add(3);
        mergeSort.add(2);
        head = mergeSort(head);
        mergeSort.print(head);
    }

}
