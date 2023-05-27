import java.util.HashMap;
import java.util.Map;

// * -- Node Definition --
final class Node {
    int val;
    Node next;
    Node random;
    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class _138_CopyListWithRandomPointer {
    public static void main(String[] args) {
        SOLVE138  object1 = new SOLVE138()  ;
        SOLVE_138 object2 = new SOLVE_138() ;
    }
}
class SOLVE_138{// T.C : O(n) S.C : O(1)
    public Node copyRandomList(Node head) {
        // * -- create a clone list out of original list -- step 1
        Node demo = new Node(-1) ;
        Node DeepCopy = null ;
        DeepCopy = CopyList(demo , head) ;

        // * -- add elements of clone-list in between original list -- step 2
        Node original = head ;
        Node current  = DeepCopy ;
        while (original != null){
            // * -- changes in original list --
            Node next = original.next ;
            original.next = current ;
            original = next ;
            // * -- changes in copied list --
            next = current.next ;
            current.next = original ;
            current = next ;
        }

        // * -- create link of random pointer -- step 3
        Node temp = head ;
        while (temp != null){
            if(temp.next != null)
                temp.next.random = (temp.random == null) ? null : temp.random.next ;
            if(temp.next != null)
                temp = temp.next.next ;
        }

        // * -- revert changes made in step 2 -- step 4
        original = head ;
        current = DeepCopy ;
        while (original != null && current != null){
            original.next  = current.next ;
            original = original.next ;
            if(original != null)
                current.next = original.next ;
            current = current.next ;
        }

        return DeepCopy ;
    }
    private Node CopyList(Node demo , Node head){
        Node next = demo ;
        Node temp = head ;
        while (temp != null){
            next.next = new Node(temp.val) ;
            next = next.next ;
            temp = temp.next ;
        }
        return demo.next ;
    }
}
class SOLVE138 { // T.C : O(n) S.C : O(n)
    private final Map<Node , Node> nodeMap = new HashMap<>() ;
    public Node copyRandomList(Node head) {
        Node demo = new Node(-1) ;
        Node DeepCopy = null ;
        DeepCopy = CopyList(demo , head) ;
        Node original = head ;
        Node current  = DeepCopy ;

        while (original != null){
            nodeMap.put(original , current) ;
            original = original.next ;
            current  = current.next  ;
        }
        original = head ;
        current = DeepCopy ;
        while (current != null){
            current.random = nodeMap.get(original.random) ;
            current = current.next ;
            original = original.next ;
        }

        return DeepCopy ;
    }
    private Node CopyList(Node demo , Node head){
        Node next = demo ;
        Node temp = head ;
        while (temp != null){
            next.next = new Node(temp.val) ;
            next = next.next ;
            temp = temp.next ;
        }
        return demo.next ;
    }
}