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
    // Demo List :
    public ListNode DEMOLIST(ListNode HEAD) {
        HEAD = new ListNode(20) ;
        ListNode NODE1 = new ListNode(17) ;
        ListNode NODE2 = new ListNode(10) ;
        ListNode NODE3 = new ListNode(11) ;
        ListNode NODE4 = new ListNode(12) ;
        ListNode NODE5 = new ListNode(16) ;
        ListNode NODE6 = new ListNode(15) ;
        ListNode NODE7 = new ListNode(14) ;
        ListNode NODE8 = new ListNode(13) ;
        ListNode NODE9 = new ListNode(19) ;
        ListNode TAIL  = new ListNode(18) ;
        HEAD.next  = NODE1 ;
        NODE1.next = NODE2 ;
        NODE2.next = NODE3 ;
        NODE3.next = NODE4 ;
        NODE4.next = NODE5 ;
        NODE5.next = NODE6 ;
        NODE6.next = NODE7 ;
        NODE7.next = NODE8 ;
        NODE8.next = NODE9 ;
        NODE9.next = TAIL  ;

        return HEAD ;
    }
}