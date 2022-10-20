import java.util.Scanner;

public class next_and_previous {
    static class ListNode
    {
        int val ;
        ListNode next ;
        ListNode(int val)
        {
            this.val = val ;
            next = null ;
        }
    }
    public static ListNode head = null ;
    public static ListNode tail = null ;
    static void insert(int val)
    {
        ListNode temp = new ListNode(val) ;
        ListNode current = head ;
        if(head == null)
        {
            head = temp ;
            tail = temp ;
        }
        else
        {
            temp.next = current ;
            head = temp ;
        }
        System.out.println(val+" added !") ;
    }
    static ListNode finder(ListNode head , int High) // returns node next to value asked :
    {
        ListNode current = head ;
        ListNode temp = null ;
        if(head == null)
            return null ;
        else
        {
            while (current != null)
            {
                if(current.val == High)
                    temp = current ;
                current = current.next ;
            }
        }
        return temp ;
    }
    static ListNode reversed(ListNode head) // reverses the list so that next node becomes previous node :
    {
        ListNode current = head ;
        ListNode prev = null ;
        ListNode forward;
        if(head == null || head.next == null)
            return head ;
        else
        {
            tail = current ;
            while (current != null)
            {
                forward = current.next ;
                current.next = prev ;
                prev = current ;
                current = forward ;
            }
            head = prev ;
        }
        return head ;
    }
    static void show(ListNode head)
    {
        ListNode current = head ;
        int length = 0 ;
        if(head == null) {
            System.out.println("N/A");
        }
        else
        {
            while (current != null)
            {
                System.out.print(current.val+"->");
                current = current.next ;
                length++ ;
            }
            System.out.print("//size("+length+")//");
        }
    }
    static boolean check(ListNode head , int val) //check if value , searching for , is even available within List :
    {
        ListNode current = head ;
        while (current != null)
        {
            if(current.val == val)
                return true ;
            current = current.next ;
        }
        return false ;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        System.out.print("Number of nodes initially : ");
        int no = sc.nextInt() ;
        if(no == 0)
            System.out.println("N/A");
        else {
            System.out.print("assign data's to node's : ");
            while (no-- > 0) {
                int value = sc.nextInt();
                insert(value);
            }
            show(head);
            System.out.println("\n// head -> " + head.val + " //" + "\n// tail -> " + tail.val + "//");
            System.out.print("Enter value to find next and previous node : ");
            int val0 = sc.nextInt();
            if(!check(head, val0))
                System.out.println("such node doesn't exist !");
            else {
                if (val0 == head.val) {
                    System.out.println("node next to " + val0 + " : " + finder(head, val0).next.val);
                    System.out.println("node before to " + val0 + " : " + null);
                } else if (val0 == tail.val) {
                    System.out.println("node next to " + val0 + " : " + null);
                    System.out.println("node before to " + val0 + " : " + finder(reversed(head), val0).next.val);
                } else {
                    System.out.println("node next to " + val0 + " : " + finder(head, val0).next.val);
                    System.out.println("node before to " + val0 + " : " + finder(reversed(head), val0).next.val);
                }
            }
        }
    }
}