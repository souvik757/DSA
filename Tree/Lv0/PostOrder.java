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
public class PostOrder {
    public static List<Integer> storeList = new ArrayList<>() ;
    public static void postOrder(TreeFormation.TreeNode root){
        if(root == null){
            return ;
        }
        postOrder(root.left) ;
        postOrder(root.right) ;
        storeList.add(root.data) ;
    }
    public static void main(String[] args) {
        TreeFormation.TreeNode root = null ;
        root = TreeFormation.formTree(root) ;
        System.out.println("Post Order : ") ;
        postOrder(root) ;
        System.out.println(storeList);
    }
}