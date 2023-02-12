package Lv1;

import Lv0.*;

public class height_of_certain_node {
    static int height = 0 ;
    public static void main(String[] args) {
        TreeFormation.TreeNode root = TreeFormation.formTreeByLevel(null) ;
        _Height_(root, 20) ;
        int result = HeightOfBinaryTree.FindHeight(root) ;
        System.out.println("Heigth of tree : "+result);
        System.out.println("Height of 20 : "+height+
                "\nDepth of 20 : "+(result - height));

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
