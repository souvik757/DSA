package Lv1 ;

import Lv0.TreeFormation;

public class IsBalanced {
    public static void main(String[] args) {

        TreeFormation.TreeNode root = TreeFormation.formTreeByLevel(null) ;

        System.out.println("Is balanced ?  : " + Isbalanced(root)) ;
        System.out.println(is_balanced(root).isA());
    }

    public static boolean Isbalanced(TreeFormation.TreeNode root){

        if(root == null)
            return true ;

        boolean leftVal = Isbalanced(root.left) ;

        boolean rightVal = Isbalanced(root.right) ;

        boolean condition =
                Math.abs(HeightOfBinaryTree.FindHeight(root.left) -
                                      HeightOfBinaryTree.FindHeight(root.right)) <= 1 ;


        return leftVal &&
                          rightVal &&
                                       condition ;
        // If 3 conditions are true , then tree is balanced .
    }
    // O(n) solution :
    public static Pair is_balanced(TreeFormation.TreeNode root){
        if(root == null)
            return new Pair(true , 0) ;

        Pair Left = is_balanced(root.left) ;// going left Subtree
        Pair Right = is_balanced(root.right) ;// going right Subtree

        boolean leftAns = Left.isA() ;
        boolean rightAns = Right.isA() ;
        boolean diff = Math.abs(Left.getB() - Right.getB()) <= 1 ;

        return new Pair( leftAns && rightAns && diff, Math.max(Left.getB() , Right.getB()) + 1) ;

    }

    public static class Pair{
        private boolean a ;
        private int b ;

        public Pair(boolean a, int b) {
            this.a = a;
            this.b = b;
        }

        public boolean isA() {
            return a;
        }

        public int getB() {
            return b;
        }
    }

}
