package Lv1;
import Lv0.* ;
public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        TreeFormation.TreeNode root = null ;
        root = TreeFormation.formTreeByLevel(root) ;
        System.out.println("Diameter of binary tree : "+
                GetDiameter(root)) ;
    }
    // Brute Force : O(n^2)
    public static int GetDiameter(TreeFormation.TreeNode node){
        if(node == null)
            return 0 ;
        int left_diameter = GetDiameter(node.left) ;
        int right_diameter = GetDiameter(node.right) ;
        int self_diameter = HeightOfBinaryTree.FindHeight(node.left) +
                HeightOfBinaryTree.FindHeight(node.right) + 1 ;

        int diameter = Math.max(left_diameter ,
                Math.max(right_diameter , self_diameter)) ;

        return diameter + 1 ;
    }
}