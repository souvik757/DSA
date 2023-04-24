import java.util.LinkedList;
import java.util.Queue;

public class SOLVEDAY6 {
    // QUES 226 . Invert Binary Tree :::
    public TreeNode invertedTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>() ;
        queue.add(root) ;
        while (!queue.isEmpty()) {
            TreeNode front = queue.remove() ;
            TreeNode TEMP = front.left; // swap ..
            front.left = front.right; // ...
            front.right = TEMP; // ..swap
            if (front.left != null)
                queue.add(front.left)  ;
            if (front.right != null)
                queue.add(front.right) ;
        }
        return root ;
    } // may not useful for every case ::
    public TreeNode invertTreeRecursive(TreeNode root) {
        if (root == null) return null ;
        TreeNode RIGHT_NODE = invertTreeRecursive(root.right) ;
        TreeNode LEFT_NODE  = invertTreeRecursive(root.left)  ;

        root.left  = RIGHT_NODE ;
        root.right = LEFT_NODE  ;

        return root ;
    }
    // QUES 110 . Balanced Binary Tree :::
    public boolean isBalanced(TreeNode root) {
        return BalancedTree(root).balanced ;
    }
    public Pair<Boolean,Integer> BalancedTree(TreeNode root) {
        if (root == null)
            return new Pair<>(true , 0) ;
        Pair<Boolean,Integer> LeftSubTree  = BalancedTree(root.left ) ;
        Pair<Boolean,Integer> RightSubTree = BalancedTree(root.right) ;

        boolean IsBalancedLeft   = LeftSubTree.balanced  ;
        boolean IsBalancedRight  = RightSubTree.balanced ;
        boolean IsHeightBalanced = Math.abs(LeftSubTree.height - RightSubTree.height) <= 1 ;

        return new Pair<>((IsHeightBalanced&&IsBalancedLeft&&IsBalancedRight) ,
                Math.max(LeftSubTree.height, RightSubTree.height) + 1) ;
    }
}
