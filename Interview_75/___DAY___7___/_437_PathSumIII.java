import java.util.Scanner;

public class _437_PathSumIII {
    public static void main(String[] args) {
        SOLVEDAY7 object = new SOLVEDAY7() ;
        TreeNode root = new TreeNode() ;
        root = root.FormTreeByLevel(root) ;
        root.PrintByLevel(root) ;
        System.out.print("Target sum ::: " );
        int target = new Scanner(System.in).nextInt() ;
        System.out.println("Path Sum : "+object.pathSum(root , target));
    }
}
