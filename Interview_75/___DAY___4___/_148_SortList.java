public class _148_SortList {
    public static void main(String[] args) {
        SOLVEDAY4 object = new SOLVEDAY4() ;
        ListNode head = new ListNode() ;
        head = head.DEMOLIST(head) ;
        System.out.println("Before sorting : ") ;
        head.SHOW(head);
        head = object.sortList(head) ;
        System.out.println("\nAfter sorting : ") ;
        head.SHOW(head) ;
    }
}
