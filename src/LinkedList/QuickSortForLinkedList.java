package LinkedList;

public class QuickSortForLinkedList {
    static class Node {
        int key;
        Node next;
        Node(int key){
            this.key = key;
            next = null;
        }
    }

    Node head;
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

    private void print(Node node){
        while (node!=null){
            System.out.print(node.key+" ");
            node = node.next;
        }
    }

    static private Node partition(Node start, Node end){
        if (start == end || start == null || end == null)
            return start;
        Node pivot_prev = start;
        Node current = start;
        int pivot = end.key;
        /* iterate one before end, bcz last one is pivot */
        while (start!=end){
            if (start.key < pivot){
                // keep track of last modified node
                pivot_prev = current;
                int temp = current.key;
                current.key = start.key;
                start.key = temp;
                current = current.next;
            }
            start = start.next;
        }
        // swap pivot
        int temp = current.key;
        current.key = pivot;
        end.key = temp;
        /* return one previous to current bcz current is now pointing to pivot*/
        return pivot_prev;
    }

    // quick sort
    void sort(Node start, Node end){
        if (start == null || start == end || start == end.next)
            return;
        // split list and partition result
        Node pivot_prev = partition(start, end);
        sort(start, pivot_prev);
        /*  if pivot is picked and moved to the start, that means
            start and pivot is same
            so pick from next of pivot */
        if (pivot_prev!=null && pivot_prev == start){
            sort(pivot_prev.next, end);
        }
        /*  if pivot is in between of the list,
            start from next of pivot,
            since we have pivot , so we move two nodes */
        else if (pivot_prev!=null && pivot_prev.next!=null)
            sort(pivot_prev.next.next, end);
    }

    public static void main(String[] args){
        QuickSortForLinkedList sort = new QuickSortForLinkedList();
        sort.add(15);
        sort.add(4);
        sort.add(8);
        sort.add(7);
        sort.add(9);
        Node n = sort.head;
        while (n.next!=null)
            n = n.next;
        System.out.println("partition: " + partition(sort.head, n).key);
        sort.sort(sort.head, n);
        sort.print(sort.head);
    }

}
