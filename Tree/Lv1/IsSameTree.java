package Lv1;

import Lv0.TreeFormation;

public class IsSameTree {
    public static void main(String[] args) {
        TreeFormation.TreeNode root1 = TreeFormation.formTreeByLevel(null) ;
        TreeFormation.TreeNode root2 = TreeFormation.formTreeByLevel(null) ;
        System.out.println("Is two trees are same ? "+Is_same(root1 , root2));
    }
    public static boolean Is_same(TreeFormation.TreeNode root1 , TreeFormation.TreeNode root2){
        if(root1 == null && root2 == null)
            return true ;
        if(root1 != null && root2 == null)
            return false ;
        if(root2 != null && root1 == null)
            return false ;
        boolean Left = Is_same(root1.left , root2.left) ;
        boolean Right = Is_same(root1.right , root2.right) ;
        boolean current  = root1.data == root2.data ;

        return Left && Right && current ;
    }
}
