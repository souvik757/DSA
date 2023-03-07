package Lv1;

import Lv0.*;

import java.util.*;

public class _vertical_traversal_ {
    public static void main(String[] args) {
        TreeFormation.TreeNode root = new TreeFormation.TreeNode();
        traverse ins = new traverse() ;
        root = TreeFormation.formTreeByLevel(root) ;
        ins._display_vertical_(root) ;
    }

}
class traverse{
    public void _traversed_list_(TreeFormation.TreeNode root , int hd ,
                                 TreeMap<Integer , List<Integer>> map){
        // base case ->
        if(root==null)
            return ;
        // 1 . storing list for each horizontal distance from root ->
        List<Integer> _list_ = map.get(hd) ;
        // 2 . if list is null initialize it and add value of current node ->
        if(_list_ == null)
        {
            _list_ = new ArrayList<>() ;
            _list_.add(root.data) ;
        }
        else // 3 . add value of current node even if list is non-null ->
            _list_.add(root.data) ;
        // 4 . add the list to the map with respect to the current horizontal distance from root ->
        map.put(hd , _list_) ;
        // 5 . traverse to left ->
        _traversed_list_(root.left , hd-1 , map) ;
        // 6 . traverse to right ->
        _traversed_list_(root.right , hd+1 , map) ;
    }
    public void _display_vertical_(TreeFormation.TreeNode root){
        int hd = 0 ;
        TreeMap<Integer , List<Integer>> map = new TreeMap<>() ;
        _traversed_list_(root , hd , map);
        System.out.println("Vertical view -> ");
        for(Map.Entry<Integer , List<Integer>> entry : map.entrySet()){
            System.out.print(entry.getValue());
        }
    }
}
