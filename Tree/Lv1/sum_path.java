package Lv1;

import Lv0.TreeFormation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class sum_path {
    static int count = 0 ;
    public static void main(String[] args) {
        sum_path result = new sum_path() ;
        TreeFormation.TreeNode root = new TreeFormation.TreeNode() ;
        root = TreeFormation.formTreeByLevel(root) ;
        System.out.print("Sum : ");
        int k = new Scanner(System.in).nextInt() ;
        List<Integer> ans = new ArrayList<>() ;
        result.solve(root , ans , k) ;
        System.out.println("count : "+count) ;
    }
    public void solve(TreeFormation.TreeNode root , List<Integer> ans , int k){
        if(root == null)
            return ;
        ans.add(root.data) ;
        solve(root.left  , ans , k) ;
        solve(root.right , ans , k) ;
        long sum = 0 ;
        int size = ans.size() ;
        System.out.println(ans);
        for(int i = size-1 ; i >= 0 ; i--){
            sum += ans.get(i) ;
            if(sum == k)
                count++ ;
        }
        ans.remove(size-1) ;
    }
}
