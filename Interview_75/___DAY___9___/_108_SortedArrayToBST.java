public class _108_SortedArrayToBST {
    public static void main(String[] args) {
        SOLVEDAY9 object = new SOLVEDAY9() ;
        TreeNode root = object.sortedArrayToBST(new int[]{-10,-3,0,5,9}) ;
        root.ShowByLevel(root);
    }
}
