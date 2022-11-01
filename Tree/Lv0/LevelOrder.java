package Lv0;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public static List<List<Integer>> levelOrder(TreeFormation.TreeNode root){
        List<List<Integer>> OuterList = new ArrayList<>() ;
        if(root == null)
            return OuterList;
        Queue<TreeFormation.TreeNode> queue = new LinkedList<>() ;
        queue.add(root) ;
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>() ;
            int length = queue.size() ;
            for(int i = 0 ; i < length ; i++){
                TreeFormation.TreeNode temp = queue.remove() ;
                if(temp!=null) {
                    list.add(temp.data);
                    if (temp.left != null)
                        queue.add(temp.left);
                    if (temp.right != null)
                        queue.add(temp.right);
                }
            }
            OuterList.add(list) ;
        }
        return OuterList ;
    }

    public static void main(String[] args) {
        TreeFormation.TreeNode root = TreeFormation.formTree(null) ;
        System.out.println("Level Order Traversal : ") ;
        List<List<Integer>> storeList = levelOrder(root) ;
        System.out.println("Level Order : "+storeList) ;
        System.out.println("Maximum height of binary tree : "+storeList.size());
    }
}
