public class _234_palindromeLinkedList {
    public static void main(String[] args) {
        SOLVEDAY3 object = new SOLVEDAY3() ;
        ListNode HEAD  = new ListNode(1) ;
        ListNode NODE1 = new ListNode(2) ;
        ListNode NODE2 = new ListNode(3) ;
        ListNode NODE3 = new ListNode(2) ;
        ListNode TAIL  = new ListNode(1) ;
        HEAD.next  = NODE1 ;
        NODE1.next = NODE2 ;
        NODE2.next = NODE3 ;
        NODE3.next = TAIL ;
        TAIL.next  = null  ;

        HEAD.SHOW(HEAD) ;
        System.out.println("\nIs it Palindrome ? "+ object.isPalindrome(HEAD)) ;
        System.out.println("\nIs it Palindrome ? "+ object._isPalindrome_(HEAD)) ;
    }
}
