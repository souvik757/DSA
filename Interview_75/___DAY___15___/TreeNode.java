import java.util.Scanner ;
import java.util.Queue ;
import java.util.LinkedList ;
public class TreeNode {
    int val ;
    TreeNode left ;
    TreeNode right ;
    public TreeNode(){}
    public TreeNode(int val){
        this.val = val ;
        this.left = null ;
        this.right = null ;
    }
    public TreeNode FormTreeByLevel(TreeNode root) {
        int data ; // var to store node values :::
        System.out.print("Enter value for root : ");
        data = new Scanner(System.in).nextInt() ;
        root = new TreeNode(data) ;
        Queue<TreeNode> queue = new LinkedList<>() ;
        queue.add(root) ;
        while (!queue.isEmpty()) {
            TreeNode front  = queue.remove() ;
            System.out.print("Enter value for left  node of "+front.val+" : ");
            data = new Scanner(System.in).nextInt() ;
            if (data != -1) { // treat '-1' as null :::
                front.left = new TreeNode(data) ;
                queue.add(front.left) ;
            }
            System.out.print("Enter value for right node of "+front.val+" : ");
            data = new Scanner(System.in).nextInt() ;
            if (data != -1) { // treat '-1' as null :::
                front.right = new TreeNode(data) ;
                queue.add(front.right) ;
            }
        }
        return root ;
    }
    public void ShowTreeByLevel(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>() ;
        queue.add(root) ;
        queue.add(null) ;// indicator to indicate that we have reached end of a certain level :::
        while (!queue.isEmpty()) {
            TreeNode front = queue.poll() ;
            if (front == null) {
                System.out.println();// next level ::
                if (!queue.isEmpty()) // not empty yet :::
                    queue.add(null) ;
            }
            else {
                System.out.print("-> "+front.val) ;
                if (front.left != null)
                    queue.add(front.left) ;
                if (front.right != null)
                    queue.add(front.right) ;
            }
        }
    }

}
