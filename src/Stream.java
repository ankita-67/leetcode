import java.util.*;


class Node1 {
    int data;
    Node1 next, bottom;

    Node1(int newData) {
        data = newData;
        next = bottom = null;
    }
}
public class Stream {
    public static void main(String[] args) {

        Node1 head = new Node1(5);
        head.bottom = new Node1(7);
        head.bottom.bottom = new Node1(8);
        head.bottom.bottom.bottom = new Node1(30);

        head.next = new Node1(10);
        head.next.bottom = new Node1(20);

        head.next.next = new Node1(19);
        head.next.next.bottom = new Node1(22);
        head.next.next.bottom.bottom = new Node1(50);

        head.next.next.next = new Node1(28);

        // Function call
        head = flatten(head);

        printList(head);

    }

    private static Node1 flatten(Node1 root) {
        List<Integer> values = new ArrayList<>();

        // Push values of all nodes into a list
        while (root != null) {
            // Push the head node of the sub-linked-list
            values.add(root.data);

            // Push all the nodes of the sub-linked-list
            Node1 temp = root.bottom;
            while (temp != null) {
                values.add(temp.data);
                temp = temp.bottom;
            }

            // Move to the next head node
            root = root.next;
        }

        // Sort the node values in ascending order
        Collections.sort(values);
        return  root;
    }
    static void printList(Node1 head) {
        Node1 temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.bottom;
        }
        System.out.println();
    }
}
