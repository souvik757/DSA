package Lv1 ;
// Sum of left subtree + Sum of right subtree == Sum of root ::: It is called a sum tree
public class SumTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode() ;
        root = root.FormTreeByLevel(root) ;
        root.ShowByLevel(root);
        System.out.println("Is sum tree ? "+solveIsSumTree.is_sum_tree(root).isTruth());
    }
}
class solveIsSumTree {
    public static modelPair is_sum_tree(TreeNode treeNode){
        // if root does not exist || to manage outOfBound edge case
        if(treeNode == null)
            return new modelPair(true, 0);
        // if leaf node collect the data of that node to sum :
        if(treeNode.left == null && treeNode.right == null)
            return new modelPair(true, treeNode.data);
        // go to left
        modelPair Left = is_sum_tree(treeNode.left) ;
        // go to right
        modelPair Right = is_sum_tree(treeNode.right) ;

        boolean LeftAns = Left.isTruth() ;
        boolean RightAns = Right.isTruth() ;
        boolean Condition = treeNode.data==Left.getValue()+Right.getValue() ;

        return new modelPair(LeftAns && RightAns && Condition, 2 * treeNode.data);
    }
    static class modelPair {
        public boolean Truth ;
        public int value ;
        public modelPair(boolean Truth , int value){
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
}

