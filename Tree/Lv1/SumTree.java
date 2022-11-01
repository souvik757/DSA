package Lv1 ;
import Lv0.TreeFormation ;
// Sum of left subtree = Sum of right subtree :
public class SumTree {
    public static void main(String[] args) {
        TreeFormation.TreeNode root = TreeFormation.formTreeByLevel(null) ;
        System.out.println("Is sum tree ? "+is_sum_tree(root).isTruth());
    }
    public static pair is_sum_tree(TreeFormation.TreeNode root){
        // if root does not exist
        if(root == null)
            return new pair(true , 0) ;
        // if leaf node collect the data of that node to sum :
        if(root.left == null && root.right == null)
            return new pair(true , root.data) ;
        // go to left
        pair Left = is_sum_tree(root.left) ;
        // go to right
        pair Right = is_sum_tree(root.right) ;

        boolean LeftAns = Left.isTruth() ;
        boolean RightAns = Right.isTruth() ;
        boolean Condition = root.data==Left.getValue()+Right.getValue() ;

        return new pair(LeftAns&&RightAns&&Condition , 2* root.data) ;
    }
}
// pair class :
class pair{
    public boolean Truth ;
    public int value ;
    public pair(boolean Truth , int value){
        this.Truth = Truth ;
        this.value = value ;
    }

    public boolean isTruth() {
        return Truth;
    }

    public int getValue() {
        return value;
    }
}

