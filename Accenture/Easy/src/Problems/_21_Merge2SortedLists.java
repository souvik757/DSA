package Problems;

public class _21_Merge2SortedLists {
    public ListNode mergeTwoLists(ListNode list1 , ListNode list2) {
        if(list1 == null)
            return list2 ;
        if(list2 == null)
            return list1 ;
        if(list2.val < list1.val)
            return mergeTwoLists(list2 , list1) ;
        return solve(list1 , list2) ;
    }
    private ListNode solve(ListNode list1 , ListNode list2){
        if(list1.next == null){
            list1.next = list2 ;
            return list1 ;
        }

        ListNode temp1 = list1 ;
        ListNode next1 = list1.next ;

        ListNode temp2 = list2 ;
        ListNode next2 ;

        while (next1 != null && temp2 != null){
            if(temp2.val >= temp1.val && temp2.val <= next1.val){
                temp1.next = temp2 ;
                next2 = temp2.next ;
                temp2.next = next1 ;
                temp1 = temp2 ;
                temp2 = next2 ;
            }
            else {
                temp1 = next1 ;
                next1 = next1.next ;
                if(next1 == null)
                    temp1.next = temp2 ;
            }
        }

        return list1 ;
    }
}
