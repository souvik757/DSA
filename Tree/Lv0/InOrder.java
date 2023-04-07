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
 --> LVR
 -->Left - Visit - Right
 */

public class InOrder {
    public static List<Integer> storeList = new ArrayList<>() ;
    public static void inOrder(TreeFormation.TreeNode root){
        if(root == null){
            return ;
        }
        inOrder(root.left) ; // L
        storeList.add(root.data) ; // V
        inOrder(root.right) ; // R
    }

    public static void main(String[] args) {
        TreeFormation.TreeNode root = null ;
        root = TreeFormation.formTree(root) ;
        System.out.println(" InOrder : ");
        inOrder(root) ;
        System.out.println(storeList) ;
    }
}