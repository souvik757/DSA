package Lv0;

import java.util.ArrayList;
import java.util.List;

public class MorrisTraversal {
    public static void main(String[] args) {
        PerformMorrisTraversal object = new PerformMorrisTraversal() ;
        TreeFormation.TreeNode root = new TreeFormation.TreeNode() ;
        root = TreeFormation.formTreeByLevel(root) ;
        object.InorderMorris(root) ;
    }
}
class PerformMorrisTraversal{
    public void InorderMorris(TreeFormation.TreeNode root){
        List<Integer> list = new ArrayList<>() ;
        if(root == null)
            System.out.println();
        TreeFormation.TreeNode temp = root ;

        while (temp != null){
            if(temp.left == null){
                list.add(temp.data) ;
                temp = temp.right ;
            }
            else{
                TreeFormation.TreeNode prev = temp.left ;
                while (prev.right != null && prev.right != temp){
                    prev = prev.right ;
                }
                if(prev.right == null){
                    prev.right = temp ;
                    temp = temp.left ;
                }
                else {
                    prev.right = null ;
                    list.add(temp.data) ;
                    temp = temp.right ;
                }
            }
        }
        System.out.println(list);
    }
}
