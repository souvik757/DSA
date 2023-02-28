package Lv1;

import Lv0.TreeFormation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _Second_Smallest_element_ {
    public static void main(String[] args) {
        TreeFormation.TreeNode root = TreeFormation.formTreeByLevel(null) ;
        System.out.println(new SOLVE()._2ndSmall_(root)) ;
    }
}
class SOLVE{
    public int _2ndSmall_(TreeFormation.TreeNode root){
        if(root==null) return -1 ;
        List<Integer> _store_ = new ArrayList<>() ;
        _fill_(root , _store_) ;
        int[] myArr = new int[_store_.size()] ;
        for(int i = 0 ; i < _store_.size() ; i++){
            myArr[i] = _store_.get(i) ;
        }
        Arrays.sort(myArr);
        int ans = -1 ;
        for(int i = 0 ; i < myArr.length - 1 ; i++){
            if(myArr[i+1] > myArr[i]) {
                ans = myArr[i + 1];
                break;
            }
        }
        return ans ;
    }
    public void _fill_(TreeFormation.TreeNode root, List<Integer> list){
        if(root==null)
            return;
        list.add(root.data) ;
        _fill_(root.left , list);
        _fill_(root.right , list);
    }
}
