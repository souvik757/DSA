public class sort_list_0_1 {
    public static void main(String[] args) {
        SOLVE_01LIST object = new SOLVE_01LIST() ;
        object._FUNCTION_() ;
    }
}
class SOLVE_01LIST{
    public void _FUNCTION_() {
        ListNode head = new ListNode(1) ;
        ListNode n1 = new ListNode(0) ;
        ListNode n2 = new ListNode(1) ;
        ListNode n3 = new ListNode(2) ;
        ListNode n4 = new ListNode(0) ;
        ListNode n5 = new ListNode(1) ;
        ListNode tail = new ListNode(2) ;
        head.next = n1 ;
        n1.next = n2 ;
        n2.next = n3 ;
        n3.next = n4 ;
        n4.next = n5 ;
        n5.next = tail ;
        tail.next = null ;
        show_list(head);
        show_list(sort(head));
        show_list(sort_1(head));
    }
    private ListNode sort(ListNode head) // T.C : O(n) S.C : O(1)
    {
        if(head == null)
            return null;
        int ZeroCount = 0 ;
        int OneCount  = 0 ;
        int TwoCount  = 0 ;
        ListNode current = head ;
        while (current != null)
        {
            if(current.data == 0)
                ZeroCount++ ;
            else if(current.data == 1)
                OneCount++ ;
            else
                TwoCount++ ;
            current = current.next ;
        }
        current = head ;
        while (current != null)
        {
            if (ZeroCount--> 0)
            {
                current.data = 0 ;
            }
            else if (OneCount--> 0)
            {
                current.data = 1 ;
            }
            else if (TwoCount--> 0)
            {
                current.data = 2 ;
            }
            current = current.next ;
        }
        System.out.println("SORTED");
        return head ;
    }
    private ListNode sort_1(ListNode head) // T.C : O(n) S.C : O(1)
    {
        if(head == null)
            return null ;
        ListNode ZeroHead = new ListNode(-1) ;
        ListNode ZeroTail = ZeroHead ;
        ListNode OneHead = new ListNode(-1) ;
        ListNode OneTail = OneHead ;
        ListNode TwoHead = new ListNode(-1) ;
        ListNode TwoTail = TwoHead ;
        ListNode current = head ;
        while( current != null)
        {
            int val = current.data ;
            if( val == 0 ) {
                ZeroTail.next = current ;
                ZeroTail = current ;
            } else if (val == 1) {
                OneTail.next = current ;
                OneTail = current ;
            } else if (val == 2) {
                TwoTail.next = current ;
                TwoTail = current ;
            }
            current = current.next ;
        }
        if(OneHead.next != null)
            ZeroTail.next = OneHead.next ;
        else
            ZeroTail.next = TwoHead.next ;
        OneTail.next = TwoHead.next ;
        TwoTail.next = null ;
        head = ZeroHead.next ;
        System.gc() ;
        return head ;
    }

    private void show_list(ListNode head)
    {
        if(head == null)
            return ;
        ListNode current = head ;
        while (current != null)
        {
            System.out.print(current.data+"->");
            current = current.next ;
        }
        System.out.println("NULL");
    }
}
class node
{
    int data ;
    ListNode next ;
    node(int data){ this.data = data ; next = null ; }
}
