public class _92_ReverseList_II {
    public static void main(String[] args) {
        SOLVE92 object = new SOLVE92() ;
        ListNode head = new ListNode() ;
        head = head.GetDemoList(head , 100) ;
        head.show(head);
        System.out.println();
        head = object.reverseBetween(head , 28 , 89) ;
        head.show(head) ;
    }
}
class SOLVE92{
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode ref_0 = head ;
        ListNode ref_1 = head ;
        pair<ListNode, ListNode> leftNode  = getElement(ref_0 , left) ;
        pair<ListNode, ListNode> rightNode = getElement(ref_1 , right) ;
        if(left <= 1)
            return reverse(leftNode.current , rightNode.current.next) ;
        leftNode.previous.next = reverse(leftNode.current , rightNode.current.next) ;
        return head ;
    }
    private int length(ListNode head , int index){
        if(head == null)
            return index ;
        return length(head.next , index+1) ;
    }
    private pair<ListNode, ListNode> getElement(ListNode head , int position){
        if(position > length(head , 0))
            position = length(head,0) ;
        ListNode current = head ;
        ListNode prev = null ;
        while (position-->1){
            prev = current ;
            current = current.next ;
        }
        return new pair<>(prev , current) ;
    }
    private ListNode reverse(ListNode head , ListNode stop){
        ListNode prev = null ;
        ListNode tail = head ;
        ListNode current = head ;
        ListNode forward ;
        while (current != stop){
            forward = current.next ;
            current.next = prev ;
            prev = current ;
            current = forward ;
        }
        tail.next = stop ;
        return prev ;
    }
}
class pair<K,V>{
    K previous ;
    V current  ;
    public pair() {
    }
    public pair(K previous, V current) {
        this.previous = previous;
        this.current = current;
    }
}
