import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

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
    public int height(TreeNode root){
        if (root == null) return -1 ;
        int Left = height(root.left) ;
        int Right = height(root.right) ;
        return Math.max(Left,Right) + 1 ;
    }
    public TreeNode FormTreeByLevel(TreeNode root){
        int NodeValue ;
        Queue<TreeNode> queue = new LinkedList<>() ;
        System.out.print("Enter value for root : ") ;
        NodeValue = new Scanner(System.in).nextInt() ;
        root = new TreeNode(NodeValue) ;
        queue.add(root) ;
        while (!queue.isEmpty()) {
            TreeNode front = queue.remove() ;
            System.out.print("Enter value for left  node of "+front.val+" : ");
            NodeValue = new Scanner(System.in).nextInt() ;
            if (NodeValue != -1){
                front.left = new TreeNode(NodeValue) ;
                queue.add(front.left) ;
            }
            System.out.print("Enter value for right node of "+front.val+" : ");
            NodeValue = new Scanner(System.in).nextInt() ;
            if (NodeValue != -1) {
                front.right = new TreeNode(NodeValue) ;
                queue.add(front.right) ;
            }
        }
        return root ;
    }
    public void PrintByLevel(TreeNode root) {
        if (root == null) return ;
        Queue<TreeNode> queue = new LinkedList<>() ;
        queue.add(root) ;
        queue.add(null) ; // indicates end of a level :::

        while (!queue.isEmpty()) {
            TreeNode front = queue.remove() ;
            if (front == null){
                System.out.println();
                if (!queue.isEmpty())
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
