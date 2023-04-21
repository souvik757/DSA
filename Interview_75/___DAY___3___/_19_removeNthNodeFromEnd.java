public class _19_removeNthNodeFromEnd {
    public static void main(String[] args) {
        SOLVEDAY3 object = new SOLVEDAY3() ;
        ListNode HEAD  = new ListNode(10) ;
        ListNode NODE1 = new ListNode(11) ;
        ListNode NODE2 = new ListNode(13) ;
        ListNode NODE3 = new ListNode(23) ; // has to be removed 3rd Node from End ::
        ListNode NODE4 = new ListNode(35) ;
        ListNode TAIL  = new ListNode(60) ;
        HEAD.next  = NODE1 ;
        NODE1.next = NODE2 ;
        NODE2.next = NODE3 ;
        NODE3.next = NODE4 ;
        NODE4.next = TAIL ;
        TAIL.next  = null ;

        HEAD.SHOW(HEAD) ;

        HEAD = object.removeNthFromEnd(HEAD , 5) ;
        System.out.println("\nAfter removing :: ");
        HEAD.SHOW(HEAD) ;
    }
}
