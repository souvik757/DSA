package Lv1;

import Lv0.TreeFormation;

import java.util.ArrayList;
import java.util.List;

public class path_sum_II {
    public static void main(String[] args) {
        path_sum_II result = new path_sum_II() ;
        TreeFormation.TreeNode root = new TreeFormation.TreeNode() ;
        root = TreeFormation.formTreeByLevel(root) ;
        List<List<Integer>> ans = new ArrayList<>() ;
        List<Integer> _list_ = new ArrayList<>() ;
        result.solve(root , ans  ,_list_ , 5);
        System.out.println(ans);

    }
    public void solve(TreeFormation.TreeNode root ,List<List<Integer>> ans ,
                      List<Integer> _list_ , int k){
        if(root == null)
            return ;
        _list_.add(root.data) ;
        if(root.left == null && root.right == null){
            if(root.data == k)
                ans.add(new ArrayList<>(_list_));
            return ;
        }
        if(root.left != null){
            solve(root.left ,ans , _list_ ,  k-root.data);
            _list_.remove(_list_.size() - 1 ) ;
        }
        if(root.right != null){
            solve(root.right ,ans,  _list_ ,  k-root.data);
            _list_.remove(_list_.size() - 1 ) ;
        }
    }
}
