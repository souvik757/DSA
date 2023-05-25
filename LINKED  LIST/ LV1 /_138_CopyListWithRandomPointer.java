import java.util.HashMap;
import java.util.Map;

public class _138_CopyListWithRandomPointer {
    public static void main(String[] args) {
        SOLVE138 object = new SOLVE138() ;
    }
}
class SOLVE138 {
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