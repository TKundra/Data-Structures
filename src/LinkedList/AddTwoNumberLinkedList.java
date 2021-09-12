package LinkedList;

public class AddTwoNumberLinkedList {
    static class Node{
        int key;
        Node next;
        Node(int key){
            this.key = key;
            next = null;
        }
    }
    Node head1, head2;

    private static Node reverse(Node head) {
        Node prev = null;
        Node next = null;
        Node current = head;
        while (current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    private Node add(Node node1, Node node2){
        Node first = reverse(node1);
        Node second = reverse(node2);
        int sum=0, carry=0;
        Node temp = null;
        Node result = null;
        Node prev = null;
        while (first!=null || second!=null){
            /*
		        * calculate value of next digit in resultant list.
		        * the next digit is sum of followings
		            - carry
		            - next digit of first list if there is next digit
                    - next digit of second list if there is next digit */
            int x = first!=null ? first.key : 0;
            int y = second!=null ? second.key : 0;

            sum = (carry+ x + y);
            // update carry for next calculation
            carry = (sum>=10) ? 1 : 0;
            // update sum if it is greater than 10
            sum %= 10;
            temp = new Node(sum);

            // if there is first node then set
            // it as head of resultant list
            if (result == null) {
                result = temp;
            }
            // if this is not the first
            //  node then connect it to rest
            else {
                prev.next = temp;
            }
            // set prev for next insertion
            prev = temp;

            if (first!=null)
                first = first.next;
            if (second!=null)
                second = second.next;
        }
        // when carry left as 1
        if (carry > 0){
            temp = new Node(carry);
            prev.next = temp;
            prev = temp;
        }
        result = reverse(result);
        return result;
    }

    private void print(Node node){
        while (node!=null){
            System.out.print(node.key+" ");
            node = node.next;
        }
    }

    public static void main(String[] args){
        AddTwoNumberLinkedList add = new AddTwoNumberLinkedList();
        add.head1 = new Node(3);
        add.head1.next = new Node(4);
        add.head1.next.next = new Node(5);
        add.head2 = new Node(4);
        add.head2.next = new Node(5);

        Node node = add.add(add.head1, add.head2);
        add.print(node);

    }

}
