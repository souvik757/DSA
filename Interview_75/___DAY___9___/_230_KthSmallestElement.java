import java.util.Scanner ;
public class _230_KthSmallestElement {
    public static void main(String[] args) {
        SOLVEDAY9 object = new SOLVEDAY9() ;
        TreeNode BSTroot = new TreeNode() ;
        BSTroot = BSTroot.FormByLevel(BSTroot) ;
        BSTroot.ShowByLevel(BSTroot) ;
        System.out.print("K : ");
        int k = new Scanner(System.in).nextInt() ;
        System.out.print(k+"th smallest :"+object.kthSmallest(BSTroot,k));
    }
}
