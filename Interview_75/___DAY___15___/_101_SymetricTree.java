public class _101_SymetricTree {
    public static void main(String[] args) {
        SOLVEDAY15 object = new SOLVEDAY15() ;
        TreeNode root1 = new TreeNode() ;
        root1 = root1.FormTreeByLevel(root1) ;
        root1.ShowTreeByLevel(root1);
        System.out.println("Is tree Symetric ? "+object.isSymmetric(root1));
    }
}
