import java.util.Map ;
import java.util.HashMap ;
import java.util.Scanner;

public class _82_RemoveDuplicateFromSorted_II {
    public static void main(String[] args) {
        SOLVE82 object = new SOLVE82() ;
        SOLVE82Constant obj = new SOLVE82Constant() ;
        ListNode head = new ListNode() ;
        head = head.GetDemoList(head , 5);
        head.show(head);
        System.out.println();
        int val = 0;
        while (val != -1){
            val = new Scanner(System.in).nextInt() ;
            if(val != -1)
                head = head.insert_head(head , val);
        }
        head.show(head);
//        head = object.deleteDuplicates(head) ;
        head = obj.deleteDuplicates(head) ;
        System.out.println();
        head.show(head);
    }
}
class SOLVE82{ // naive approach using HashMap<>() :::
    Map<Integer, Integer> frequency = new HashMap<>() ;
    public ListNode deleteDuplicates(ListNode head) {
        UpdateMap(head) ;
        for(Map.Entry<Integer,Integer> entry : frequency.entrySet()){
            if(entry.getValue() > 1) {
//                System.out.println(entry.getKey()+" has multi occ");
                head = DeleteAllOcc(head, entry.getKey());
            }
        }
//        System.gc() ;
        return head ;
    }
    private void UpdateMap(ListNode head){
        ListNode current = head ;
        while (current != null){
            frequency.put(current.data, frequency.getOrDefault(current.data, 0)+1) ;
            current = current.next ;
        }
//        System.out.println(frequency);
    }
    private ListNode DeleteAllOcc(ListNode head , int val){
        ListNode current = head ;
        if(head == null)
            return null;
        while (current != null && current.data == val){
            current = current.next;
            head = current ;
        }
        ListNode prev = new ListNode(-1) ; // following node after current :::
        while (current != null){
            if(current.data == val)
                prev.next = current.next ;
            else
                prev = current ;
            current = current.next ;
        }

        return head ;
    }
}
class SOLVE82Constant{ // only 'll work on sorted list :::
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode prev = new ListNode(-1) ; // prev|----> head|---->
        ListNode current = prev ;
        current.next = head ;
        while (current.next != null && current.next.next != null){
            if(current.next.data == current.next.next.data){ // head != null && head.next != null
                int duplicate = current.next.data; // store the duplicate value to traverse until found unique :::
                while (current.next != null && current.next.data == duplicate){ // keep skipping duplicate :::
                    current.next = current.next.next ;
                }
            }
            else
                current = current.next ;
        }
        return prev.next ;
    }
}