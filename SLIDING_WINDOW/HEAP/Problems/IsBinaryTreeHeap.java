package HEAP.Problems;

import java.util.Queue ;
import java.util.LinkedList ;
import java.util.Scanner;

public class IsBinaryTreeHeap {
    public static void main(String[] args) {
        SOLVE object = new SOLVE() ;
        TreeNode root = new TreeNode(-1) ;
        root = root.CreateByLevel(root) ;
        root.ShowByLevel(root);
        System.out.println("Node count : "+root.count);
        System.out.println("Is below binary tree a MaxHeap ?"+" -> "+object.ismaxHeap(root));
        System.out.println("Is below binary tree a MinHeap ?"+" -> "+object.isminHeap(root));
    }
}
class SOLVE{
    public boolean ismaxHeap(TreeNode root){
        if(root == null)
            return true ;
        return root.IsCBT(root, 0) && root.IsMaxHeap(root);
    }
    public boolean isminHeap(TreeNode root){
        if(root == null)
            return true ;
        return root.IsCBT(root, 0) && root.IsMinHeap(root);
    }
}
// Binary Tree
// CreateByLevel()
// ShowByLevel()
// IsCBT()
// IsMaxHeap()
// IsMinHeap()
class TreeNode{
    int count = 0 ; // counts number of nodes in the binary tree
    int val ;
    TreeNode left ;
    TreeNode right ;
    public TreeNode(int val){
        this.val = val ;
        this.left = null ;
        this.right = null ;
    }

    public TreeNode CreateByLevel(TreeNode root){
        int val ;
        Queue<TreeNode> queue = new LinkedList<>() ;
        System.out.print("Insert head value : ");
        val = new Scanner(System.in).nextInt() ;
        root = new TreeNode(val) ;
        queue.add(root) ;

        while (!queue.isEmpty()){
            TreeNode temp = queue.remove() ;
            System.out.print("left  node of "+temp.val+" : ");
            val = new Scanner(System.in).nextInt() ;
            if(val != -1){
                temp.left = new TreeNode(val) ;
                queue.add(temp.left) ;
            }
            System.out.print("right node of "+temp.val+" : ");
            val = new Scanner(System.in).nextInt() ;
            if(val != -1){
                temp.right = new TreeNode(val) ;
                queue.add(temp.right) ;
            }
        }

        return root ;
    }

    public void ShowByLevel(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>() ;
        queue.add(root) ;
        queue.add(null) ;

        while (!queue.isEmpty()){
            TreeNode temp = queue.remove() ;
            if(temp == null){
                System.out.println();
                if(!queue.isEmpty())
                    queue.add(null) ;
            }
            else {
                count++ ; // for node count
                System.out.print("-> "+temp.val);
                if(temp.left != null) {
                    queue.add(temp.left);
                }
                if(temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
    }
    public boolean IsCBT(TreeNode root , int index){
        if(root == null) return true ;
        if(index >= count) return false ;
        else{
            boolean leftAns  = IsCBT(root.left  , 2*index + 1) ;
            boolean rightAns = IsCBT(root.right , 2*index + 2) ;
            return leftAns && rightAns ;
        }
    }
    public boolean IsMaxHeap(TreeNode root){
        if(root.left == null && root.right == null)
            return true ;
        if(root.right == null)
            return root.val > root.left.val ;
        else {
            boolean leftAns  = IsMaxHeap(root.left)  ;
            boolean rightAns = IsMaxHeap(root.right) ;
            return (leftAns && rightAns) && (root.val > root.left.val && root.val > root.right.val) ;
        }
    }
    public boolean IsMinHeap(TreeNode root){
        if(root.left == null && root.right == null)
            return true ;
        if(root.right == null)
            return root.val < root.left.val ;
        else {
            boolean leftAns  = IsMinHeap(root.left)  ;
            boolean rightAns = IsMinHeap(root.right) ;
            return (leftAns && rightAns) && (root.val < root.left.val && root.val < root.right.val) ;
        }
    }
}