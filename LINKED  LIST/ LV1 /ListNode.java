public class ListNode {
    int data;
    ListNode next ;
    public ListNode() {
    }
    public ListNode(int val) {
        this.data = val;
        this.next = null ;
    }
    public void show (ListNode Node){
        if(Node == null)
            return ;
        System.out.print("->"+Node.data) ;
        show(Node.next) ;
    }
    public ListNode insert_head(ListNode head , int value){
        ListNode temp = new ListNode(value) ;
        temp.next = head ;
        head = temp ;

        return head ;
    }
    public ListNode insert_tail(ListNode head , int value){
        ListNode temp = new ListNode(value) ;
        ListNode current = new ListNode() ;
        current = head ;
        while (current.next != null){
            current = current.next ;
        }
        current.next = temp ;

        return head ;
    }
    public ListNode GetDemoList(ListNode head , int max){
        head = new ListNode(max) ;
        ListNode current = head ;
        while ( max > 1){
            max-- ;
            current.next = new ListNode(max) ;
            current = current.next ;
        }
        return head ;
    }
}
