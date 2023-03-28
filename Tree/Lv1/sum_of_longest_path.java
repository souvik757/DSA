package Lv1;

import Lv0.TreeFormation;

public class sum_of_longest_path {
    public static void main(String[] args) {
        sum_of_longest_path result = new sum_of_longest_path() ;
        TreeFormation.TreeNode root = new TreeFormation.TreeNode() ;
        root = TreeFormation.formTreeByLevel(root) ;
        System.out.println(result._get_sum_(root));
    }

    public int _get_sum_(TreeFormation.TreeNode root){
        Pair ANS = new Pair(0 , 0) ;
        Pair temp = new Pair() ;
        _solve_(root , 0 , 0 , ANS , temp) ;
        return ANS.sum();
    }
    public void _solve_(TreeFormation.TreeNode root , int lv ,int sum ,  Pair ans, Pair pair){
        if(root == null){
            if(pair.level > ans.level)
                ans.put(pair.sum , pair.level);
            else if (pair.level == ans.level)
                ans.put(Math.max(pair.sum, ans.sum) , ans.level);
        return ;
        }
        sum += root.data ;
        pair.put(sum , lv);

        _solve_(root.left ,lv+1 ,sum , ans , pair) ;
        _solve_(root.right ,lv+1 ,sum , ans , pair) ;
    }

    // modified class ->
    class Pair{
        int sum ;
        int level ;

        public Pair() {
        }

        public Pair(int sum, int level) {
            this.sum = sum;
            this.level = level;
        }
        public void put(int sum , int level){
            this.sum = sum ;
            this.level = level ;
        }
        public int sum(){return this.sum ; }
        public int level(){return this.level ; }
    }
}

