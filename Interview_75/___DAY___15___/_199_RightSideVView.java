public class _199_RightSideVView {
    public static void main(String[] args) {
        SOLVEDAY15 object = new SOLVEDAY15() ;
        TreeNode root = new TreeNode() ;
        root = root.FormTreeByLevel(root) ;
        root.ShowTreeByLevel(root) ;
        System.out.println("Right View : "+object.rightSideView(root));
    }
}
