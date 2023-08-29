package Problems;

import java.util.List;

/**
 * Definition for singly-linked list.
 */
 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) {
         this.val = val;
     }
 }
public class _234_PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true ;
        ListNode temp1 = head ;
        ListNode temp2 = reverse(getMiddle(head)) ;
        while (temp1 != null && temp2 != null){
            if(temp1.val != temp2.val)
                return false ;
            temp1 = temp1.next ;
            temp2 = temp2.next ;
        }
        return true ;
    }
    private ListNode getMiddle(ListNode head){
        ListNode tortoise = head ;
        ListNode hare = head ;
        while (hare.next != null && hare.next.next != null){
            tortoise = tortoise.next ;
            hare = hare.next.next ;
        }

        return tortoise ;
    }
    private ListNode reverse(ListNode head){
        ListNode prev = null ;
        ListNode forward ;
        ListNode current = head ;
        while (current != null){
            forward = current.next ;
            current.next = prev ;
            prev = current ;
            current = forward ;
        }
        return prev ;
    }
}
