import java.util.Queue      ;
import java.util.Scanner    ;
import java.util.LinkedList ;
// Node for binary tree :::
public class TreeNode {
    int val        ;
    TreeNode left  ;
    TreeNode right ;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val   = val   ;
        this.left  = null  ;
        this.right = null  ;
    }
    public TreeNode InsertByLevel(TreeNode root) {
        int DATANODE ;
        Queue<TreeNode> queue = new LinkedList<>() ;
        System.out.print("Insert data for root : ") ;
        DATANODE = new Scanner(System.in).nextInt() ;
        root = new TreeNode(DATANODE) ;
        queue.add(root) ;
        while (!queue.isEmpty()) {
            TreeNode front = queue.remove() ;
            System.out.print("Insert data for left  node "+front.val+" : ") ;
            DATANODE = new Scanner(System.in).nextInt() ;
            if (DATANODE != -1) {
                front.left = new TreeNode(DATANODE) ;
                queue.add(front.left) ;
            }
            System.out.print("Insert data for right node "+front.val+" : ") ;
            DATANODE = new Scanner(System.in).nextInt() ;
            if (DATANODE != -1) {
                front.right = new TreeNode(DATANODE) ;
                queue.add(front.right) ;
            }
        }
        return root ;
    }
    public void PrintTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>() ;
        queue.add(root) ;
        queue.add(null) ; // indicator of completion of a certain level :::
        while (!queue.isEmpty()) {
            TreeNode front = queue.remove() ;
            if (front == null) { // one level is traversed :::
                System.out.println() ;
                if (!queue.isEmpty())
                    queue.add(null) ; // indicates end of next level :::
            }
            else {
                System.out.print("-> "+front.val) ;
                if (front.left != null)
                    queue.add(front.left)  ;
                if (front.right != null)
                    queue.add(front.right) ;
            }
        }
    }
}
