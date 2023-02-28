package Lv1;

import Lv0.TreeFormation;

import java.util.ArrayList;
import java.util.List;

public class _boundary_traversal_ {
    public static void main(String[] args) {
        TreeFormation.TreeNode root = TreeFormation.formTreeByLevel(null) ;
        _solve func = new _solve() ;
        List<Integer> _list_ = new ArrayList<>() ;
        _list_.add(root.data) ;
        func.traverse_left(root.left , _list_);
        // left subtree leafs :
        func.traverse_leaf(root.left , _list_);
        // right subtree leafs :
        func.traverse_leaf(root.right , _list_);

        func.traverse_right(root.right , _list_);

        System.out.println("Boundary nodes : "+_list_);
    }
}
class _solve{
    public void traverse_left(TreeFormation.TreeNode root , List<Integer> ans){
        if((root == null) || (root.left==null && root.right==null))
            return ;
        ans.add(root.data) ;
        if(root.left != null)
            traverse_left(root.left , ans);
        else
            traverse_left(root.right , ans);
    }
    public void traverse_leaf(TreeFormation.TreeNode root , List<Integer> ans){
        if(root == null)
            return ;
        if(root.left==null && root.right==null)
            ans.add(root.data) ;
        traverse_leaf(root.left , ans);
        traverse_leaf(root.right , ans);
    }
    public void traverse_right(TreeFormation.TreeNode root , List<Integer> ans){
        if((root == null) || (root.left==null && root.right==null))
            return ;
        if(root.right!=null)
            traverse_right(root.right , ans);
        else
            traverse_right(root.left , ans);
        ans.add(root.data) ;
    }
}
