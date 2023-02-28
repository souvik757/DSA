package Lv1;

import Lv0.TreeFormation;

public class _max_leaf_ {
    public static void main(String[] args) {
        TreeFormation.TreeNode root = TreeFormation.formTreeByLevel(null) ;
        int _power_ = new _solve_()._get_0th_indexed_height_(root) ;
        System.out.println("Max leaf : "+(int)Math.pow(2, _power_));
    }
}
class _solve_{
    public int _get_0th_indexed_height_(TreeFormation.TreeNode root){
        if(root == null)
            return -1 ;
        int Left = _get_0th_indexed_height_(root.left) ;
        int Right = _get_0th_indexed_height_(root.right) ;
        return Math.max(Left , Right) + 1 ;
    }
}
