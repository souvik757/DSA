package Lv1;

import Lv0.TreeFormation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class diagonal_view {
    public static void main(String[] args) {
        _vertical_ result = new _vertical_() ;
        TreeFormation.TreeNode root = new TreeFormation.TreeNode() ;
        root = TreeFormation.formTreeByLevel(root) ;
        System.out.println(result.getVerticalTraversedTree(root));
    }
}
class _vertical_{
    public void solve(TreeFormation.TreeNode root , TreeMap<Integer , List<Integer>> map , int hd){
        if(root == null)
            return ;
        List<Integer> _list_ = map.get(hd) ;
        if(_list_ == null)
        {
            _list_ = new ArrayList<>() ;
            _list_.add(root.data) ;
        }
        else
            _list_.add(root.data) ;
        map.put(hd , _list_) ;
        solve(root.left , map , hd-1);
        solve(root.right , map , hd);
    }
    public List<List<Integer>> getVerticalTraversedTree(TreeFormation.TreeNode root){
        TreeMap<Integer , List<Integer>> map = new TreeMap<>() ;
        List<List<Integer>> _list_ = new ArrayList<>() ;
        solve(root , map , 0);
        for(Map.Entry<Integer , List<Integer>> entry : map.entrySet())
            _list_.add(entry.getValue()) ;
        return _list_ ;
    }
}
