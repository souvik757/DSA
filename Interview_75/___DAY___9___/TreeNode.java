import java.util.Scanner;
import java.util.Queue ;
import java.util.LinkedList ;
public class TreeNode {
    int val ;
    TreeNode left ;
    TreeNode right ;
    private Scanner scan = new Scanner(System.in) ;
    public TreeNode() {
    }
    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
    public TreeNode FormByLevel(TreeNode root) {
        int NODEVALUE ;
        Queue<TreeNode> queue = new LinkedList<>() ;
        System.out.print("Enter value for root : ");
        NODEVALUE = scan.nextInt() ;
        root = new TreeNode(NODEVALUE) ;
        queue.add(root) ;

        while (!queue.isEmpty()) {
            TreeNode front = queue.remove() ;
            System.out.print("Enter value for left node  of "+front.val+" : ");
            NODEVALUE = scan.nextInt() ;
            if (NODEVALUE != -1)
            {
                front.left = new TreeNode(NODEVALUE) ;
                queue.add(front.left) ;
            }
            System.out.print("Enter value for right node of "+front.val+" : ");
            NODEVALUE = scan.nextInt() ;
            if (NODEVALUE != -1)
            {
                front.right = new TreeNode(NODEVALUE) ;
                queue.add(front.right) ;
            }
        }
        return root ;
    }
    public void ShowByLevel(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>() ;
        queue.add(root) ;
        queue.add(null) ;

        while (!queue.isEmpty()) {
            TreeNode front  = queue.remove() ;

            if (front == null){
                System.out.println();
                if (!queue.isEmpty())
                    queue.add(null) ;
            }
            else {
                System.out.print("-> "+front.val);
                if (front.left != null)
                    queue.add(front.left) ;
                if (front.right != null)
                    queue.add(front.right) ;
            }
        }
    }
}