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

public class InOrder {
    public static List<Integer> storeList = new ArrayList<>() ;
    public static void inOrder(TreeFormation.TreeNode root){
        if(root == null){
            return ;
        }
        inOrder(root.left) ;
        storeList.add(root.data) ;
        inOrder(root.right) ;
    }

    public static void main(String[] args) {
        TreeFormation.TreeNode root = null ;
        root = TreeFormation.formTree(root) ;
        System.out.println(" InOrder : ");
        inOrder(root) ;
        System.out.println(storeList) ;
    }
}