public class _543_DiameterOfBinaryTree {
    public static void main(String[] args) {
        SOLVEDAY7 object = new SOLVEDAY7() ;
        TreeNode root = new TreeNode() ;
        root = root.FormTreeByLevel(root) ;
        root.PrintByLevel(root) ;
        System.out.println("Diameter Of the tree : "+object.diameterOfBinaryTree(root));
    }
}