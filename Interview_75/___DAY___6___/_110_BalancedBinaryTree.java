public class _110_BalancedBinaryTree {
    public static void main(String[] args) {
        SOLVEDAY6 object = new SOLVEDAY6() ;
        TreeNode root = new TreeNode() ;
        root = root.InsertByLevel(root) ;
        root.PrintTree(root);
        System.out.println("It is balanced ? " + object.isBalanced(root));
    }
}
