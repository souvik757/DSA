public class _226_InvertBinaryTree {
    public static void main(String[] args) {
        SOLVEDAY6 object = new SOLVEDAY6() ;
        TreeNode root = new TreeNode() ;
        root = root.InsertByLevel(root) ;
        System.out.println("Before invert : ") ;
        root.PrintTree(root)     ;
        root = object.invertedTree(root) ;
        System.out.println("After invert : ") ;
        root.PrintTree(root) ;
    }
}
