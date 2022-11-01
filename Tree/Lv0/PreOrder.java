package Lv0;

import java.util.ArrayList;
import java.util.List;
/*
             1
              .
               .
                3
               .
              .
             5

 */
public class PreOrder {
    public static List<Integer> storeList = new ArrayList<>() ;
    public static void preOrderTraverse(TreeFormation.TreeNode root){
        if(root == null)
            return ;
        storeList.add(root.data) ;
        preOrderTraverse(root.left) ;
        preOrderTraverse(root.right) ;
    }
    public static void main(String[] args) {
        TreeFormation.TreeNode root = null ;
        root = TreeFormation.formTree(root) ;
        preOrderTraverse(root);
        System.out.println(storeList);
    }
}
