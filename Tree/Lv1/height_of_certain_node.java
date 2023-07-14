package Lv1;

import Lv0.*;

import java.util.LinkedList;
import java.util.Queue;

public class height_of_certain_node {
    static int height = 0 ;
    public static void main(String[] args) {
        TreeNode root = new TreeNode() ;
        root = root.FormTreeByLevel(root) ;
        SOLUTION object = new SOLUTION() ;
        object.depthOf(root , 15) ;
//        TreeFormation.TreeNode root = TreeFormation.formTreeByLevel(null) ;
//        int result  = _Height_(root, 15) ;
//        System.out.println("Height of tree : "+result);
//        System.out.println("Height of 20 : "+height+
//                "\nDepth of 20 : "+(result - height));
    }
    public static int _Height_(TreeFormation.TreeNode root , int x){
        if(root==null)
            return -1 ;
        int leftHeight = _Height_(root.left , x) ;
        int rightHeight = _Height_(root.right , x) ;
        int ans = Math.max(leftHeight , rightHeight) + 1 ;
        if(root.data == x)
            height = ans ;
        return ans ;
    }
}
class SOLUTION {
    public int height = 0 ;
    public String depthOf(TreeNode root , int target){
        if (root == null)
            return "invalid input" ;

        Queue<TreeNode> queue = new LinkedList<>() ;
        queue.add(root) ;
        queue.add(null) ;
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll() ;
            if (temp == null){
                height ++ ;
                if (!queue.isEmpty())
                    queue.add(null) ;
            }
            else{
                if(temp.data == target)
                    return "-> depth of "+target+" : "+height ;
                if (temp.left != null)
                    queue.add(temp.left) ;
                if (temp.right != null)
                    queue.add(temp.right) ;
            }
        }

        return "no such node" ;
    }
}