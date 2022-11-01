package Lv1;

import Lv0.TreeFormation;

import java.util.*;

public class Zig_Zag_Traversal {
    public static void main(String[] args) {
        TreeFormation.TreeNode root = TreeFormation.formTreeByLevel(null) ;
        System.out.println("Zig Zag : ") ;
        System.out.println(_zig_zag(root)) ;
    }
    public static ArrayList<ArrayList<Integer>> _zig_zag(TreeFormation.TreeNode root) {
        ArrayList<ArrayList<Integer>> outerList = new ArrayList<>();
        if (root == null)
            return new ArrayList<>(outerList);
        boolean _left_To_right_ = true;
        Deque<TreeFormation.TreeNode> queue = new ArrayDeque<>();
        queue.add(root) ;
        while (!queue.isEmpty()) {
            int size = queue.size(); // ***
            ArrayList<Integer> innerList = new ArrayList<>() ;
            if (_left_To_right_) {
                for (int i = 0; i < size; i++) {
                    TreeFormation.TreeNode temp = queue.pollFirst() ;
                    innerList.add(temp.data) ;
                    if(temp.left!=null)
                        queue.addLast(temp.left);
                    if(temp.right!=null)
                        queue.addLast(temp.right);
                }
                outerList.add(new ArrayList<>(innerList)) ;
                _left_To_right_ = false ;
            } else {
                for (int i = 0; i < size; i++) {
                    TreeFormation.TreeNode temp = queue.pollLast() ;
                    innerList.add(temp.data) ;
                    if(temp.left!=null)
                        queue.addFirst(temp.left);
                    if(temp.right!=null)
                        queue.addFirst(temp.right);
                }
                outerList.add(new ArrayList<>(innerList)) ;
                _left_To_right_ = true ;
            }
        }
        return new ArrayList<>(outerList) ;
    }
}