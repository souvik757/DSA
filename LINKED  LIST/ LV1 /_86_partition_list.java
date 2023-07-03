public class _86_partition_list {
    public static void main(String[] args) {
        SOLVE86 object = new SOLVE86() ;
        ListNode head = new ListNode() ;
        head = head.GetDemoList(head , 6) ;
        head.show(head);
        head = object.partition(head , 4) ;
        System.out.println();
        head.show(head);
    }
}
class SOLVE86{
    private final int[] x_range = new int[]{-200,200} ;
    public ListNode partition(ListNode head, int x) {
        if (x < x_range[0] && x > x_range[1])
            System.exit(0);
        if(head == null) return null ;
        ListNode head1 = new ListNode(-1) ;
        ListNode head2 = new ListNode(-1) ;
        ListNode current = head ;
        ListNode temp1 = head1 ;
        ListNode temp2 = head2 ;
        while (current != null){
            if(current.data < x) {
                temp1.next = new ListNode(current.data) ;
                temp1 = temp1.next ;
            }
            else{
                temp2.next = new ListNode(current.data) ;
                temp2 = temp2.next ;
            }
            current = current.next ;
        }
        temp1.next = head2.next ;

        return head1.next ;
    }
}