package Lv2;

import Lv0.TreeFormation;

public class _validate_binary_search_tree_{
    public static void main(String[] args) {
        _validate_binary_search_tree_ result = new _validate_binary_search_tree_() ;
        TreeFormation.TreeNode root = new TreeFormation.TreeNode() ;
        root = TreeFormation.formTreeByLevel(root) ;
        System.out.println(result._is_search_tree(root));

    }

    public boolean _is_search_tree(TreeFormation.TreeNode root) {
        return _check_(root , -1 , -1);
    }
    public boolean _check_(TreeFormation.TreeNode root , int left , int right){
        if(root == null)
            return true ;
        if(left!= -1 && root.data <= left
        || right!=-1 && root.data >= right)
            return false ;
        boolean Condition1 = _check_(root.left , left , root.data) ;
        boolean Condition2 = _check_(root.right , root.data , right) ;
        return Condition1&&Condition2 ;
    }
}
