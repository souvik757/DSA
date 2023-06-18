package Lv1;

import java.util.* ;

public class _117_PopulateNextRightPointer {
    public static void main(String[] args) {
        SOLVE_117 object = new SOLVE_117() ;
        Node root = new Node() ;
        root = root.CreateByLevel(root) ;
        object.connect(root) ;
    }
}
class SOLVE_117{
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>() ; // n space
        List<Node> store = new ArrayList<>() ; // n space

        queue.add(root) ;
        queue.add(null) ;
        while (!queue.isEmpty()){ // traversing full tree O(n)
            System.out.println("here");
            Node temp = queue.remove() ;
            if(temp == null){
                store.add(null);
                if(!queue.isEmpty())
                    queue.add(null) ;
            }
            else {
                store.add(temp);
                if(temp.left != null)
                    queue.add(temp.left) ;

                if(temp.right != null)
                    queue.add(temp.right) ;
            }
        }

        int i = 0 ;
        while (i < store.size()){ // traversing list of length full tree O(n)
            if(store.get(i) == null) {
                i = i + 1 ;
            }
            else {
                store.get(i).next = store.get(i + 1);
                i++;
            }
        }

        return root ;
    } // runtime - O(2n) , n is the number of nodes , that is O(n) fine
      // space is also O(2n) , have to reduce to O(1)
    /*
     // -- O(n) space solution
        queue.add(root) ;
        queue.add(null) ;
        while (!queue.isEmpty()){ // traversing full tree O(n)
            Node temp = queue.remove() ;
            if(temp == null){
                if(!queue.isEmpty())
                    queue.add(null) ;
            }
            else {
                temp.next = queue.peek() ; // just point the top() element to second top() element .
                if(temp.left != null)
                    queue.add(temp.left) ;

                if(temp.right != null)
                    queue.add(temp.right) ;
            }
        }
     */
}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
    public Node CreateByLevel(Node root){
        int val ;
        Queue<Node> queue = new LinkedList<>() ;
        val = new Scanner(System.in).nextInt() ;
        root = new Node(val) ;
        queue.add(root) ;
        while (!queue.isEmpty()){
            Node temp = queue.remove() ;
            val = new Scanner(System.in).nextInt() ;
            if(val != -1){
                temp.left = new Node(val) ;
                queue.add(temp.left) ;
            }
            val = new Scanner(System.in).nextInt() ;
            if(val != -1){
                temp.right = new Node(val) ;
                queue.add(temp.right) ;
            }
        }
        return root ;
    }
}