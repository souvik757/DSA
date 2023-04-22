public class SOLVEDAY4 {
    // QUES 328. Odd Even Linked List
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.SIZE(head,0) < 3) return head ;


        ListNode T = head ;
        ListNode H = head.next ;
        ListNode Even = head.next ;

        while (T.next != null && H != null) {
            if (H.next == null) {
                return head ;
            }
            T.next = H.next ;
            T = T.next ;
            H.next = T.next ;
            T.next = Even ;
            H = H.next ;
        }

        return head ;
    }

    // QUES 148. Sort The List
    public ListNode sortList(ListNode head) {
        return sort(head) ;
    }
    private ListNode sort(ListNode head) {
        if (head == null || head.next == null) return head ;
        ListNode LEFT  = head ;
        ListNode RIGHT = head.GETMID(head).next ;
        head.GETMID(head).next = null ;

        LEFT  = sort(LEFT) ;
        RIGHT = sort(RIGHT) ;

        return MERGE(LEFT,RIGHT) ;
    }
    private ListNode MERGE(ListNode left , ListNode right) {
        ListNode CURRENT = new ListNode(999) ; // false node holding the LIST
        ListNode TEMP = CURRENT ;
        while (left != null && right != null) {
            if (left.data < right.data) {
                TEMP.next = left ;
                TEMP = TEMP.next ;
                left = left.next ;
            }
            else {
                TEMP.next = right  ;
                TEMP  = TEMP.next  ;
                right = right.next ;
            }
        }

        TEMP.next = (left != null) ? left : right ;

        return CURRENT.next ;
    }
}
