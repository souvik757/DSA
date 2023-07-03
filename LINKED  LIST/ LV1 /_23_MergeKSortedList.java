import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class _23_MergeKSortedList {
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3] ;
        for (int i = 0 ; i < 3 ; i ++)
            lists[i] = new ListNode(-1) ;
        for (ListNode head : lists){
            int val = 0 ;
            while (val != -999){
                val = new Scanner(System.in).nextInt() ;
                head = head.insert_head(head , val) ;
            }
        }
        for (ListNode head : lists)
            head.show(head);
        ListNode answer = SOLVE_23.mergeKLists(lists) ;
        assert answer!=null ;
        answer.show(answer);
    }
}
class SOLVE_23 {
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null ;
        ListNode tail = null ;
        PriorityQueue<Integer> minheap = new PriorityQueue<>() ;
        int k = lists.length ;
        if (k == 0) return null ;
        for (int i = 0 ; i < k ; i ++){
            if (lists[i] != null) {
                minheap.offer(lists[i].data);
                lists[i] = lists[i].next ;
            }
        }

        if (minheap.isEmpty())
            return null ;
        else
            head = new ListNode(minheap.poll()) ;
        ListNode temp = head ;
        while (!minheap.isEmpty()){
            temp.next = new ListNode(minheap.poll()) ;
            temp = temp.next ;
        }
        tail = temp ;
        tail.next = null ;

        return head ;
    }
}