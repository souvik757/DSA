package Lv1;

public class _124_MaxPathSum {
    public static void main(String[] args) {
        solve_124 object = new solve_124() ;
        TreeNode root = new TreeNode() ;
        root = root.FormTreeByLevel(root) ;
        root.ShowByLevel(root) ;
        System.out.println(object.maxPathSum(root));
    }
}
class solve_124{
    private int maxSum = Integer.MIN_VALUE ;
    public int maxPathSum(TreeNode root) {
        int x = solve(root) ;
        return Math.max(maxSum,x) ;
    }

    private int solve(TreeNode root) {
        if(root == null)
            return 0 ;
        int leftSum  = Math.max(0,solve(root.left))  ;
        int rightSum = Math.max(0,solve(root.right)) ;
        maxSum = Math.max(maxSum , root.data+leftSum+rightSum) ;

        return root.data + Math.max(leftSum,rightSum) ;
    }
}