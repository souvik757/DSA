package Lv2;

import java.util.LinkedList;
import java.util.Queue;

public class _222_CountNodeCBT {
    public static void main(String[] args) {

    }
}
class SOLVE_222{
    public int countNodes(TreeNode root) {
        return GetCount(root , 0) ;
    }
    private int GetCount(TreeNode root , int count){
        Queue<TreeNode> queue = new LinkedList<>() ;
        queue.add(root) ;
        while (!queue.isEmpty()){
            TreeNode temp = queue.remove() ;
            if(temp != null){
                count++ ;
                if (temp.left != null)
                    queue.add(temp.left) ;
                if (temp.right != null)
                    queue.add(temp.right) ;
            }
        }

        return count ;
    }
    private int _Get_Count_(TreeNode root){ // for CBT
        if(root == null) return 0 ;
        if(root.left == null && root.right == null) return 1 ;
        if(root.right == null) return 2 ;

        return 1 + _Get_Count_(root.left) + _Get_Count_(root.right) ;
    }
}