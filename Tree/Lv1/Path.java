package Lv1;

import Lv0.TreeFormation;

import java.util.ArrayList;
import java.util.List;

public class Path {
    static List<String> ans = new ArrayList<>() ;
    public static void main(String[] args) {
        TreeFormation.TreeNode root = TreeFormation.formTreeByLevel(null) ;
        System.out.println("Every possible path from "+root.data+
                " to every leaf node :");
        String bisector = "" ;
        Get_Path(root , bisector) ;
        System.out.println(ans);
    }
    public static void Get_Path(TreeFormation.TreeNode root ,
                                String x){
        if(root==null)
            return;
        x = x+root.data ; // '+' does concatenation
        if(root.left==null&&root.right==null){
            ans.add(x) ;
            return;
        }
        x = x+"->" ;
        Get_Path(root.left , x);
        Get_Path(root.right , x);
    }

}
