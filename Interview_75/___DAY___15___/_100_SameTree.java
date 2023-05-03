public class _100_SameTree {
    public static void main(String[] args) {
        SOLVEDAY15 object = new SOLVEDAY15() ;
        TreeNode root1 = new TreeNode() ;
        TreeNode root2 = new TreeNode() ;
        root1 = root1.FormTreeByLevel(root1) ;
        root2 = root2.FormTreeByLevel(root2) ;
        root1.ShowTreeByLevel(root1);
        root2.ShowTreeByLevel(root2);
        System.out.println("Is same tree ? "+object.isSameTree(root1,root2));
    }
}
