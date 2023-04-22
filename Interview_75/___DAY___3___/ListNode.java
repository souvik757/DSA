// This is a NODE for LinkedList creation .
public class ListNode {
    int data ;
    ListNode next ;

    public ListNode() {
    }

    public ListNode(int data) {
        this.data = data;
        next = null;
    }
    public void SHOW(ListNode head) {
        if (head == null)
            return ;
        System.out.print("-> "+head.data) ;
        SHOW(head.next) ;
    }
    public int SIZE(ListNode head , int length) {
        if ( head == null )
            return length ;
        return SIZE(head.next , length+1) ;
    }
    public void NULLLIST(ListNode head , ListNode NULL_LIST) {
        int size = head.SIZE(head,0) ;
        ListNode current = NULL_LIST ;
        while ( size-->1 ) {
            ListNode TEMP = new ListNode(-1) ;
            current.next = TEMP ;
            current = current.next ;
        }
        current.next = null ;
    }
}
