package Lv1 ;

import Lv0.* ;

public class HeightOfBinaryTree {
    public static void main(String[] args) {
        TreeFormation.TreeNode root = new TreeFormation.TreeNode() ;
        root = TreeFormation.formTreeByLevel(root) ;
        System.out.println("Given tree : "+ LevelOrder.levelOrder(root)) ;

        System.out.println("Height of binary tree : "+FindHeight(root)) ;
    }

    public static int FindHeight(TreeFormation.TreeNode node) {
        if(node == null)
            return -1 ;

        int left = FindHeight(node.left) ;
        int right = FindHeight(node.right) ;

        return Math.max(left , right) + 1 ;
    }
}