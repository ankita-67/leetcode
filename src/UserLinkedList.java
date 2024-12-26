import java.util.LinkedList;

public class UserLinkedList {
Node head;;
    class Node
    {
        int data;
        Node next;

        Node (int d)
        {
            this.data = d;
        }
    }

    public static void main(String[] args) {
  UserLinkedList us = new UserLinkedList();
  us.add(us,1);
    }

    private UserLinkedList add(UserLinkedList us, int i) {
   Node node = new Node(i);
   if(us.head == null )
   {
       head = node;
   }
   else
   {
       Node node1 = head;
       while(node1.next != null)
           node1 = node1.next;

       node1.next = node;
   }
   return us;
    }

}

