package Lv1;

import Lv0.TreeFormation;

public class Binary_Tree_Tilt {
    public static void main(String[] args) {
        TreeFormation.TreeNode root = TreeFormation.formTreeByLevel(null) ;
        solution solution = new solution() ;
        solution._Tilt_(root) ;
        System.out.println(solution.Total_tilt);
    }
}
class solution{
    int Total_tilt = 0 ;
    public int _Tilt_(TreeFormation.TreeNode root){
        if(root==null) return 0 ;

        int Left = _Tilt_(root.left) ;
        int Right = _Tilt_(root.right) ;

        int _tilt_ = Math.abs(Left - Right) ;
        Total_tilt += _tilt_ ;


        return root.data + Left + Right ;
    }
}
/*
                  4
              2        9
          3       5         7
 */