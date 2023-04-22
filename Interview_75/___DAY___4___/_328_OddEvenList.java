public class _328_OddEvenList {
    public static void main(String[] args) {
        SOLVEDAY4 object = new SOLVEDAY4() ;
        ListNode head = new ListNode() ;
        head = head.DEMOLIST(head) ;
        System.out.println("Original : ") ;
        head.SHOW(head);
        head = object.oddEvenList(head) ;
        System.out.println("\nSorted by OddEven order: ") ;
        head.SHOW(head);
    }
}
