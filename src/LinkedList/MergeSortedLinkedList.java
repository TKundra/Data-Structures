package LinkedList;

public class MergeSortedLinkedList {
    static class Node{
        int key;
        Node next;
        Node(int key){
            this.key = key;
            next = null;
        }
        Node(){}
    }
    Node head;

    private void merge(Node node1, Node node2){
        // dummy node, to hang results on
        /*
                dummy -> 1 -> 2 -> 3
                node

                at the end
                    head = dummy.net; {to start from 1}
        */
        Node dummy = new Node();
        Node tail = dummy;
        while (node1!=null && node2!=null){
            if (node1.key < node2.key){
                tail.next = node1;
                node1 = node1.next;
            }else {
                tail.next = node2;
                node2 = node2.next;
            }
            tail = tail.next;
        }
        /* extract all remaining elements */
        while (node1!=null){
            tail.next = node1;
            node1 = node1.next;
            tail = tail.next;
        }
        while (node2!=null){
            tail.next = node2;
            node2 = node2.next;
            tail = tail.next;
        }
        head = dummy.next;
    }

    private void print(Node node){
        while (node!=null){
            System.out.print(node.key+" ");
            node = node.next;
        }
    }

    public static void main(String[] args){
        MergeSortedLinkedList merge = new MergeSortedLinkedList();
        Node head1;
        head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(4);
        head1.next.next.next = new Node(5);
        Node head2;
        head2 = new Node(2);
        head2.next = new Node(6);
        head2.next.next = new Node(7);
        merge.merge(head1, head2);
        merge.print(merge.head);
    }

}
