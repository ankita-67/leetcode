class Linked
{
    int data;
    Linked next;
    Linked(int data)
    {
        this.data = data;
        next=null;
    }
}

public class addlinkedList {
    static void printList(Linked head) {
        Linked curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Linked num1 = new Linked(2);
        num1.next = new Linked(4);
        num1.next.next = new Linked(3);
        printList(num1);
        Linked num2 = new Linked(5);
        num2.next = new Linked(6);
        num2.next.next = new Linked(4);
        printList(num2);
        Linked res =  addTwoNumbers(num1,num2 );
        printList(res);
    }

    private static Linked addTwoNumbers(Linked num1, Linked num2) {

        Linked dummy = new Linked(0);
        Linked curr = dummy;
        int carry =0;
        while(num1 != null || num2 != null || carry !=0)
        {
            int sum = (num1 == null?0:num1.data)+ (num2 == null?0:num2.data)+carry;

            carry = sum/10;

            curr.next = new Linked(sum%10);

            curr = curr.next;

            num1 = num1==null?null:num1.next;
            num2 = num2==null?null:num2.next;
        }
return dummy.next;

    }

}
