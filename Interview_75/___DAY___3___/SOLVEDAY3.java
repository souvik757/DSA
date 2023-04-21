public class SOLVEDAY3 {
    // QUES 19 . Remove Nth Node from LL-single-
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int _LENGTH_ = head.SIZE(head, 0);
        ListNode current  = head ;
        // if it is head
        if (n == _LENGTH_){
            head = head.next ;
            return head ;
        }
        // if it is tail
        if ( n == 1 ) {
            while (current.next.next != null) {
                current = current.next ;
            }
            current.next = null ;
            return head ;
        }

        int TraverseLength = _LENGTH_ - n ;
        ListNode previous = new ListNode() ;

        while (TraverseLength-->0) {
            previous = current ;
            current = current.next ;
        }
        previous.next = current.next ;
        current.next = null ;

        return head ;
    }

    // QUES 234 . Palindrome Linked List
    public boolean isPalindrome(ListNode head) {
        ListNode ORIGINAL = new ListNode(-1) ; // Original List
        COPY(head , ORIGINAL) ;
        ListNode NEWNODE  = REVERSE(head) ;                    // reversed head list

        int size = head.SIZE(ORIGINAL , 0) ;
        while (size-->0) {
            if (ORIGINAL.data != NEWNODE.data)
                return false ;
            ORIGINAL = ORIGINAL.next ;
            NEWNODE  = NEWNODE.next  ;
        }

        return true ;
    } // BRUTE - FORCE
    public boolean _isPalindrome_(ListNode head) { // Optimized
        if ( head == null || head.next == null )
            return true ;
        ListNode REVERSED = REVERSE(GETMIDDLE(head)) ;
        ListNode CURRENT  = head ;

        while (REVERSED != null && CURRENT != null) {
            if ( REVERSED.data != CURRENT.data) return false ;
            REVERSED = REVERSED.next ;
            CURRENT  = CURRENT.next  ;
        }

        return true ;
    }
    private ListNode REVERSE(ListNode head) {
        ListNode previous = null ;
        ListNode forward ;
        ListNode current  = head ;

        while (current != null) {
            forward  = current.next ;
            current.next = previous ;
            previous = current      ;
            current  = forward      ;
        }
        head = previous ;

        return head ;
    }
    private void COPY(ListNode HEAD , ListNode ORIGINAL) {
        ORIGINAL.NULLLIST(HEAD , ORIGINAL) ;
        ListNode head     = HEAD ;
        ListNode original = ORIGINAL ;

        while (head != null) {
            original.data = head.data ;
            original = original.next ;
            head     = head.next ;
        }
    }

    private ListNode GETMIDDLE(ListNode head) {
        ListNode tortoise = head ;
        ListNode hare     = head ;

        while (hare.next != null && hare.next.next != null) {
            hare     = hare.next.next ;
            tortoise = tortoise.next ;
        }

        return tortoise ;
    }
}
