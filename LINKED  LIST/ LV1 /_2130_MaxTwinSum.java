public class _2130_MaxTwinSum {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1) ;
        ListNode node2 = new ListNode(2) ;
        ListNode node3 = new ListNode(30) ;
        ListNode node4 = new ListNode(4) ;
        ListNode node5 = new ListNode(5) ;
        ListNode tail  = new ListNode(6) ;
        head1.next = node2 ;
        node2.next = node3 ;
        node3.next = node4 ;
        node4.next = node5 ;
        node5.next = tail ;
        tail.next =null ;
        Solution object = new Solution() ;
        System.out.println(object.pairSum(head1));
    }
}
class Solution {
    private int MaxSum = Integer.MIN_VALUE ;
    public int pairSum(ListNode head) {
        ListNode temp0 = head ;
        ListNode mid = MID(head) ;
        ListNode temp1 = reverse(mid.next) ;
        mid.next = null ;
        while (temp0 != null){
            MaxSum = Math.max(MaxSum , temp0.val+temp1.val) ;
            temp0 = temp0.next ;
            temp1 = temp1.next ;
        }
        return MaxSum ;
    }
    private ListNode MID(ListNode head){
        ListNode t = head ;
        ListNode h = head ;
        while (h.next != null && h.next.next != null){
            t = t.next ;
            h = h.next.next ;
        }
        return t ;
    }
    private ListNode reverse(ListNode head){
        ListNode curr = head ;
        ListNode prev = null ;
        ListNode forward ;
        while (curr != null){
            forward = curr.next ;
            curr.next = prev ;
            prev = curr ;
            curr = forward ;
        }
        return prev ;
    }
}
