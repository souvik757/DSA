import java.util.HashMap;
import java.util.Map;

public class _138_CopyListWithRandomPointer {
    public static void main(String[] args) {

    }
}
class SOLVE138 {
    private Map<Node,Node> deepCopy = new HashMap<>() ;
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        if(deepCopy.containsKey(head))
            return deepCopy.get(head);
        Node newCopy = new Node(head.val) ;
        deepCopy.put(head , newCopy) ;
        newCopy.next = copyRandomList(head.next);
        newCopy.random = copyRandomList(head.random);

        return newCopy ;
    }
}
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