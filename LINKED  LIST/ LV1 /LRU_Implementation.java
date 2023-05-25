import java.util.Map ;
import java.util.HashMap ;
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//        [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
public class LRU_Implementation {
    static int capacity = 2 ;
    public static void main(String[] args) {
        LRUCache obj = new LRUCache(capacity);
        obj.put(1,1);
        obj.put(2,2);
        obj.get(1)  ;
        obj.put(3,3);
        obj.get(2)  ;
        obj.put(4,4);
        obj.get(1)  ;
        obj.get(3)  ;
        obj.get(4)  ;
    }
}
class LRUCache {
    private int capacity ;
    private ListDouble head = new ListDouble(0 , 0) ;
    private ListDouble tail = new ListDouble(0 , 0) ;
    private Map<Integer , ListDouble> valueMap = new HashMap<>() ;

    public LRUCache(int capacity) {
        this.capacity = capacity ;
        head.next = tail ;
        tail.prev = head ;
    }
    public int get(int key) {
        if(valueMap.containsKey(key)){
            ListDouble node = valueMap.get(key) ;
            head.delete(node , valueMap);
            head.insert(node, head , valueMap);
            return node.val ;
        }
        return -1 ;
    }
    public void put(int key, int value) {
        if(valueMap.containsKey(key))
            head.delete(valueMap.get(key) , valueMap);
        if(valueMap.size() == capacity)
            head.delete(tail.prev , valueMap);
        head.insert(new ListDouble(key,value) , head , valueMap);
    }
}
// * -- Doubly Linked List -- with key-val pair --
class ListDouble{
    int key ;
    int val ;
    ListDouble prev ;
    ListDouble next ;
    public ListDouble(int key, int val) {
        this.key = key;
        this.val = val;
    }
    public void insert(ListDouble node ,ListDouble head , Map<Integer,ListDouble> valueMap){
        valueMap.put(node.key , node) ;
        node.next = head.next ;
        node.next.prev = node ;
        head.next = node ;
        node.prev = head ;
    }
    public void delete(ListDouble node ,Map<Integer,ListDouble> valueMap){
        valueMap.remove(node.key) ;
        node.prev.next = node.next ;
        node.next.prev = node.prev ;
    }
}