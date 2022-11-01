package Lv0;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {
    public static int depth(TreeFormation.TreeNode root){
        int depth_max = 0;
        if(root == null){
            return 0 ;
        }
        Queue<TreeFormation.TreeNode> queue = new LinkedList<>() ;
        queue.add(root) ;
        queue.add(null) ; // as a separator of each level :
        while (!queue.isEmpty()){
            TreeFormation.TreeNode temp = queue.peek() ;
            // store top element before deletion :
            queue.poll() ;
            if(temp == null){
                if(!queue.isEmpty()){ // if queue is empty , then it already reached last to a level :
                    queue.add(null) ;
                }
                depth_max++ ;
            }
            else{
                if(temp.left != null){
                    queue.add(temp.left) ;
                }
                if(temp.right != null){
                    queue.add(temp.right) ;
                }
            }
        }
    return depth_max ;
    }
    public static void main(String[] args) {
        TreeFormation.TreeNode root = null ;
        root = TreeFormation.formTree(root) ;

        System.out.println("Tree : ");
        TreeFormation.LevelOrderTraversal(root) ;

        System.out.println("Maximum depth : "+depth(root));
    }
}
