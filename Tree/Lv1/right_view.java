package Lv1;

import Lv0.TreeFormation;

import java.util.ArrayList;
import java.util.List;

public class right_view {
    public static void main(String[] args) {
        TreeFormation.TreeNode root = new TreeFormation.TreeNode() ;
        root = TreeFormation.formTreeByLevel(root) ;
        List<Integer> ans = new ArrayList<>() ;
        new right_view().solve(ans , root , 0) ;
        System.out.println("Right View : "+ans);
    }
    public void solve(List<Integer> ans , TreeFormation.TreeNode root , int level){
        //System.out.println("level : "+level+" ans.size() : "+ans.size());
        if(root == null)
            return ;
        // entered a new level ->
        if(level == ans.size()) {
            //System.out.println("addition for : level ->"+level+" ans.size ->"+ans.size());
            ans.add(root.data);
        }

        // to print left view, we go first to the right branch
        solve(ans , root.right , level+1) ;
        solve(ans , root.left , level+1) ;

    }
}
